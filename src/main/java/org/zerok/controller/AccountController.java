package org.zerok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerok.service.AccountService;
import org.zerok.vo.AccountVO;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
		
	@GetMapping("/join")
	public String joinPage() {
		return "account/join";
	}
	
	@PostMapping("/join")
	public String join(AccountVO accountVO) {
		accountService.join(accountVO);
		return "redirect:/";
	}
	
	

}
