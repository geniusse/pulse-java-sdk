/*
*  Pulse Java SDK
*  Copyright (c) 2014 Genius Software Engineering Solutions Ltd.
*
*  This file is part of Pulse Java SDK
*
*  Pulse Java SDK is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This software library is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*
*  You should have received a copy of the GNU Lesser General Public License
*  along with this software library. If not, see <http://www.gnu.org/licenses/>.
*
*/


package com.geniusse.pulse.model;

public class TelemetryData extends DeviceData {

	private double longitude;

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude( double longitude ) {
		this.longitude = longitude;
	}


	private double latitude;

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude( double latitude ) {
		this.latitude = latitude;
	}


	private int speed;

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed( int speed ) {
		this.speed = speed;
	}


	private int heading;

	public int getHeading() {
		return this.heading;
	}

	public void setHeading( int heading ) {
		this.heading = heading;
	}


	private long mileage;

	public long getMileage() {
		return this.mileage;
	}

	public void setMileage( long mileage ) {
		this.mileage = mileage;
	}

}

