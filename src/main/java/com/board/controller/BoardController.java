package com.board.controller;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    @PostMapping(value="/board/register")
    public ResponseEntity<?> registerBoard(@Valid @RequestBody BoardDTO params, MultipartFile[] files) throws Exception{
        boardService.registerBoard(params, files);
        return ResponseEntity.ok(params);
    }

    //TODO: 이미지 삽입

}
