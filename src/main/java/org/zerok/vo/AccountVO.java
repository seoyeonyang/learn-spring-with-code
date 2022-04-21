package org.zerok.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountVO {
	
	private Integer idx;
	private String id;
	private String password;
	private String name;
	private LocalDateTime createdAt;
	

}
