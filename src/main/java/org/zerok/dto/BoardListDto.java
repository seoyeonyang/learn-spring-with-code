package org.zerok.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardListDto {
	
	private int idx;
	private String title;
	
	private int views;
	private LocalDateTime createdAt;
	private String createAccountId;
	
}
