package com.mindtree.mindsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.mindsapp.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
	public Track findById(int id);
	
	

}
