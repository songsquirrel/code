package autoPackage

import (
	"github.com/axgle/mahonia"
)

type Charset string

const (
	UTF8   = Charset("UTF-8")
	GB2312 = Charset("GB2312")
)

// 字节转成字符串
func BytesToStr0(bytes []byte) string {
	for i := 0; i < len(bytes); i++ {
		if bytes[i] == 0 {
			return string(bytes[0:i])
		}
	}
	return string(bytes)
}

//BytesToStr
func BytesToStr(bytes []byte)string{
	return string(bytes[:])
}

func Decoding(str string, charset string)string{
	if charset == "" {
		charset = "UTF-8"
	}
	if str != "" {
		enc := mahonia.NewDecoder(charset)
		return enc.ConvertString(str)
	}
	return ""
}

// coverts string from utf-8 to charset
// charset default value is GB2312
func Encoding(str string, charset string)string{
	if charset == "" {
		charset = "GB2312"
	}
	if str != "" {
		// coverts a string from UTF-8 to charset
		enc := mahonia.NewEncoder(charset)
		return enc.ConvertString(str)
	}
	return ""
}
