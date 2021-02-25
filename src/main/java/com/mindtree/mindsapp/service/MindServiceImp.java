package com.mindtree.mindsapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.mindsapp.entity.Mind;
import com.mindtree.mindsapp.entity.Track;
import com.mindtree.mindsapp.exception.InvalidInputException;
import com.mindtree.mindsapp.repository.MindRepository;
import com.mindtree.mindsapp.repository.TrackRepository;

@Service("mindservice")
public class MindServiceImp implements MindService {
	@Autowired
	MindRepository mindRepository;
	@Autowired
	TrackRepository trackRepository;

	@Override
	public void addTrack(Track track) {
		// TODO Auto-generated method stub
		trackRepository.save(track);
		
	}

	@Override
	public void addMind(Mind mind,int trackID) {
		// TODO Auto-generated method stub
		Track track = trackRepository.findById(trackID);
		mind.setTrack2(track);
		mindRepository.save(mind);
		
	}

	@Override
	public List<Mind> getMinds(String track) {
		// TODO Auto-generated method stub
		return mindRepository.getMindByTrack(track);
	
	}

	@Override
	public Mind updateMind(int id, String name) throws com.mindtree.mindsapp.exception.InvalidInputException {
		// TODO Auto-generated method stub
		Mind mind;
		try {
			mind = mindRepository.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new com.mindtree.mindsapp.exception.InvalidInputException(e);
		}
	
			
		mind.setName(name);
		mindRepository.save(mind);
		return mind;
		
	}

	@Override
	public void deleteMind(int id) throws InvalidInputException {
		// TODO Auto-generated method stub
		Mind mind;
		
		try {
			mind = mindRepository.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new InvalidInputException(e);
		}
		mindRepository.delete(mind);
		
	}

	@Override
	public Track updateTrack(int id, String Strength) throws InvalidInputException {
		Track track;
//		try {
			track = trackRepository.findById(id);
//		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(track == null)
				throw new InvalidInputException("ID NOT FOUND");
//		}
	
			
		track.setStrength(Strength);
		trackRepository.save(track);
		return track;
	}

	@Override
	public void deleteTrack(int id) throws InvalidInputException {
		// TODO Auto-generated method stub
		Track track;
		
//		try {
			track = trackRepository.findById(id);
//		} catch (Exception e) {
			// TODO Auto-generated catch block
		if(track == null)
			throw new InvalidInputException("ID not found");
//		}
		trackRepository.delete(track);
	}

	


}
