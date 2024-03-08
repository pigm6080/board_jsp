package board;

import java.util.Date;

public class BoardVO {
	
	private int num;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
	public BoardVO() {
		
	}
	public BoardVO(int num, String title, String writer, String content, Date regdate, int cnt) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "boardVO [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regdate=" + regdate + ", cnt=" + cnt + "]";
	}
	
	
	
}
