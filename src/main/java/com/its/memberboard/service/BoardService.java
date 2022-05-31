package com.its.memberboard.service;

import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BoardDTO> findAll() {
       return boardRepository.findAll();
    }


    public BoardDTO findById(Long bid) {
        boardRepository.updateHits(bid);
      return boardRepository.findById(bid);
    }


}
