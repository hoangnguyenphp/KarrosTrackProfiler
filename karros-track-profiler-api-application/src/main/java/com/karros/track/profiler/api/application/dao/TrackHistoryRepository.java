package com.karros.track.profiler.api.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.karros.track.profiler.api.application.model.TrackHistory;

public interface TrackHistoryRepository extends CrudRepository<TrackHistory, Integer> {
}
