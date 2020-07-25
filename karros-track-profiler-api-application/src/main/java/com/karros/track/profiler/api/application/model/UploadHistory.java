package com.karros.track.profiler.api.application.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UploadHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long uploadHistoryId;
	Integer userId;
	LocalTime uploadTime;
	@Lob
	byte[] gpxFile;
	
	public Long getUploadHistoryId() {
		return uploadHistoryId;
	}
	public void setUploadHistoryId(Long uploadHistoryId) {
		this.uploadHistoryId = uploadHistoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalTime getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(LocalTime uploadTime) {
		this.uploadTime = uploadTime;
	}
	public byte[] getGpxFile() {
		return gpxFile;
	}
	public void setGpxFile(byte[] gpxFile) {
		this.gpxFile = gpxFile;
	}	
}
