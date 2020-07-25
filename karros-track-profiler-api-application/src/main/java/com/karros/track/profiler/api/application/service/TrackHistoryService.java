package com.karros.track.profiler.api.application.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.karros.track.profiler.api.application.constant.ApplicationConstant;
import com.karros.track.profiler.api.application.dao.TrackHistoryRepository;
import com.karros.track.profiler.api.application.dto.TrackHistoryInfo;
import com.karros.track.profiler.api.application.model.TrackHistory;

@Service
public class TrackHistoryService {
	
	@Autowired
	private TrackHistoryRepository trackHistoryRepository;
	
	@Autowired
	EntityManager em;
	
	public TrackHistory saveTrackHistory(String userName, LocalDateTime uploadTime, MultipartFile file) throws Exception {
		// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            TrackHistory trackHistory = new TrackHistory(fileName, userName, uploadTime, file.getBytes());

            return trackHistoryRepository.save(trackHistory);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
	
	public List<TrackHistoryInfo> getLatestTracks() {
		Query query = em.createNativeQuery(ApplicationConstant.GET_LATEST_TRACK_HISTORIES_H2_QUERY);
		List<Object[]> results = query.getResultList();
		List<TrackHistoryInfo> listTrackHistoryInfo = new ArrayList<TrackHistoryInfo>();
		TrackHistoryInfo trackHistoryInfo;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.LOCAL_DATE_TIME_FORMAT_PATTERN_1);
		for(Object[] th : results) {
			trackHistoryInfo = new TrackHistoryInfo(th[0] != null ? Integer.parseInt(th[0].toString()) : null,
											th[1] != null ? th[1].toString() : null,
											th[2] != null ? th[2].toString() : null,
											th[3] != null ? LocalDateTime.parse(th[3].toString(), formatter) : null);
			listTrackHistoryInfo.add(trackHistoryInfo);
		}
		return listTrackHistoryInfo;
	}
}
