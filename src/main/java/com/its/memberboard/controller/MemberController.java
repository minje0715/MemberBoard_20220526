package com.its.memberboard.controller;

import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;

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
    if(loginMember.getMemberId().equals("admin"))
        return "memberPages/admin";
    else {
        model.addAttribute("loginMember", loginMember);
        session.setAttribute("loginMemberId", loginMember.getMemberId());
        session.setAttribute("loginId", loginMember.getId());
        return "memberPages/main";
    }
    }else {
        return "memberPages/login-fail";
    }
    }

    @PostMapping ("/duplicate-check")
    public @ResponseBody String duplicateCheck(@RequestParam("memberId") String memberId) {
       String checkResult = memberService.duplicateCheck(memberId);
       return checkResult;

    }
    @GetMapping("/admin")
    public String admin(){
        return "memberPages/admin";
    }

    @GetMapping ("/findAll")
    public String findAll(Model model) {
      List<MemberDTO> memberDTOList = memberService.findAll();
      model.addAttribute("memberList", memberDTOList);
      return "memberPages/findAll";
    }

    @GetMapping ("/delete")
    public String delete(@RequestParam("id") Long id) {
      boolean deleteResult =  memberService.delete(id);
        System.out.println("deleteResult = cc11" + deleteResult);
        if(deleteResult){
            System.out.println("deleteResult = cc11" + deleteResult);
            return "redirect:/member/findAll";
        }else {
            return "delete-fail";
        }
    }
    @GetMapping ("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model){
      MemberDTO memberDTO = memberService.findById(id);
      model.addAttribute("member", memberDTO);
      return "memberPages/myPage";
    }
}

