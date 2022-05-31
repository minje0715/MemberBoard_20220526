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

    @GetMapping("/boardList")
    public String list() {
        return "boardPages/list";
    }

    @GetMapping("/saveForm")
    public String saveForm() {
        return "boardPages/save";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO) {
        boolean saveResult = boardService.save(boardDTO);
        if (saveResult) {
            return "boardPages/list";
        } else {
            return "boardPages/save-fail";
        }
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/list";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long bid, Model model) {
       BoardDTO boardDTO = boardService.findById(bid);
       model.addAttribute("board", boardDTO);
       return "boardPages/findById";
    }
}
