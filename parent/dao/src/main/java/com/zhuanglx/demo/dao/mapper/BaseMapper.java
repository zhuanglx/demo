package com.zhuanglx.demo.dao.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T1,T2> {
    public List<T2> find(Map<String, Object> params) throws Exception;
    public Long totalCount(Map<String, Object> params) throws Exception;
}
