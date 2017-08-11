package com.zhuanglx.demo.util;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelUtil {
  private  OutputStream output;  
  private Sheet sheet;  
  private SXSSFWorkbook wb;  
  private Integer countRow=0;  
  private Map<String, PropertyDescriptor>objPropertyMap;  
  private  SimpleDateFormat sdf;
  
  /** 
   * 初始化 
   * @param xls_write_Address 
   * @param fieldNames 
   * @throws FileNotFoundException 
   */  
  
  
  
  public void init_Excel(String[] fieldNames, int cacheRows, OutputStream output) throws FileNotFoundException{  
      this.output = output;
      
      sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      wb = new SXSSFWorkbook(cacheRows);//内存中保留 1000 条数据，以免内存溢出，其余写入 硬盘        
      sheet = wb.createSheet(String.valueOf("sheet"));    
      wb.setSheetName(0, "sheet");     
      //sheet.autoSizeColumn(1);  
      Row row = sheet.createRow(countRow++); 
      CellStyle cellStyle =  wb.createCellStyle(); 
      cellStyle.setFillBackgroundColor(HSSFColor.BLUE_GREY.index);
      for(int i=0;i<fieldNames.length;i++){  
          Cell cell = row.createCell(i);                       
          cell.setCellType(XSSFCell.CELL_TYPE_STRING);//文本格式                      
          sheet.setColumnWidth(i, fieldNames[i].length()*384); //设置单元格宽度
          
          cell.setCellStyle(cellStyle);
          cell.setCellValue(fieldNames[i]);//写入内容    
          
      }  
        
  }  
    
  /** 
   *  
   * @param datalist 
   * @param dataFields 
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   * @throws InvocationTargetException 
   * @throws IOException 
   * @throws IntrospectionException 
   */  
  public void write_data_Excel(List<Object> datalist,String[] dataFields) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, IntrospectionException{  
      write_data_Excel(datalist,dataFields,null,null);  
  }  
    
  public void write_data_Excel(List<Object> datalist,String[] dataFields,Map<String, Map<String, String>> dataDic) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, IntrospectionException{  
      write_data_Excel(datalist,dataFields,dataDic,null);  
  }  
    
  /** 
   * 写数据 
   * @param datalist 
   * @param dataFields 
   * @throws IOException 
   * @throws IntrospectionException 
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   * @throws InvocationTargetException 
   */  
  public  void write_data_Excel(List<Object> datalist,String[] dataFields,Map<String, Map<String, String>> dataDic,Map<String,Integer> dataFormat) throws IOException, IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {  
        
      CellStyle cellStyle =  wb.createCellStyle();    
      cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));                     
      ZipSecureFile.setMinInflateRatio(0l);  
        
      for(int i=0;i<datalist.size();i++){    
          Row row = sheet.createRow(countRow++);    
          Object obj=datalist.get(i);             
          BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
          PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
          if(objPropertyMap==null){  
              objPropertyMap=new HashMap<String, PropertyDescriptor>();  
              for(PropertyDescriptor des:propertyDescriptors){  
                  objPropertyMap.put(des.getName(), des);  
              }  
          }  
          for(int cols=0;cols<dataFields.length;cols++){    
              String dataField=dataFields[cols];  
              Object value="";  
              if (objPropertyMap.get(dataField)!=null) {    
                  // 得到property对应的getter方法    
                  Method gettter = objPropertyMap.get(dataField).getReadMethod();    
                  value=gettter.invoke(obj);  
                  if(value instanceof Date){  
                      Date date=(Date)value;  
                      value=sdf.format(date);
                      //数据字典的匹配  
                  }else {  
                      if(dataDic!=null && dataDic.get(dataField)!=null){  
                          value=dataDic.get(dataField).get(value+"");  
                      }  
                  }  
              }    
                
              if(value==null){  
                  value="";  
              }  
              Cell cell = row.createCell(cols);       
                
              if(dataFormat!=null && dataFormat.get(dataField)!=null){  
                  int format=dataFormat.get(dataField);  

                  switch(format){  
                      case 10:  
                          cell.setCellStyle(cellStyle);    
                          cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);//数字格式  
                          if(!StringUtils.isBlank(value.toString())){  
                              cell.setCellValue(Double.valueOf(value.toString()));//写入内容    
                          }  
                          break;  
                      case XSSFCell.CELL_TYPE_NUMERIC:  
                          cell.setCellType( XSSFCell.CELL_TYPE_NUMERIC);//数字格式  
                          if(!StringUtils.isBlank(value.toString())){  
                              cell.setCellValue(Double.valueOf(value.toString()));//写入内容    
                          }  
                          break;  
                  }  

              }else{  
                  cell.setCellType(XSSFCell.CELL_TYPE_STRING);//文本格式      
                  cell.setCellValue(value.toString());//写入内容    
              }  
                
             // sheet.setColumnWidth(cols, value.toString().length()*384); //设置单元格宽度    
              
          }     
      }      
          
  }    
  /** 
   * 写文件 
   * @throws IOException 
   */  
  public void flush() throws IOException{  
      wb.write(output);  
      output.flush();
      //output.close();   
  }  
  
  /** 
   * 写文件 
   * @throws IOException 
   */  
  public void close() throws IOException{  
      output.close();   
  }
  
  public static void main(String[] args) throws Exception {
	 
	  //ExcelUtil util=new ExcelUtil();  
	  //FileOutputStream output = new FileOutputStream(new File("report/xx.xlsx"));  //读取的文件路径     
	 // util.init_Excel("report/","abc_xxxxx.xlsx", new String[]{"手机","序号","姓名","密码"},1000,output);
	 // String[] datefiles=new String[]{"telphone","id","name","pwd"};//对象的属性名字  
	  /** 
	   * 定义数据字典 
	   */  
	  /*
	  Map<String, Map<String,String>> properyMap=new HashMap<String, Map<String,String>>();
	  
	  Map<String, String> resultsMap=new HashMap<String, String>();  
	  resultsMap.put("0", "未处理");  
	  resultsMap.put("1", "收款成功");  
	  resultsMap.put("2", "收款失败"); 
	  properyMap.put("id", resultsMap);//可以多个  
	  
	  Map<String, String> nameMap=new HashMap<String, String>();  
	  resultsMap.put("xxxx", "1");  
	  properyMap.put("name", resultsMap);//可以多个 	    
	  // 定义数据格式 
	  Map <String,Integer> dataFormat =new HashMap<String,Integer>();  
	  dataFormat.put("telphone", 10);//带两位小数数字    
	  dataFormat.put("name", 10);//带两位小数数字 
	  
	   List<Object> demos = new ArrayList<Object>();
	   SysLoginUser sysLoginUser;
	   
	  for (int i = 0; i < 20; i++) {
		  demo = new Demo();
		  demo.setId(i);
		  demo.setName("xxxx");
		  demo.setPwd("yyyy");
		  demo.setTelphone("311");
		  demos.add(demo);
	  }
	  
	  for (int i = 0; i < 10; i++) {
		  //util.write_data_Excel(demos, datefiles, resultsMap,dataFormat);  
		  util.write_data_Excel(demos, datefiles, properyMap,dataFormat); 
		  System.out.println("i=" + i);
	  }
	  //将文件写在硬盘上  
	  util.write_excel_disk();  
	  */
	  //ZipUtil.zip(zipFileName, inputFile);
}
  
}

