package com.tt.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.common.pojo.TaotaoResult;
import com.tt.common.utils.ExceptionUtil;
import com.tt.pojo.TbUser;
import com.tt.sso.service.RegisterService;

/**
 * 用户注册接口
 * @author zwb
 *
 */
@Controller
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable String param,@PathVariable Integer type,String callback){
		try {
			TaotaoResult result = registerService.checkData(param, type);
			if(StringUtils.isNotBlank(callback)){
				//请求为jsonp调用,需要支持jsonp
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult register(TbUser user){
		try {
			TaotaoResult result = registerService.register(user);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
}