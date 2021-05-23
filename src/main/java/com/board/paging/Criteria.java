package com.board.paging;

import lombok.Data;

@Data
public class Criteria {
    private int currentPageNo = 1;
    private int recordPerPage = 10;
    private int pageSize = 10;
    private String searchKeyword;
    private String searchType;

    public int getStartPage(){
        return (currentPageNo - 1) * recordPerPage;
    }
}
