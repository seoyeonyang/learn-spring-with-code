package org.zerok.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDetailDto {
	
	private int idx;
	private String title;
	private String Contents;
	private int views;
	private String createAccountId;
	private LocalDateTime createdAt;

}
