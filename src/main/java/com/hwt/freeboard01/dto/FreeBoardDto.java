package com.hwt.freeboard01.dto;

import java.sql.Timestamp;

public class FreeBoardDto {
	private int fnum;
	private String fid;
	private String fname;
	private String ftitle;
	private String fcontent;
	private Timestamp fdate;
	private int fhit;
	
	public FreeBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeBoardDto(int fnum, String fid, String fname, String ftitle, String fcontent, Timestamp fdate, int fhit) {
		super();
		this.fnum = fnum;
		this.fid = fid;
		this.fname = fname;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.fdate = fdate;
		this.fhit = fhit;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public Timestamp getFdate() {
		return fdate;
	}

	public void setFdate(Timestamp fdate) {
		this.fdate = fdate;
	}

	public int getFhit() {
		return fhit;
	}

	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	
	
	





}
