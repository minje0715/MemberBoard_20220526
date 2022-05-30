package com.its.memberboard.dto;

import lombok.Data;

import java.security.Timestamp;

@Data
public class BoardDTO {
    private int bid;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedDate;
    private String boardFileName;
}
