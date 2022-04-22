package org.zerok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerok.mapper.BoardMapper;
import org.zerok.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired BoardMapper BoardService;
	
	@GetMapping("/boards")
	public String boardList() {
		
		return "board/board-list";
	}
	
	@GetMapping("/boards/write")
	public String boardWrite() {
		
		return "board/board-write";
	}
	
	@PostMapping("/boards")
	public String saveBoard(BoardVO boardVo , HttpServletRequest request) {
		
		System.out.println(boardVo);
		
		HttpSession session = request.getSession();
		String loginId = session.getAttribute("loginId").toString();
		
		boardVo.setCreateAccountId(loginId);
		boardVo.setModifyAccountId(loginId);
		
		BoardService.saveBoard(boardVo);
		
		return "redirect:/boards";
	}

}
