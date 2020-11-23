package com.song.test.demo;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Song.X
 * Date: 2020/11/19
 * Description:
 */
@Mapper
public interface InitDao {
    String getFromDual();
}
