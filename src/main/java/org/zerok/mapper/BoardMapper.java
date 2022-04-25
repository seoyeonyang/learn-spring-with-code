package org.zerok.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerok.dto.BoardDetailDto;
import org.zerok.dto.BoardListDto;
import org.zerok.vo.BoardVO;

@Mapper
public interface BoardMapper {

	void saveBoard(BoardVO boardVo);

	List<BoardListDto> getBoardList();

	void increaseViews(int boardIdx);
	
	BoardDetailDto getBoardDetail(int boardIdx);

	void boardUpdate(BoardDetailDto boardDetailDto);
}
