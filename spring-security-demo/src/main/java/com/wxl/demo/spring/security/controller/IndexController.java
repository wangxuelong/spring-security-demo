package com.wxl.demo.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页 controller
 * 
 * @author 王学龙
 * @date 2014年11月28日 下午3:22:35
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView toIndex() {
		return new ModelAndView("/index");
	}

	@RequestMapping("/other")
	public ModelAndView toOther() {
		return new ModelAndView("/other");
	}
}
