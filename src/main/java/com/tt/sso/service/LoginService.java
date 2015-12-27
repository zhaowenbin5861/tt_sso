package com.tt.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tt.common.pojo.TaotaoResult;

public interface LoginService {

	TaotaoResult login(String username,String password,HttpServletRequest request,HttpServletResponse response);
	TaotaoResult getUserByToken(String token);
}
