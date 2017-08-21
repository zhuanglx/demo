package com.zhuanglx.demo.web.controller;


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
@RequestMapping("/")
public class LoginController extends BaseController {
	@Autowired
	private DbaService dbaService;

	@RequestMapping(value = { "index", "" })
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

	@RequestMapping(value = "login")
	public String login(Page<DbaVo, DbaDto> page, DbaVo query, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("user page=" + page);
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
	
	@RequestMapping(value = "logout")	
	public String logout(Page<DbaVo, DbaDto> page, DbaVo query, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("user page=" + page);
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
}