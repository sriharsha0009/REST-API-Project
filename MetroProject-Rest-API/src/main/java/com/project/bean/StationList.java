package com.project.bean;

import java.util.List;

public class StationList {

	List<Station> stations;
	
	public StationList() {
		
	}

	public StationList(List<Station> stations) {
		super();
		this.stations = stations;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
}

