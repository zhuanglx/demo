package com.zhuanglx.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuanglx.demo.common.dto.DbaDto;
import com.zhuanglx.demo.common.page.Page;
import com.zhuanglx.demo.common.vo.DbaVo;
import com.zhuanglx.demo.dao.mapper.DbaMapper;

@Service
public class DbaService extends BaseService<DbaVo, DbaDto>{

    @Autowired
    private DbaMapper dbaMapper;
    
    public Page<DbaVo, DbaDto> find(Page<DbaVo, DbaDto> page) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("page", page);
    	Long totalCount = dbaMapper.totalCount(params);
    	page.setResultTotal(totalCount);
    	List<DbaDto> result = dbaMapper.find(params);
    	page.setResult(result);
        return page;
    }
 
    } 

