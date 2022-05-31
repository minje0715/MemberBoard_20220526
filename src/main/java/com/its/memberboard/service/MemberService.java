package com.its.memberboard.service;

import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean save(MemberDTO memberDTO) {
        int saveResult = memberRepository.save(memberDTO);
        if (saveResult > 0) {
            return true;
        } else {
            return false;
        }
    }
    public String duplicateCheck(String memberId) {
        String checkResult = memberRepository.duplicateCheck(memberId);
        System.out.println("checkResult ss= " + checkResult);
        if (checkResult == null) {
            return "ok";
        } else {
            return "no";
        }
    }

    public MemberDTO login(MemberDTO memberDTO) {
       MemberDTO loginMember = memberRepository.login(memberDTO);
       return loginMember;
    }

    public MemberDTO findById(Long findByMember) {
       MemberDTO memberDTO = memberRepository.findById(findByMember);
       return memberDTO;
    }

    public boolean update(MemberDTO memberDTO) {
       int updateResult = memberRepository.update(memberDTO);
       if(updateResult > 0) {
           return true;
       }else {
           return false;
       }
    }


//    public boolean delete(Long id) {
//        int deleteMember = memberRepository.delete(id);
//        System.out.println("deleteMember = ss11" + deleteMember);
//        if (deleteMember > 0) {
//            System.out.println("deleteMember = ss22" + deleteMember);
//            return true;
//        } else {
//            return false;
//        }
//    }
}