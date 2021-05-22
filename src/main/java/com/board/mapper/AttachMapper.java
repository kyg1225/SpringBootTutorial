package com.board.mapper;

import java.util.List;

import com.board.domain.AttachDTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachMapper {
    public int insertAttach(List<AttachDTO> attachList);

	public AttachDTO selectAttachDetail(Long idx);

	public int deleteAttach(Long boardIdx);

	public List<AttachDTO> selectAttachList(Long boardIdx);

	public int selectAttachTotalCount(Long boardIdx);
}
