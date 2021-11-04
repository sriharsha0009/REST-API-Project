package com.project.service;

import java.util.ArrayList;

import com.project.bean.Card;
import com.project.bean.Station;
import com.project.bean.StationList;

public interface StationService {

	//boolean swipeInCard(int passengerID, int stationId) throws SQLException, ClassNotFoundException;
	Station checkStation(String stationName);
//	int swipeOutCard(Card passengerId, int stationId, int choice);
	
	StationList getStations();
}
