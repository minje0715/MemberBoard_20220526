package com.its.memberboard.repository;

import com.its.memberboard.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO) {
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
    return sql.selectOne("Member.login", memberDTO);
    }

    public String duplicateCheck(String memberId) {
        return sql.selectOne("Member.duplicateCheck", memberId);
    }

    public List<MemberDTO> findAll() {

        return sql.selectList("Member.findAll");
    }

    public int delete(Long id) {
        System.out.println("id = rrr" + id);
        return sql.delete("Member.delete", id);
    }


    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public MemberDTO update(MemberDTO memberDTO) {
       return sql.selectOne("Member.pwCheck", memberDTO);
    }


    public MemberDTO findByMemberId(String memberId) {
       return sql.selectOne("Member.findByMemberId", memberId);
    }



    public MemberDTO loginCheck(String memberId) {
       return sql.selectOne("Member.loginCheck", memberId);
    }

    public int update1(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }

    public MemberDTO checkId(String memberId) {
       return sql.selectOne("Member.idCheck", memberId);
    }
}
