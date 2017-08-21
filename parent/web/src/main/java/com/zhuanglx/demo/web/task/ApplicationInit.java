package com.zhuanglx.demo.web.task;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

@Service 
public class ApplicationInit implements ServletContextAware {
	private Logger logger = Logger.getLogger(this.getClass());
	public void setServletContext(ServletContext context) {
		logger.info("application starting ...");
		logger.info("########################/n"
				+ "########################/n"
				+ "########################/n"
				+ "###### * init * ########/n"
				+ "########################/n"
				+ "########################/n"
				+ "########################");
        String ctxPath=context.getContextPath();  
        context.setAttribute("ctxPath",ctxPath);  
       
	}

}

