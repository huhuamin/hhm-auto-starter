package com.huhuamin.req;


import com.huhuamin.utils.PageUtils;

/**
 * @Author 胡化敏
 * @Description: 将http中的page信息转换成实体
 * @Date Create 2017/11/24 13:03
 * @Modified By:
 * @Since:
 */
public class ReqForPageInfo {
    private Integer pageSize;
    private Integer pageNum;

    public ReqForPageInfo(String pageNum, String pageSize) {

        this.pageNum = PageUtils.ifNullPageNumWithDeafult(pageNum);

        this.pageSize = PageUtils.ifNullPageSizeWithDeafult(pageSize);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
