package com.mindtree.mindsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.mindsapp.entity.Mind;
import com.mindtree.mindsapp.entity.Track;
import com.mindtree.mindsapp.exception.InvalidInputException;
import com.mindtree.mindsapp.service.MindServiceImp;

@RestController
@RequestMapping("/api/v1")
public class MindController {
	
	@Autowired
	MindServiceImp serviceImp;
	
	
	@PostMapping("/track")
	public ResponseEntity addTrack(@RequestBody Track track){
		serviceImp.addTrack(track);
		return new ResponseEntity<>("Track added",HttpStatus.OK);
	}
	
	@PostMapping("/mind/{trackid}")
	public ResponseEntity addMind(@RequestBody Mind mind,@PathVariable int trackid) {
		serviceImp.addMind(mind, trackid);
		return new ResponseEntity<>("mind added",HttpStatus.OK);
	}
	
	@GetMapping("/track/{track}")
	public ResponseEntity<List<Mind>> getminds(@PathVariable String track){
		List<Mind> minds =  serviceImp.getMinds(track);
		if(minds.isEmpty()) {
			return new ResponseEntity("track not found",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Mind>>(serviceImp.getMinds(track),HttpStatus.OK);
		
	}
	@PutMapping("/mind/{id}")
	public ResponseEntity<Mind> updateMind(@PathVariable int id,@RequestBody String name){
		Mind mind;
		try {
			mind = serviceImp.updateMind(id, name);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity("ID NOT FOUND",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Mind>(mind,HttpStatus.OK);
	}
	
	@DeleteMapping("/mind/{id}")
	public ResponseEntity deleteMind(@PathVariable int id){
		try {
			serviceImp.deleteMind(id);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity("ID NOT FOUND",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("deleted",HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/track/{id}")
	public ResponseEntity<Track> updateTrack(@PathVariable int id,@RequestBody String strength){
		Track track;
		try {
			track = serviceImp.updateTrack(id, strength);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Track>(track,HttpStatus.OK);
	}
	
	@DeleteMapping("/track/{id}")
	public ResponseEntity deleteTrack(@PathVariable int id){
		try {
			serviceImp.deleteTrack(id);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("deleted",HttpStatus.NO_CONTENT);
	}
	
	

}
