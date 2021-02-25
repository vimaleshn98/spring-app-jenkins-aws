package com.mindtree.mindsapp.repository;

import java.util.List;

import javax.persistence.criteria.From;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.mindsapp.entity.Mind;

public interface MindRepository extends JpaRepository<Mind, Integer>{

	List<Mind> getMindByTrack(String track);

}
