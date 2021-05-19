package main

import (
	"autoPackage"
	"fmt"
)

func main() {
	autoPackage.LoadConfig()
	fmt.Println("读取的配置文件为: ")
	// 输入要打包的模块序号
	autoPackage.PrintModule()
	fmt.Println("请输入要打包的模块序号: ")
	var moduleName int8
	fmt.Scanln(&moduleName)
	// 执行打包命令
	autoPackage.ExecCommand(moduleName)
}