package com.board.mapper;

import java.util.List;

import com.board.domain.BoardDTO;
import com.board.paging.Criteria;

import org.apache.ibatis.annotations.Mapper;

//xml mapper에서 메서드의 이름과 일치하는 sql문 찾아서 실행함
//db와 통신, 즉 sql쿼리를 호출하는 것이 전부, 다른 로직은 필요x
@Mapper
public interface BoardMapper {
    //게시글을 생성하는 inser쿼리 호출하는 메서드
    //파라미터는 BoardDTO를 params이름으로 지정
    //prams에는 게시글의 정보가 담김
    public int insertBoard(BoardDTO params);

    //하나의 게시글을 조회하는 select쿼리를 호출하는 메서드
    //파라미터로 pk인 게시글 번호를 전달받음
    //where조건으로 idx를 사용해서 특정 게시글 조회
	public BoardDTO selectBoardDetail(Long idx);

    //게시글 수정하는 updatr쿼리 호출 메서드
    //insert와 비슷
	public int updateBoard(BoardDTO params);

    //게시글 삭제하는 delete쿼리 호출 메서드
    //실제로 데이터를 삭제x, y or n 으로 지정
	public int deleteBoard(Long idx);

    //게시글 목록을 조회하는 select뭐리 호출 메서드
	public List<BoardDTO> selectBoardList(Criteria criteria);

    //삭제여부가 n으로 지정된 게시글의 개수를 조회하는 selecr쿼리 메서드
    //페이징 처리에 사용
	public int selectBoardTotalCount(Criteria criteria);
}


//return 타입을 추후에 void로 수정하기
//지금은 확실하게 결과값을 전달받기 위해 int로 처리