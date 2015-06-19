package edu.model2.bean;

import java.sql.Date;

public class Attendance {
	private Integer attendanceID;
	private String inTime;
	private String outTime;
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	public Integer getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(Integer attendanceID) {
		this.attendanceID = attendanceID;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	
	

}
