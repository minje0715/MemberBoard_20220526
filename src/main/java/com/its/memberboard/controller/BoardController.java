package com.its.memberboard.controller;

import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/saveForm")
    public String saveForm() {
        return "boardPages/save";
    }

    @PostMapping("/save") //글작성
    public String save(BoardDTO boardDTO ,Model model) {
        boolean saveResult = boardService.save(boardDTO);
        if (saveResult) {
            model.addAttribute("board", boardDTO);
            return "redirect:/board/list";
        } else {
            return "boardPages/save-fail";
        }
    }

    @GetMapping("/list") // 헤더 -> 글목록
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "/boardPages/list";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long bid, Model model) {
       BoardDTO boardDTO = boardService.findById(bid);
       model.addAttribute("board", boardDTO);
       return "boardPages/findById";
    }
    @GetMapping ("/update")
    public String update(@RequestParam("id")Long bid, Model model ) {
       BoardDTO boardDTO = boardService.findById(bid);
       model.addAttribute("boardUpdate", boardDTO);
       return "boardPages/update";
    }
}
