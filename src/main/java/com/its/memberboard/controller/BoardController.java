package com.its.memberboard.controller;

import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.dto.PageDTO;
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
    public String findAll(Model model ,@RequestParam(value="page", required = false,
    defaultValue = "1") int page) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", boardDTOList);
        model.addAttribute("paging", paging);
        return "boardPages/list";
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
    @PostMapping ("/update")
    public String update(@ModelAttribute BoardDTO boardDTO) {
        System.out.println("boardDTO = " + boardDTO);
        boardService.update(boardDTO);
        return "redirect:/board/list";
    }
    @GetMapping ("/delete")
    public String delete(@RequestParam("id")Long bid){
        boardService.delete(bid);
        return "redirect:/board/list";
    }

    @GetMapping ("/search")
    public String search(@RequestParam("searchType") String searchType,
                         @RequestParam("q") String q, Model model) {
    List<BoardDTO> searchList = boardService.search(searchType, q);
    model.addAttribute("boardList", searchList);
    return "boardPages/list";
    }
}
