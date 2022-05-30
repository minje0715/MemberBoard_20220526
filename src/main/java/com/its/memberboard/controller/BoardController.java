package com.its.memberboard.controller;

import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/boardList")
    public String list(){
        return "boardPages/list";
    }
    @GetMapping("/saveForm")
    public String saveForm(){
        return "boardPages/save";
    }
    @PostMapping("/save")
    public String save(BoardDTO boardDTO) {
       boolean saveResult = boardService.save(boardDTO);
       if(saveResult){
           return "boardPages/paging";
       }else {
           return "boardPages/save-fail";
       }
    }
}
