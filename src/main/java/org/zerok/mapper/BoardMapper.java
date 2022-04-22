package org.zerok.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerok.vo.BoardVO;

@Mapper
public interface BoardMapper {

	void saveBoard(BoardVO boardVo);

}
