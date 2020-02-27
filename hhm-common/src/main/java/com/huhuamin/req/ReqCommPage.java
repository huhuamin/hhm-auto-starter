package com.huhuamin.req;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/6 07:58
 * @Description:
 */
public class ReqCommPage extends ReqComm {

    private String pageNum;

    private String pageSize;

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

}
