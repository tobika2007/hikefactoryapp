package org.marketing.hikefactory.repository.impl;

import java.util.List;

import org.marketing.hikefactory.model.NewHikes;
import org.marketing.hikefactory.repository.NewHikesRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

@Repository
@ConfigurationProperties(prefix = "communication")
public class ConfigurationBasedNewHikesRepositoryImpl implements NewHikesRepository {

	private List<NewHikes> recentHikes;
	
	@Override
	public List<NewHikes> getRecentNewHikes() {
		return recentHikes ;
	}

	public void setRecentHikes(List<NewHikes> recentHikes) {
		this.recentHikes = recentHikes;
	}

	
}
