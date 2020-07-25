package com.karros.track.profiler.api.application.dto;

import java.time.LocalDateTime;

public class TrackHistoryInfoQueryDto {
	Integer trackHistoryId;
	String fileName;
	String userName;
	LocalDateTime uploadTime;
	public TrackHistoryInfoQueryDto(Integer trackHistoryId, String fileName, String userName, LocalDateTime uploadTime) {
		this.trackHistoryId = trackHistoryId;
		this.fileName = fileName;
		this.userName = userName;
		this.uploadTime = uploadTime;
	}
	public Integer getTrackHistoryId() {
		return trackHistoryId;
	}
	public void setTrackHistoryId(Integer trackHistoryId) {
		this.trackHistoryId = trackHistoryId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDateTime getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(LocalDateTime uploadTime) {
		this.uploadTime = uploadTime;
	}
}
