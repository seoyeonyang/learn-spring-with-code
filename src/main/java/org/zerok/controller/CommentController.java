package org.zerok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerok.service.CommentService;
import org.zerok.vo.CommentsVO;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comments")
	public ResponseEntity<String> enrollComments(@RequestBody CommentsVO commentsVO){
		
		System.out.println(commentsVO);
		
		commentService.enrollComments(commentsVO);
		
		return ResponseEntity.status(HttpStatus.OK).body("댓글이 등록되었습니다.");
	}

}
