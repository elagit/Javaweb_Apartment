package com.zhiyou100.util;




//��ҳ����

public class PageUtil {
	//  ��ǰҳ
	private int pageNo;
	//	������������
	private int total;
	//	��ҳ��
	private int pageCount;
	//	��ʼֵ
	private int start;
	//	����ֵ
	private int  end;
	//	ÿҳ��������
	private int pageSize = 2;
	
	
	
	
	
	//	���췽��
	public PageUtil(int pageNo, int total) {
		this.total = total;
		this.pageNo = pageNo;
		this.pageCount = total%2==0?total/pageSize:(total/pageSize)+1;
		this.start = (pageNo - 1)*pageSize;
		this.end = pageSize;
		
		
	}
	@Override
	public String toString() {
		return "PageUtil [pageNo=" + pageNo + ", total=" + total + ", pageCount=" + pageCount + ", start=" + start
				+ ", end=" + end + ", pageSize=" + pageSize + "]";
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
