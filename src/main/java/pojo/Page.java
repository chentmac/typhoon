package pojo;

import java.util.List;

public class Page<T> {
	  private int currentPage;
	    private int pageSize;
	    private int totalCount;
	    private int totalPage;
	    private List<T> dataList;


	    public List<T> getDataList() {
	        return dataList;
	    }

	    public void setDataList(List<T> dataList) {
	        this.dataList = dataList;
	    }

	    public int getCurrentPage() {
	        return currentPage;
	    }

	    public void setCurrentPage(int currentPage) {
	        this.currentPage = currentPage;
	    }

	    public int getPageSize() {
	        return pageSize;
	    }

	    public void setPageSize(int pageSize) {
	        this.pageSize = pageSize;
	    }

	    public int getTotalCount() {
	        return totalCount;
	    }

	    public void setTotalCount(int totalRecord) {
	        this.totalCount = totalRecord;
	    }

	    public int getTotalPage() {
	        return totalPage;
	    }

	    public void setTotalPage(int totalPage) {
	        this.totalPage = totalPage;
	    }

	    @Override
	    public String toString() {
	        return "Page{" +
	                "currentPage=" + currentPage +
	                ", pageSize=" + pageSize +
	                ", totalCount=" + totalCount +
	                ", totalPage=" + totalPage +
	                ", dataList=" + dataList +
	                '}';
	    }
}
