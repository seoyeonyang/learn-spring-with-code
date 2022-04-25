package org.zerok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerok.dto.BoardDetailDto;
import org.zerok.dto.BoardListDto;
import org.zerok.mapper.BoardMapper;
import org.zerok.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void saveBoard(BoardVO boardVo) {
		boardMapper.saveBoard(boardVo);
	}
	
	public List<BoardListDto> getBoardList() {
		return boardMapper.getBoardList();
	}
	
	public void increaseViews(int boardIdx) {
		boardMapper.increaseViews(boardIdx);
	}
	
	public BoardDetailDto getBoardDetail(int boardIdx) {
		return boardMapper.getBoardDetail(boardIdx);
	}
	
	public void boardUpdqte(BoardDetailDto boardDetailDto) {
		boardMapper.boardUpdate(boardDetailDto);
	}
	
	public void boardDelete(int boardIdx) {
		boardMapper.boardDelete(boardIdx);
	}


}
