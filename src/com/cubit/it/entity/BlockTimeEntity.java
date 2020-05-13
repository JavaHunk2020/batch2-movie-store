package com.cubit.it.entity;

import java.sql.Time;

public class BlockTimeEntity {
	private int tid;
	private Time startTime;
	private Time endTime;
	private String active;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "BlockTimeEntity [tid=" + tid + ", startTime=" + startTime + ", endTime=" + endTime + ", active="
				+ active + "]";
	}

}
