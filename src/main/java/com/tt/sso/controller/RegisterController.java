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
			if (param == null || type == null) {
				return TaotaoResult.build(400, "参数不能为空");
			}
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
	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		bubbleSort(arr);
		System.out.println("排序后的数组:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult register(TbUser user){
		try {
			List<TbUser> list = new ArrayList<>();
			list.add(user);
			list.add(user);
			list.add(user);
			list.add(user);
			list.add(user);
			list.add(user);
			list.add(user);
			list.add(user);
			list.add(user);

			List<String> usernames = list.stream().map(TbUser::getUsername).collect(Collectors.toList());
			List<String> passwords = list.stream().map(TbUser::getPassword).collect(Collectors.toList());
			List<String> phones = list.stream().map(TbUser::getPhone).collect(Collectors.toList());
			List<String> emails = list.stream().map(TbUser::getEmail).collect(Collectors.toList());
			List<Date> updateDates = list.stream().map(TbUser::getUpdated).collect(Collectors.toList());
			TaotaoResult result = registerService.register(user);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
}