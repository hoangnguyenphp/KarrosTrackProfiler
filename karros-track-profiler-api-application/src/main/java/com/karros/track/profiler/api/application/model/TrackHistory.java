package com.karros.track.profiler.api.application.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class TrackHistory {
	@Id
	Integer trackHistoryId;
	Integer userId;
	BigDecimal length;
	BigDecimal totalSpeed;
	BigDecimal movingSpeed;
	LocalTime totalTime;
	BigDecimal maxSpeed;
	LocalTime uploadTime;
	@Lob
	byte[] gpxFile;
	
	
	

}
