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
        boolean saveResult = memberService.save(memberDTO);
        if (saveResult) {

            return "index";
        } else {
            return "memberPages/save-fail";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "memberPages/login";
    }

    @PostMapping("/loginCheck")
    public @ResponseBody String loginCheck(@RequestParam("memberId2") String memberId,
                                           @RequestParam("memberPassword2") String memberPassword, HttpSession session) {
        String loginCheck = memberService.loginCheck(memberId, memberPassword);
        if (loginCheck == "ok") {
            session.setAttribute("loginId", memberId);
        }
        return memberService.loginCheck(memberId, memberPassword);
    }

    @PostMapping("/duplicate-check")
    public @ResponseBody String duplicateCheck(@RequestParam("memberId") String memberId) {
        String checkResult = memberService.duplicateCheck(memberId);
        return checkResult;

    }

    @GetMapping("/admin")
    public String admin() {
        return "memberPages/admin";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "memberPages/findAll";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boolean deleteResult = memberService.delete(id);
        if (deleteResult) {
            return "redirect:/member/findAll";
        } else {
            return "delete-fail";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @GetMapping("/myPage")
    public String findById(HttpSession session, Model model) {

        MemberDTO memberDTO = memberService.findByMemberId((String)session.getAttribute("loginId"));
        model.addAttribute("member", memberDTO);
        return "memberPages/myPage";
    }

    @GetMapping("/detail")
    public String detail() {
        return "memberPages/detail";
    }

    @PostMapping("/pwCheck")
    public @ResponseBody boolean findByMemberId(@RequestParam("memberPassword1") String memberPassword,
                                                @RequestParam("memberId1") String memberId) {
        return memberService.findByMemberId(memberId, memberPassword);
    }

    @GetMapping("/updateForm")
    public String updateForm(HttpSession session, Model model) {
        Long updateId = (Long) session.getAttribute("loginId");
        MemberDTO memberDTO = memberService.findById(updateId);
        model.addAttribute("updateMember", memberDTO);
        return "memberPages/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
    boolean updateResult = memberService.update1(memberDTO);
    if(updateResult){
        return "memberPages/myPage";
    }else{
        return "memberPages/update-fail";
    }
    }
}

