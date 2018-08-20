package org.marketing.hikefactory.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Hike {
	
	private String id;

	@NotBlank
	@Size(min=3, max=200)
	private String name;
	
	@NotBlank
	@Size(min=3, max=50)
	private String location;
	
	@NotBlank
	//@Future
	private String startDate;
	
	@Digits(fraction = 2, integer = 2)
	private int duration;
	
	@NotBlank
	private String difficulty;
	
	//Default Constructor
	public Hike() {
		
	}
	//Constructor with Fields
	public Hike(@NotBlank @Size(min = 3, max = 200) String name, @NotBlank @Size(min = 3, max = 50) String location,
			@NotBlank String startDate, @NotBlank @Digits(fraction = 2, integer = 2) int duration,
			@NotBlank String difficulty) {
		super();
		this.name = name;
		this.location = location;
		this.startDate = startDate;
		this.duration = duration;
		this.difficulty = difficulty;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	@Override
	public String toString() {
		return "Hike [name=" + name + ", location=" + location + ", startDate=" + startDate + ", duration=" + duration
				+ ", difficulty=" + difficulty + "]";
	}
	
	
	
}
