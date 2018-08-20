package org.marketing.hikefactory.repository;

import java.util.List;

import org.marketing.hikefactory.model.NewHikes;

public interface NewHikesRepository {
	
	List<NewHikes> getRecentNewHikes();

}
