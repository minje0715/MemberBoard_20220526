package com.its.memberboard.service;

import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public boolean save(MemberDTO memberDTO) {
      int saveResult =  memberRepository.save(memberDTO);
      if(saveResult > 0) {
          return true;
      }else {
          return false;
      }
    }

    public MemberDTO login(MemberDTO memberDTO) {
      MemberDTO loginMember = memberRepository.login(memberDTO);
      return loginMember;
    }

    public String duplicateCheck(String memberId) {
        String checkResult = memberRepository.duplicateCheck(memberId);
        System.out.println("checkResult ss= " + checkResult);
        if(checkResult == null ) {
            System.out.println("checkResult ss22= " + checkResult);
            return "ok";
        }else {
            return "no";
        }
    }
}
