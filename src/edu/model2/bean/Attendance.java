package edu.model2.bean;

import java.sql.Date;

public class Attendance {
	private Integer attendanceID;
	private Date inTime;
	private Date outTime;
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

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	
	

}
