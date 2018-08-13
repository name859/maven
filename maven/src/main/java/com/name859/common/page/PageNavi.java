package com.name859.common.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PageNavi {

	private PageDesign design;
	
	private String pagination;
	private String baseUrl;
	private String param;
	
	private int currentPage;
	private long totalRecord;
	private int viewRecord = 10;
	private int totalPage;
	private int viewPage = 10;
	
	private int currentPageBlock;
	private int startPage;
	private int endPage;
	
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPrePage;
	private boolean hasNextPage;
	private boolean hasPrePageBlock;
	private boolean hasNextPageBlock;
	
	private Pageable prePageable;
	private Pageable nextPageable;
	
	public PageNavi() {
		design = new PageDesign();
	}
	
	public void init(String baseUrl, String param, int currentPage, int totalRecord, int totalPage) {
		this.baseUrl = baseUrl;
		this.param = param;
		
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		
		currentPageBlock = this.currentPage / viewPage;
		startPage = currentPageBlock * viewPage;
		endPage = startPage + viewPage - 1;
		if (endPage > this.totalPage - 1) endPage = this.totalPage - 1;
		
		isFirstPage = this.currentPage == 0 ? true : false;
		isLastPage = this.currentPage == this.totalPage - 1 ? true : false;
		hasPrePageBlock = this.currentPage - viewPage >= 0 ? true : false;
		hasNextPageBlock = startPage + viewPage < this.totalPage ? true : false;
		
		pagination = makePagination();
	}
	
	public void init(Page<?> page, String baseUrl, String param, int currentPage) {
		this.baseUrl = baseUrl;
		this.param = param;
		
		this.currentPage = currentPage;
		totalRecord = page.getTotalElements();
		totalPage = page.getTotalPages();
		
		currentPageBlock = this.currentPage / viewPage;
		startPage = currentPageBlock * viewPage;
		endPage = startPage + viewPage - 1;
		if (endPage > totalPage - 1) endPage = totalPage - 1;
		
		isFirstPage = page.isFirst();
		isLastPage = page.isLast();
		hasPrePage = page.hasPrevious();
		hasNextPage = page.hasNext();
		hasPrePageBlock = this.currentPage - viewPage >= 0 ? true : false;
		hasNextPageBlock = startPage + viewPage < totalPage ? true : false;
		
		prePageable = page.previousPageable();
		nextPageable = page.nextPageable();
		
		pagination = makePagination();
	}
	
	public void init(Page<?> page, String baseUrl, String param, int currentPage, int viewRecord, int viewPage) {
		this.baseUrl = baseUrl;
		this.param = param;
		
		this.currentPage = currentPage;
		totalRecord = page.getTotalElements();
		this.viewRecord = viewRecord;
		totalPage = page.getTotalPages();
		this.viewPage = viewPage;
		
		currentPageBlock = this.currentPage / this.viewPage;
		startPage = currentPageBlock * this.viewPage;
		endPage = startPage + this.viewPage - 1;
		if (endPage > totalPage - 1) endPage = totalPage - 1;
		
		isFirstPage = page.isFirst();
		isLastPage = page.isLast();
		hasPrePage = page.hasPrevious();
		hasNextPage = page.hasNext();
		hasPrePageBlock = this.currentPage - this.viewPage >= 0 ? true : false;
		hasNextPageBlock = startPage + this.viewPage < totalPage ? true : false;
		
		prePageable = page.previousPageable();
		nextPageable = page.nextPageable();
		
		pagination = makePagination();
	}
	
	private String makePagination() {
		String pagination = design.getBorderPrefix();
		
		if (hasPrePageBlock) {
			pagination += makePageTag(false, true, 0, design.getFirstSymbol() + design.getFirstText());
			pagination += makePageTag(false, true, startPage - 1, design.getPreSymbol() + design.getPreText());
		} else {
			pagination += makePageTag(false, false, 0, design.getFirstSymbol() + design.getFirstText());
			pagination += makePageTag(false, false, startPage - 1, design.getPreSymbol() + design.getPreText());
		}
		
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) {
				pagination += makePageTag(true, false, i, Integer.toString(i + 1));
			} else {
				pagination += makePageTag(false, true, i, Integer.toString(i + 1));
			}
		}
		
		if (hasNextPageBlock) {
			pagination += makePageTag(false, true, endPage + 1, design.getNextText() + design.getNextSymbol());
			pagination += makePageTag(false, true, totalPage - 1, design.getLastText() + design.getLastSymbol());
		} else {
			pagination += makePageTag(false, false, endPage + 1, design.getNextText() + design.getNextSymbol());
			pagination += makePageTag(false, false, totalPage - 1, design.getLastText() + design.getLastSymbol());
		}
		
		pagination += design.getBorderSuffix();
		
		return pagination;
	}
	
	private String makePageTag(boolean active, boolean enabled, int page, String pageText) {
		String pageTag = "";
		if (active) {
			pageTag = design.getActivePrefix() +"<a>"+ pageText +"</a>"+ design.getActiveSuffix();
		} else {
			if (enabled) {
				if (param.matches(".*&.*")) {
					pageTag = design.getEnabledPrefix() +"<a href=\""+ baseUrl +"?currentPage="+ page +"&"+ param.split("&", 2)[1] +"\">"+ pageText +"</a>"+ design.getEnabledSuffix();
				} else {
					pageTag = design.getEnabledPrefix() +"<a href=\""+ baseUrl +"?currentPage="+ page +"\">"+ pageText +"</a>"+ design.getEnabledSuffix();
				}
			} else {
				pageTag = design.getDisabledPrefix() +"<a><font color=\"powderblue\">"+ pageText +"</font></a>"+ design.getDisabledSuffix();
			}
		}
		
		return pageTag;
	}
	
	public PageDesign getDesign() {
		return design;
	}
	
	public void setDesign(PageDesign design) {
		this.design = design;
	}
	
	public String getPagination() {
		return pagination;
	}
	
	public void setPagination(String pagination) {
		this.pagination = pagination;
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String getParam() {
		return param;
	}
	
	public void setParam(String param) {
		this.param = param;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public long getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	public int getViewRecord() {
		return viewRecord;
	}
	
	public void setViewRecord(int viewRecord) {
		this.viewRecord = viewRecord;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getViewPage() {
		return viewPage;
	}
	
	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
	}
	
	public int getCurrentPageBlock() {
		return currentPageBlock;
	}
	
	public void setCurrentPageBlock(int currentPageBlock) {
		this.currentPageBlock = currentPageBlock;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean isFirstPage() {
		return isFirstPage;
	}
	
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	
	public boolean isLastPage() {
		return isLastPage;
	}
	
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
	public boolean isHasPrePageBlock() {
		return hasPrePageBlock;
	}
	
	public void setHasPrePageBlock(boolean hasPrePageBlock) {
		this.hasPrePageBlock = hasPrePageBlock;
	}
	
	public boolean isHasNextPageBlock() {
		return hasNextPageBlock;
	}
	
	public void setHasNextPageBlock(boolean hasNextPageBlock) {
		this.hasNextPageBlock = hasNextPageBlock;
	}
	
	public Pageable getPrePageable() {
		return prePageable;
	}
	
	public void setPrePageable(Pageable prePageable) {
		this.prePageable = prePageable;
	}
	
	public Pageable getNextPageable() {
		return nextPageable;
	}
	
	public void setNextPageable(Pageable nextPageable) {
		this.nextPageable = nextPageable;
	}
	
	@Override
	public String toString() {
		return "PageNavi [pagination=" + pagination + ", baseUrl=" + baseUrl + ", param=" + param + ", currentPage="
				+ currentPage + ", totalRecord=" + totalRecord + ", viewRecord=" + viewRecord + ", totalPage="
				+ totalPage + ", viewPage=" + viewPage + ", currentPageBlock=" + currentPageBlock + ", startPage="
				+ startPage + ", endPage=" + endPage + ", isFirstPage=" + isFirstPage + ", isLastPage=" + isLastPage
				+ ", hasPrePage=" + hasPrePage + ", hasNextPage=" + hasNextPage + ", hasPrePageBlock=" + hasPrePageBlock
				+ ", hasNextPageBlock=" + hasNextPageBlock + "]";
	}
	
}
