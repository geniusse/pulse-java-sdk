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

public class AlertData extends DeviceData {

	private String alertType = null;

	public String getAlertType() {
		return this.alertType;
	}

	public void setAlertType( String alertType ) {
		this.alertType = alertType;
	}


	private String alertData = null;

	public String alertData() {
		return this.alertData;
	}

	public void setAlertData( String alertData ) {
		this.alertData = alertData;
	}

}

