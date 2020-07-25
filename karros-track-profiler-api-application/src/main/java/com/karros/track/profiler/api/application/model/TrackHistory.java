package com.karros.track.profiler.api.application.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class TrackHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer trackHistoryId;
	String fileName;
	String userName;
	LocalDateTime uploadTime;
	@Lob
	byte[] gpxFile;
	
	
	public TrackHistory() {
	}
	
	public TrackHistory(Integer trackHistoryId, String fileName, String userName, LocalDateTime uploadTime) {
		this.trackHistoryId = trackHistoryId;
		this.fileName = fileName;
		this.userName = userName;
		this.uploadTime = uploadTime;
	}

	public TrackHistory(String fileName, String userName, LocalDateTime uploadTime, byte[] gpxFile) {
		this.fileName = fileName;
		this.userName = userName;
		this.uploadTime = uploadTime;
		this.gpxFile = gpxFile;
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
	public byte[] getGpxFile() {
		return gpxFile;
	}
	public void setGpxFile(byte[] gpxFile) {
		this.gpxFile = gpxFile;
	}
}
