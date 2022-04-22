package org.zerok.vo;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class BoardVO {
	
		private int idx;
		private String title;
		private String contents;
		private int views;
		private LocalDateTime createdAt;
		private String createAccountId;
		private LocalDateTime modifyAt;
		private String modifyAccountId;
}
