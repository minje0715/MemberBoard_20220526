package com.its.memberboard.service;

import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
   private BoardRepository boardRepository;
    public boolean save(BoardDTO boardDTO) {
       int saveResult = boardRepository.save(boardDTO);
       if(saveResult > 0){
           return true;
       }else {
           return false;
       }
    }
}
