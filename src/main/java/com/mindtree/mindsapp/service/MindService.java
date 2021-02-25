package com.mindtree.mindsapp.service;

import java.util.List;

import com.mindtree.mindsapp.entity.Mind;
import com.mindtree.mindsapp.entity.Track;
import com.mindtree.mindsapp.exception.InvalidInputException;

public interface MindService {
	void addTrack(Track track);
	void addMind(Mind mind,int trackID); 
	List<Mind> getMinds(String track);
	Mind updateMind(int id,String name) throws InvalidInputException;
	void deleteMind(int id)throws InvalidInputException;
	Track  updateTrack(int id,String Strength)throws InvalidInputException;
	void deleteTrack(int id)throws InvalidInputException;

}
