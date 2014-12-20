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

import com.geniusse.pulse.model.TelemetryData;


public class TelemetryMessageParser {

	public TelemetryData parse( String msg_body ) {

		TelemetryData data = null;

		String [] segments = msg_body.split( "," );

		if ( segments.length == 8 ) {

			data = new TelemetryData();

			data.setDeviceId( segments[0] );
			data.setVehicleRegistration( segments[1] );
			data.setLongitude( Double.parseDouble( segments[3] ) );
			data.setLatitude( Double.parseDouble( segments[4] ) );
			data.setSpeed( Integer.parseUnsignedInt( segments[5] ) );
			data.setHeading( Integer.parseInt( segments[6] ) );
			data.setMileage( Long.parseUnsignedLong( segments[7] ) );

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

