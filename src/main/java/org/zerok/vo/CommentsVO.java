package org.zerok.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentsVO {
	
	private Integer idx;
	private Integer boardIdx;
	private Integer grade;
	private String comments;
	private String createAccountId;
	private LocalDateTime createdAt;
	private String modifyAccountId;
	private LocalDateTime modifyAt;
}
