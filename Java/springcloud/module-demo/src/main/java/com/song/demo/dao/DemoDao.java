package com.song.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.demo.dto.DemoDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Song.X
 * Date: 2020/12/15
 * Description:
 */
@Mapper
public interface DemoDao extends BaseMapper<DemoDTO> {
}
