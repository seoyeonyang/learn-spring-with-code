package org.zerok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerok.mapper.BoardMapper;
import org.zerok.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void saveBoard(BoardVO boardVo) {
		boardMapper.saveBoard(boardVo);
	}

}
