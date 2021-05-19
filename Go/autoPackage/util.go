package autoPackage

import (
	"log"
	"os"
)

func CopyFile(sourcePath string, targetPath string) {
	isExist, e := FileIsExist(sourcePath)
	if !isExist {
		log.Fatalf("源文件不存在:%v", e)
	}
}

// 创建文件夹
func CreateFolderIfNotExist(path string)(bool, error){
	isExist, _ := FileIsExist(path)
	if !isExist {
		err := os.MkdirAll(path, os.ModePerm)
		if err != nil{
			return false, err
		}
	}
	return true, nil
}

// 判断路径是否存在
func FileIsExist(path string) (bool, error) {
	_, e := os.Stat(path)
	if e == nil {
		return true, nil
	}
	if os.IsNotExist(e){
		return false, nil
	}
	return false, e
}