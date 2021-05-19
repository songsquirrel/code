package com.song.demo.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @author Song.X
 * Date: 2020/12/18
 * Description: mybatisPlus 自定义主键策略
 */
@Component
public class BusinessIdGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity) {
        return "CommonTools.getPrimaryKey()";
    }
}
