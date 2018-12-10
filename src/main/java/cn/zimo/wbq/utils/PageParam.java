package cn.zimo.wbq.utils;

public class PageParam {
    private Integer pageNum=1;
    private Integer pageSize=10;

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getStartRow(){
        return (pageNum-1)*pageSize;
    }
}
