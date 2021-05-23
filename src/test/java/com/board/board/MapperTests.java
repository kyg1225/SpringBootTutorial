package com.board.board;

import java.util.List;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

@SpringBootTest
public class MapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testOfinset(){
        BoardDTO params = new BoardDTO();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");

        int result = boardMapper.insertBoard(params);
        System.out.println("걸과는" + result + "입니다.");
    }


    @Test
    public void testMultipleInsert() {
	    for (int i = 57; i <= 200; i++) {
		    BoardDTO params = new BoardDTO();
		    params.setTitle(i + "번 게시글 제목");
		    params.setContent(i + "번 게시글 내용");
		    params.setWriter(i + "번 게시글 작성자");
		    boardMapper.insertBoard(params);
	    }
    }

    @Test
    public void testOfSelectDetail() {
        BoardDTO board = boardMapper.selectBoardDetail((long) 1);
        try {
            String boardJson = new ObjectMapper().writeValueAsString(board);
            System.out.println("==========================================");
            System.out.println(boardJson);
            System.out.println("==========================================");
        } catch (JsonProcessingException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test
    public void testOfUpdate() {
        BoardDTO params = new BoardDTO();
        params.setTitle("1번 게시글 제목을 수정합니다.");
        params.setContent("1번 게시글 내용을 수정합니다");
        params.setWriter("홍길동");
        params.setIdx((long) 1);

        int result = boardMapper.updateBoard(params);
        if (result == 1) {
            BoardDTO board = boardMapper.selectBoardDetail((long) 1);
            try {
                String boardJson = new ObjectMapper().writeValueAsString(board);
                
                System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

            } catch (JsonProcessingException e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        
    }
    

    @Test
	public void testOfDelete() {
		int result = boardMapper.deleteBoard((long) 1);
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long) 1);
			try {
				String boardJson = new ObjectMapper().writeValueAsString(board);

				System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

    @Test
    public void testMultipleDelete() {
	    for (int i = 2; i <= 50; i++) {
            int result = boardMapper.deleteBoard((long) i);
            if (result == 1) {
                BoardDTO board = boardMapper.selectBoardDetail((long) i);
                try {
                    String boardJson = new ObjectMapper().writeValueAsString(board);
    
                    System.out.println("=========================");
                    System.out.println(boardJson);
                    System.out.println("=========================");
    
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }    
	    }
    }

}
