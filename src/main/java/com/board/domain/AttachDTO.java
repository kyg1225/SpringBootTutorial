package com.board.domain;

import lombok.Data;

@Data
public class AttachDTO {
    private Long idx;
    private Long boardIdx;
    private String originalName;
    private String saveName;
    private long size;
}
