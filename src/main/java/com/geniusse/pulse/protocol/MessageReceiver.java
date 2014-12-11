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

import java.io.BufferedReader;
import java.io.IOException;

import com.geniusse.pulse.model.Message;


public class MessageReceiver {

	public Message recv( BufferedReader buffer ) {

		Message data = null;
		String msg   = null;

		// read raw message
		try {
			msg = buffer.readLine();
		} catch ( IOException e ) {
			// FIXME: handle exception
		}

		// parse message
		if ( msg != null ) {

			String [] segments = msg.split( "\\|", 2 );

			if ( segments.length == 2 ) {
				data = new Message();
				data.setMsgType( segments[0] );
				data.setMsgBody( segments[1] );
			}

		}

		return data;

	}

}

