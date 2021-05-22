package com.board.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDTO {
    //번호 (PK)
	private Long idx;
	//제목
	private String title;
	//내용
	private String content;
	//작성자
	private String writer;
	// //조회 수
	// private int isViewed;
	//삭제 여부
	private String deleteYn;
	// 등록일
	private LocalDateTime insertTime;
	// 수정일
	private LocalDateTime updateTime;
	// 삭제일
	private LocalDateTime deleteTime;
    
}
