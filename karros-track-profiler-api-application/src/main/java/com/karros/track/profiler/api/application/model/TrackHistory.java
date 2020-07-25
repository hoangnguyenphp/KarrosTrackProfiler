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
	Integer userId;
	LocalDateTime uploadTime;
	@Lob
	byte[] gpxFile;
	
	public TrackHistory(Integer userId, LocalDateTime uploadTime, byte[] gpxFile) {
		this.userId = userId;
		this.uploadTime = uploadTime;
		this.gpxFile = gpxFile;
	}
	public Integer getTrackHistoryId() {
		return trackHistoryId;
	}
	public void setTrackHistoryId(Integer trackHistoryId) {
		this.trackHistoryId = trackHistoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
