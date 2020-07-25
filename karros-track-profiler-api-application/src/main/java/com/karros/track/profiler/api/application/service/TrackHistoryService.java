package com.karros.track.profiler.api.application.service;

import java.io.IOException;
import java.time.LocalDateTime;

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
	
	public TrackHistory saveTrackHistory(Integer userId, LocalDateTime uploadTime, MultipartFile file) throws Exception {
		// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            TrackHistory trackHistory = new TrackHistory(userId, uploadTime, file.getBytes());

            return trackHistoryRepository.save(trackHistory);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
}
