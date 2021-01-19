package com.hnxt.sync.data.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 工具类
 *
 * @author Song.X
 * Date: 2020/12/17
 * Description:
 */
@Slf4j
public class CommonTools {

    private static int autoNum = 0;
    private static final String NUMBER_SUFFIX = "X";

    private CommonTools() {

    }

    public static int getAutoNum() {
        return autoNum;
    }


    public static void setAutoNum(int autoNum) {
        CommonTools.autoNum = autoNum;
    }

    /**
     * 获取数据编号通用方法
     *
     * @param prefix  前缀
     * @param num     序号位数
     * @param suffix  后缀
     * @param autoNum 当前序号
     * @return 编号
     */
    private static String getNumber(String prefix, int num, String suffix, int autoNum) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String seq = String.format("%0" + num + "d%s", autoNum, suffix);
        return prefix + date + seq;
    }


    /**
     * 持久化文件--小文件
     * @param path 路径
     * @param content 内容
     */
    public static void writeSmallFile(Path path, String content) {
        log.info(String.format("-------CommonTool writeSmallFile path is: %s", path.toString()));
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            writer.write(content, 0, content.length());
        } catch (IOException e) {
            log.error("文件写入失败!");
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    log.error("------BufferedWriter close failed! at CommonTools.java", e);
                }
            }
        }
    }

    /**
     * 小文件读取(编码UTF-8)
     * @param path 文件路径
     * @return 文件内容
     */
    public static StringBuilder readSmallFile(Path path) {
        log.info(String.format("-------CommonTool readSmallFile path is: %s", path.toString()));
        if (!Files.exists(path)){
            log.info("-----文件不存在!----");
            return new StringBuilder();
        }
        BufferedReader reader = null;
        StringBuilder returnBuilder = new StringBuilder();
        try {
            reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String str;
            while ((str = reader.readLine()) != null){
                returnBuilder.append(str);
            }
        } catch (IOException e) {
            log.error("文件读取失败! at CommonTools.java\n", e);
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                   log.error("----------BufferedReader close failed! at CommonTools.java\n", e);
                }
            }
        }
        return returnBuilder;
    }
}
