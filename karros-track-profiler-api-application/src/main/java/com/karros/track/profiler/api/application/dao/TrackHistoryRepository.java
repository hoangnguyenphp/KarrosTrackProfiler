package com.karros.track.profiler.api.application.dao;

import org.springframework.data.repository.CrudRepository;

import com.karros.track.profiler.api.application.model.TrackHistory;

public interface TrackHistoryRepository extends CrudRepository<TrackHistory, Integer> {
}
