package com.karros.track.profiler.api.application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.karros.track.profiler.api.application.dto.TrackHistoryInfoQueryDto;
import com.karros.track.profiler.api.application.model.TrackHistory;
import com.karros.track.profiler.api.application.service.TrackHistoryService;

import javassist.NotFoundException;

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
    
    @GetMapping("/track-histories/{trackHistoryId}")
    public TrackHistory getTrackDetails(@PathVariable(value="trackHistoryId") Integer trackHistoryId) {
    	try {
			return trackHistoryService.getTrackDetails(trackHistoryId);
		} catch (NotFoundException e) {
			 throw new ResponseStatusException(
	                 HttpStatus.NOT_FOUND, e.toString());
		}
    }


}
