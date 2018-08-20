package org.marketing.hikefactory.service;

import java.util.List;

import org.marketing.hikefactory.model.Hike;

public interface HikeService {

	void registerHike(Hike hike);
	
	public List<Hike> findAll();
}
