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


package com.geniusse.pulse.protocol;

import com.geniusse.pulse.model.AlertData;


public class AlertMessageParser {

	public AlertData parse( String msg_body ) {

		AlertData data = null;

		String [] segments = msg_body.split( ",", 5 );

		if ( segments.length == 5 ) {

			data = new AlertData();

			data.setDeviceId( segments[0] );
			data.setVehicleRegistration( segments[1] );
			data.setAlertType( segments[3] );
			data.setAlertData( segments[4] );

			try {
				data.setTimestamp( segments[2] );
			} catch ( java.text.ParseException pe ) {
				pe.printStackTrace();
				data = null;
			}

		}

		return data;

	}

}

