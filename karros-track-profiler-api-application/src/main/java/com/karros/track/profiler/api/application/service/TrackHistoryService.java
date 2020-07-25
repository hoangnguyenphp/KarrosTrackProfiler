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

import com.karros.track.profiler.api.application.dao.TrackHistoryRepository;
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
	
	public List<TrackHistory> getLatestTracks() {
		Query query = em.createNativeQuery("select th.track_history_id, th.file_name, th.user_name, th.upload_time from track_history th");
		List<Object[]> results = query.getResultList();
		List<TrackHistory> trackHistories = new ArrayList<TrackHistory>();
		TrackHistory trackHistory;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		for(Object[] th : results) {
			trackHistory = new TrackHistory(th[0] != null ? Integer.parseInt(th[0].toString()) : null,
											th[1] != null ? th[1].toString() : null,
											th[2] != null ? th[2].toString() : null,
											th[3] != null ? LocalDateTime.parse(th[3].toString(), formatter) : null);
			trackHistories.add(trackHistory);
		}
		return trackHistories;
	}
}
