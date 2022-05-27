package com.its.memberboard.repository;

import com.its.memberboard.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
