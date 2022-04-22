package org.zerok.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.zerok.form.LoginForm;
import org.zerok.vo.AccountVO;

@Mapper
public interface AccountMapper {

	void join(AccountVO accountVO);

	Map<String, String> findAccountInfo(LoginForm loginForm);


}
