package com.hnxt.sync.data.schedule;

import com.hnxt.sync.data.util.CommonTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.nio.file.Paths;

/**
 * @author Song.X
 * Date: 2020/12/18
 * Description: persistent number per day
 */
@Configuration
@EnableScheduling
@Slf4j
public class PersistentNumber {
    /**
     * 编号分隔符
     */
    public static final String NUMBER_SEPARATOR = "&";

    /**
     * 每天18点保存当前序列号到本地文件
     * 防止重启后序列号不连续
     * 如果程序云上部署需将文件目录挂载出来
     */
    @Scheduled(cron = "0 0 18 * * ?")
    public void saveNumberToFile() {
        // 文件内容
        String text = CommonTools.getAutoNumQX() + PersistentNumber.NUMBER_SEPARATOR + CommonTools.getAutoNumYH();
        log.info(String.format("-------定时记录编号为: %s", text));
        CommonTools.writeSmallFile(Paths.get("numberRecord"), text);
    }


}
