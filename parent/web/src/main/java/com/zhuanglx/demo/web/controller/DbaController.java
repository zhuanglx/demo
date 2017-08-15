package com.zhuanglx.demo.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhuanglx.demo.common.dto.DbaDto;
import com.zhuanglx.demo.common.page.Page;
import com.zhuanglx.demo.common.vo.DbaVo;
import com.zhuanglx.demo.service.DbaService;



@Controller
@RequestMapping("/dba/demo")
public class DbaController extends BaseController {
	@Autowired
	private DbaService dbaService;

	@RequestMapping(value = { "list", "" })
	public String list(Page<DbaVo, DbaDto> page, DbaVo query, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("dba page=" + page);
		try {
	    	page.setQuery(query);
			page = (Page<DbaVo, DbaDto>) dbaService.find(page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("query", query);
		model.addAttribute("page", page);
		return "dba/demoList";
	}

	@RequestMapping(value = "exportXlsx")
	public void exportXlsx(Page<DbaVo, DbaDto> page, DbaVo query,
			String exportAll, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String fileName = "dba_" + System.currentTimeMillis() + ".xlsx";
		// TODO
		String[] excelFields = new String[] { "id", "xxx", "yyy" };// 列标题
		String[] dataFields = new String[] { "id", "xxx", "yyy" };// 对象的属性名字
		String outputName;
		try {
			outputName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			outputName = fileName;
		}
		response.setHeader("Content-disposition", "attachment;filename="
				+ outputName);
		response.setContentType("application/vnd.ms-excel");
		OutputStream out = null;
		try {
			out = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbaService.createXlsxFile(page, query, excelFields,
					dataFields, exportAll, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setHeader("Content-disposition", "attachment;filename="
					+ outputName);
			response.setContentType("application/vnd.ms-excel");
		}
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}