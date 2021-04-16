package top.moyeye.bean.common;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
    private long total; // 总记录数
    private List<?> rows; // 返回每页的数据的集合

    public PageResult(long total, List<?>  rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    public PageResult(Page<?> page) {
        super();
        this.total =page.getTotalElements();
        this.rows =  page.getContent();
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public  List<?> getRows() {
        return rows;
    }
    public void setRows( List<?> rows) {
        this.rows = rows;
    }

}
