package org.zerok.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerok.dto.BoardDetailDto;
import org.zerok.dto.BoardListDto;
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
	
	@GetMapping("/boards/list")
	@ResponseBody
	public ResponseEntity<List<BoardListDto>> getBoardList(){
		
		List<BoardListDto> boardList = BoardService.getBoardList();
		
		return ResponseEntity.status(HttpStatus.OK).body(boardList);
	}
	
	@GetMapping("/boards/{boardIdx}/detail")
	public String boardDetailPage(@PathVariable int boardIdx, Model model) {
		
		BoardService.increaseViews(boardIdx);
		
		BoardDetailDto boardDetail = BoardService.getBoardDetail(boardIdx);
		
		model.addAttribute("boardDetail", boardDetail);
		
		return "board/board-detail";		
	}
	
	@GetMapping("/boards/{boardIdx}/edit")
	public String boardUpdatePage(@PathVariable int boardIdx, Model model ) {
		
		BoardDetailDto boardDetail = BoardService.getBoardDetail(boardIdx);
		
		model.addAttribute("boardDetail", boardDetail);
		
		return "board/board-edit";
	}
	
	@PostMapping("/boards/update")
	public String boardUpdate(@ModelAttribute BoardDetailDto boardDetailDto, HttpServletRequest request) {
		//System.out.println(boardDetailDto);
		
		if(!authorized(boardDetailDto.getIdx(), request)) {
			return "redirect:/";
		}
		
		BoardService.boardUpdate(boardDetailDto);
		
		return "redirect:/boards";	
		
	}

	private boolean authorized(int boardIdx, HttpServletRequest request) {
		
		BoardDetailDto boardDetail = BoardService.getBoardDetail(boardIdx);
		String createAccountId  = boardDetail.getCreateAccountId();
		
		Object loginId = request.getSession().getAttribute("loginId");
		
		if(loginId == null || !createAccountId.equals(loginId.toString())) {
			return false;
		}
		return false;
	}

}
