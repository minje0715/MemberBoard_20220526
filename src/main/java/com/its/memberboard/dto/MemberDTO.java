package com.its.memberboard.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDTO {
    private Long id; // 회원번호
    private String memberId; //아이디
    private String memberPassword; //비밀번호
    private String memberName; //이름
    private String memberEmail; //이메일
    private String memberPhone; //핸드폰
//    private MultipartFile memberProfile; //프로필사진
//    private String memberProfileName; //프로필사진파일 이름
}
