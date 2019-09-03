package com.study.gpmall.common.tkmapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName: TkMapper
 * @Description: TkMapper接口
 * @author: limingxing
 * @Date: 2019-08-23 15:46
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
