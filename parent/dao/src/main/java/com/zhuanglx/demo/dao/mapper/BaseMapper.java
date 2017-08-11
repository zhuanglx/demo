package com.zhuanglx.demo.dao.mapper;

import java.util.List;

import com.zhuanglx.demo.common.page.Page;

public interface BaseMapper<T1,T2> {
    public List<T2> query(Page<T1,T2> page) throws Exception;
    public Long totalCount(Page<T1,T2> page) throws Exception;
}
