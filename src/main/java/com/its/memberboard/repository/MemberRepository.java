package com.its.memberboard.repository;

import com.its.memberboard.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        System.out.println("memberId = rr" + memberId);
        return sql.selectOne("Member.duplicateCheck", memberId);
    }

}
