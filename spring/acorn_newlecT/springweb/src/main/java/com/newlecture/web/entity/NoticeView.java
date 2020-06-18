package com.newlecture.web.entity;

public class NoticeView extends Notice {
	private String writerName;
	private int cmtCount;
	

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	@Override
	public String toString() {
		return "NoticeView [writerName=" + writerName + ", cmtCount=" + cmtCount + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
