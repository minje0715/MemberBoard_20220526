package com.its.memberboard.controller;

import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/save")
    public String saveForm() {
        return "memberPages/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
     boolean saveResult =  memberService.save(memberDTO);
     if(saveResult) {
         return "index";
     }else {
         return "memberPages/save-fail";
     }
    }
    @GetMapping("/login")
    public String loginForm(){
        return "memberPages/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
    MemberDTO loginMember = memberService.login(memberDTO);
    if(loginMember != null) {
        model.addAttribute("loginMember", loginMember);
        session.setAttribute("loginMemberId", loginMember.getMemberId());
        session.setAttribute("loginId", loginMember.getId());
        return "boardPages/list";
    }else {
        return "memberPages/login-fail";
    }
    }

    @PostMapping ("/duplicate-check")
    public @ResponseBody String duplicateCheck(@RequestParam("memberId") String memberId) {
       String checkResult = memberService.duplicateCheck(memberId);
        System.out.println("checkResult cc= " + checkResult);
       return checkResult;

    }
}
