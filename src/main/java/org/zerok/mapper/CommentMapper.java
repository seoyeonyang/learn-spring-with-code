package org.zerok.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerok.vo.CommentsVO;


@Mapper
public interface CommentMapper {

	void enrollComments(CommentsVO commentsVO);

}
