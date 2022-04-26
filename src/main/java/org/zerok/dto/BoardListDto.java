package org.zerok.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardListDto {
	
	private int idx;
	private String title;
	private String contents;
	private int views;
	private double avg;
	private int count;
	private LocalDateTime createdAt;
	private String createAccountId;
	
}
