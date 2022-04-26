package org.zerok.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.zerok.dto.BoardDetailDto;
import org.zerok.dto.BoardListDto;
import org.zerok.dto.CommentsDto;
import org.zerok.vo.BoardVO;

@Mapper
public interface BoardMapper {

	void saveBoard(BoardVO boardVo);
	
	void increaseViews(int boardIdx);

	BoardDetailDto getBoardDetail(int boardIdx);

	void boardUpdate(BoardDetailDto boardDetailDto);

	void boardDelete(int boardIdx);

	List<CommentsDto> getComments(int boardIdx);

	List<BoardListDto> getBoardList(Map<String, String> parameter);

}
