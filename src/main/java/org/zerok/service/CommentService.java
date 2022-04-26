package org.zerok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerok.mapper.CommentMapper;
import org.zerok.vo.CommentsVO;


@Service
public class CommentService {
	
	@Autowired
	private CommentMapper CommentMapper;

	public void enrollComments(CommentsVO commentsVO) {
		CommentMapper.enrollComments(commentsVO);
	}

}
