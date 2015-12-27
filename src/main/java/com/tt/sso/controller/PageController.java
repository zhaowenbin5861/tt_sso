package com.tt.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author zwb
 *
 */
@Controller
public class PageController {

	/**
	 * 展示用户登录界面
	 * @return
	 */
	@RequestMapping("/page/login")
	public String showLogin(){
		return "login";
	}
	/**
	 * 展示用户注册界面
	 * @return
	 */
	@RequestMapping("/page/register")
	public String showRegister(){
		return "register";
	}
}
