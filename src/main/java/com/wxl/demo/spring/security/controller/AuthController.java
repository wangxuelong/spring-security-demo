package com.wxl.demo.spring.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 王学龙
 * @date 2014年11月28日 下午3:22:45
 */
@Controller
public class AuthController {

	/**
	 * 跳转到登录 页面
	 * 
	 * @author 王学龙
	 * @date 2014年11月28日 下午3:24:42
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView toLogin(HttpServletRequest request) {
		return new ModelAndView("../login");
	}

	/**
	 * 登出
	 * 
	 * @author 王学龙
	 * @date 2014年11月28日 下午3:24:45
	 * 
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, ModelMap map,
			RedirectAttributes attributes) {
		System.out.println("logout");
		return new ModelAndView("../login");
	}
}
