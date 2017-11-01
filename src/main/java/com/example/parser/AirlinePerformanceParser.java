package com.example.parser;

import org.apache.hadoop.io.Text;

public class AirlinePerformanceParser {
	private int year;
	private int month;
	private String uniqueCarrier;
	
	private int arriveDelayTime;
	private int departureDelayTime;

	private int distance; 
	
	private boolean arriveDelayAvailable = true;
	private boolean departureDelayAvailable = true;
	private boolean distanceAvailable = true; 
	
/*
 * 항공 데이터가 콤마(,) 단위로 데이터가 저장돼 있어서 매퍼에서 구분해서 차리하기 위해 공통 클래스를 구현하였다. 
 */
	public AirlinePerformanceParser(Text text) {
		
		String[] columns = text.toString().split(",");
		
		year = Integer.parseInt(columns[0]);
		month = Integer.parseInt(columns[1]);
		
		//항공사 코드 설정 
		uniqueCarrier = columns[8];
		
		//항공사 출발 지연 시간 설정 (NA가 값이면 false로 설정)
		if(!columns[15].equals("NA")){
			departureDelayTime = Integer.parseInt(columns[15]);
		}else {
			departureDelayAvailable = false; 
		}
		// 도착 지연 시간 설정 (NA가 값이면 false로 설정)
		if(!columns[14].equals("NA")){
			arriveDelayTime = Integer.parseInt(columns[14]);
		}else {
			arriveDelayAvailable = false; 
		}
		
		if(!columns[18].equals("NA")){
			distance= Integer.parseInt(columns[18]);
		}else {
			distanceAvailable= false; 
		}
		
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getArriveDelayTime() {
		return arriveDelayTime;
	}

	public void setArriveDelayTime(int arriveDelayTime) {
		this.arriveDelayTime = arriveDelayTime;
	}

	public int getDepartureDelayTime() {
		return departureDelayTime;
	}

	public void setDepartureDelayTime(int departureDelayTime) {
		this.departureDelayTime = departureDelayTime;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isArriveDelayAvailable() {
		return arriveDelayAvailable;
	}

	public void setArriveDelayAvailable(boolean arriveDelayAvailable) {
		this.arriveDelayAvailable = arriveDelayAvailable;
	}

	public boolean isDepartureDelayAvailable() {
		return departureDelayAvailable;
	}

	public void setDepartureDelayAvailable(boolean departureDelayAvailable) {
		this.departureDelayAvailable = departureDelayAvailable;
	}

	public boolean isDistanceAvailable() {
		return distanceAvailable;
	}

	public void setDistanceAvailable(boolean distanceAvailable) {
		this.distanceAvailable = distanceAvailable;
	}

	public String getUniqueCarrier() {
		return uniqueCarrier;
	}

	public void setUniqueCarrier(String uniqueCarrier) {
		this.uniqueCarrier = uniqueCarrier;
	}
	
	
	
}
