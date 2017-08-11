package com.zhuanglx.demo.service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.zhuanglx.demo.common.page.Page;
import com.zhuanglx.demo.util.ExcelUtil;
import com.zhuanglx.demo.util.PropertiesUtil;

public abstract class BaseService<T1, T2> {
	
	public abstract Page<T1,T2> find(Page<T1,T2> page) throws Exception;
	
    public boolean createXlsxFile(Page<T1,T2> page, T1 query, String[] excelFields,String[] dataFields, String exportAll, OutputStream out) throws Exception {
    	
    	if(!"0".equalsIgnoreCase(exportAll)){
    		page.setPageNo(0);
    	}
    	String selectRowsStr = PropertiesUtil.getValue("file.db.select.rows", "1000");
    	Integer selectRows = 1000;
    	try {
    		selectRows = Integer.parseInt(selectRowsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	page.setPageSize(selectRows);

    	String cacheRowsStr = PropertiesUtil.getValue("excel.cache.rows", "1000");
    	Integer cacheRows = 1000;
    	try {
			cacheRows = Integer.parseInt(cacheRowsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	ExcelUtil excelUtil= new ExcelUtil();
     	excelUtil.init_Excel(excelFields, cacheRows,out);
    	List<Object> data = new ArrayList<Object>();
    	while(true){
    		page = find(page);
        	if(page.getResult()==null||page.getResult().size()==0){
        		excelUtil.flush();
        		break;
        	}
        	data.clear();
        	data.addAll(page.getResult());
        	excelUtil.write_data_Excel(data, dataFields, null,null); 
        	if(page.getPageNo()==page.getPageTotal()){
        		//excelUtil.flush();
        		break;
        	}
        	page.setPageNo(page.getPageNo()+1);
        	if("0".equalsIgnoreCase(exportAll)){
        		//excelUtil.flush();
        		break;
        	}
        	//excelUtil.flush();
      	  }
    	 excelUtil.flush();
    	 excelUtil.close();
    	 return true;
    	} 
}
