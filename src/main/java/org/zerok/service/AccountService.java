package org.zerok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerok.mapper.AccountMapper;
import org.zerok.vo.AccountVO;

@Service
public class AccountService {
	
	@Autowired 
	AccountMapper accountMapper;

	public void join(AccountVO accountVO) {
		accountMapper.join(accountVO);
	}

}
