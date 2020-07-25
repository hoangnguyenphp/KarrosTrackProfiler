package com.karros.track.profiler.api.application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.karros.track.profiler.api.application.dto.TrackHistoryInfoQueryDto;
import com.karros.track.profiler.api.application.service.TrackHistoryService;

@RestController
public class TrackHistoryController {
	
	@Autowired
	private TrackHistoryService trackHistoryService;
	
    @PostMapping("/track-histories")
    public void saveTrackHistory(@RequestParam("file") MultipartFile file) {
        try {
			trackHistoryService.saveTrackHistory("user1", LocalDateTime.now(), file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @GetMapping("/latest-tracks")
    public List<TrackHistoryInfoQueryDto> getLatestTracks() {
    	return trackHistoryService.getLatestTracks();
    }


}
