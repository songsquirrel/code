package autoPackage

import (
	"bytes"
	"encoding/json"
	"fmt"
	"github.com/axgle/mahonia"
	"io/ioutil"
	"strings"
	"time"
	log "github.com/sirupsen/logrus"
	"os/exec"
	"path/filepath"
)

// 结构体和属性首字母要大写, 要能被其它模块调用
type Config struct {
	Type             string   `json:"type"`             // 命令执行类型 powershell, cmd, shell
	Workspace        []string `json:"workspace"`        // 工作空间根目录
	OutPath          []string `json:"out_path"`         // jar包输出目录
	Modules          []string `json:"modules"`          // 模块项目名, 项目目录
	Commands         []string `json:"commands"`         // 命令
	JarPath          []string `json:"jar_path"`          // 打包后jar包存放位置, 相对于项目目录
	CommandSeparator string   `json:"command_sep"` // 命令分隔符
}

var configPath = "config.json"

var configContent Config

var workspacePath string

// 加载配置
func LoadConfig() {

	configBytes, e := ioutil.ReadFile(configPath)
	if e != nil {
		log.Print("load config file failed: ", e)
	}
	conf := &Config{}
	err := json.Unmarshal(configBytes, conf)
	if err != nil {
		log.Printf("配置文件读取错误: %s", err)
	}
	//conf2 := make(map[string]interface{}, 0)
	//e = json.Unmarshal(bytes, &conf2)
	//if e != nil {
	//	log.Printf("配置文件读取错误: %s", err)
	//}
	configContent = *conf
	configContent.CommandSeparator = " " + configContent.CommandSeparator + " "
}

// 打印打包模块列表
func PrintModule() {
	modules := configContent.Modules
	if modules != nil && len(modules) > 0 {
		for i := 0; i < len(modules); i++ {
			fmt.Printf("%d : %s\n", i, modules[i])
		}
	} else {
		log.Fatal("未配置模块列表!")
	}
}

// 根据获取到的配置执行可执行文件
func ExecCommand(module int8) {
	workspacePath = strings.Join(append(configContent.Workspace, configContent.Modules[module]), string(filepath.Separator))
	if configContent.Type == "powerShell" {
		// windows系统
		// 进入 工作目录
		commandLine := "cd " + workspacePath
		if len(configContent.Commands) < 1 {
			log.Fatal("命令配置项为空!")
			fmt.Println("命令配置项为空!")
		}
		for i := range configContent.Commands {
			commandLine += configContent.CommandSeparator + configContent.Commands[i]
		}
		// 复制jar包文件到指定目录:
		// 打包后jar包目录
		jarSourcePath := workspacePath + string(filepath.Separator) + strings.Join(append(configContent.JarPath, "*.jar"), string(filepath.Separator))
		// jar包需要复制的目的目录
		jarTargetPath := strings.Join(append(configContent.OutPath, time.Now().Format("01-02")), string(filepath.Separator))
		// 判断目录是否存在, 不存在则创建
		isSuccess, e := CreateFolderIfNotExist(jarTargetPath)
		if !isSuccess {
			log.Fatalf("jar包存放目录创建失败: %v", e)
			log.Printf("jar包存放目录创建失败: %v", e)
		}
		// 拼接复制命令
		commandLine += configContent.CommandSeparator + "cp " + jarSourcePath + " " + jarTargetPath
		in := bytes.NewBuffer(nil)
		command := exec.Command("PowerShell.exe")
		command.Stdin = in // 绑定输入
		var out bytes.Buffer
		command.Stdout = &out
		go func() {
			commands := strings.Split(commandLine, configContent.CommandSeparator)
			// \n相当于回车
			for i := range commands{
				if commands[i] != "" {
					in.WriteString(commands[i]+"\n")
				}
			}
		}()

		//stdout, nil := command.StdoutPipe()
		//err := command.Start()
		//scanner := bufio.NewScanner(stdout)
		//for scanner.Scan() {
		//	//str := Decoding(scanner.Text(), "GBK")
		//	str1 := Encoding(scanner.Text(), "UTF-8")
		//	//fmt.Println(str)
		//	fmt.Println(str1)
		//}
		log.Printf("开始执行%s命令\n", command.Args)
		err := command.Start()
		if err != nil {
			log.Printf("执行命令失败: %s\n", err)
		}
		err = command.Wait()
		if err != nil {
			log.Fatalf("执行错误: %v", err)
		}
		outInfo := mahonia.NewDecoder("gbk").ConvertString(out.String())
		fmt.Println(outInfo)

	} else if configContent.Type == "shell" {
		//linux 系统
	} else if configContent.Type == "cmd" {
		// cmd
	} else {
		log.Panicln("不支持此脚本!")
	}
}
