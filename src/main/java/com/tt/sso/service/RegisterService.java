package com.tt.sso.service;

import com.tt.common.pojo.TaotaoResult;
import com.tt.pojo.TbUser;

public interface RegisterService {

	TaotaoResult checkData(String param,int type);
	TaotaoResult register(TbUser user);
}
