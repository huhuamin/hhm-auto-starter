package com.huhuamin.result;


import com.github.pagehelper.PageInfo;

/**
 * @Author 胡化敏
 * @Description: 分页json返回 {@link JsonResult}
 * @Date Create 2017/11/20 11:04
 * @Modified By:
 * @Since:
 */
public class PageJsonResult<T> extends JsonResult {
    /**
     * 我的团队
     */
    private String team;

    private PageInfo<T> pageInfo;

    public PageJsonResult() {

    }

    public PageJsonResult(PageInfo<T> pageInfo) {
        setStatusCode(true);
        this.pageInfo = pageInfo;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
