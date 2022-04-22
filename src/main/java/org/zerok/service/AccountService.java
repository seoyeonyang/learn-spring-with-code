package org.zerok.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.Crypt;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zerok.form.LoginForm;
import org.zerok.mapper.AccountMapper;
import org.zerok.vo.AccountVO;

@Service
public class AccountService {
	
	@Autowired AccountMapper accountMapper;
	
	@Value("${password-crypt-key}")	
	private String encodingSalt;

	public void join(AccountVO accountVO) {
		
		String encodedPassword = Crypt.crypt(accountVO.getPassword(), encodingSalt);
		accountVO.setPassword(encodedPassword);
		
		accountMapper.join(accountVO);
	}

	public void login(LoginForm loginForm, HttpServletRequest request) {
		
		Map<String, String> joinedAccount = accountMapper.findAccountInfo(loginForm);
		
		if(joinedAccount == null) {
			throw new IllegalStateException("일치하는 정보가 없습니다.");
		}
		
		String password = loginForm.getPassword();
		
		password = Crypt.crypt(password, encodingSalt);
		
		if(!joinedAccount.get("password").equals(password)) {
			throw new IllegalStateException("일치하는 정보가 없습니다.");
		}
		
		HttpSession session = request.getSession();
		
		String loginId = joinedAccount.get("id");
		
		session.setAttribute("loginId", loginId);
	}

}
