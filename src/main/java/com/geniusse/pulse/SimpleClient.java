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


package com.geniusse.pulse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.geniusse.pulse.model.AlertData;
import com.geniusse.pulse.model.Message;
import com.geniusse.pulse.model.TelemetryData;
import com.geniusse.pulse.protocol.AlertMessageParser;
import com.geniusse.pulse.protocol.MessageReceiver;
import com.geniusse.pulse.protocol.TelemetryMessageParser;


public class SimpleClient {

	public static void main( String argv[] ) throws Exception {

		int bind_port     = 8765;
		if ( argv.length >= 1 ) {
			bind_port = Integer.parseInt( argv[0] );
		}


		@SuppressWarnings("resource")
		ServerSocket sock = new ServerSocket( bind_port, 1 );
		Socket m_sock     = null;

		MessageReceiver receiver = new MessageReceiver();
		Message message          = null;


		System.out.println( "Pulse simple client, listening on port: " + bind_port );

		while ( true ) {

			try {
				m_sock = sock.accept();
			} catch ( IOException e ) {
				System.out.println( "failed to accept a connection, exception: " + e.getMessage() );
				continue;
			}

			System.out.println( "connection accepted from " + m_sock.getInetAddress().toString() );

			try {

				BufferedReader buffer = new BufferedReader( new InputStreamReader( m_sock.getInputStream() ) );
				TelemetryMessageParser telemetry = new TelemetryMessageParser();
				AlertMessageParser     alert     = new AlertMessageParser();

				while ( ( message = receiver.recv( buffer ) ) != null ) {

					switch ( message.getMsgType() ) {

						case "GCRD":

							TelemetryData telemetry_data = telemetry.parse( message.getMsgBody() );

							if ( telemetry_data != null ) {
								System.out.println( "telemetry data received for device: " + telemetry_data.getDeviceId() + ", timestamp: " + telemetry_data.getTimestamp() );
							} else {
								System.out.println( "error parsing telemetry data" );
							}

							break;

						case "ALRT":

							AlertData alert_msg = alert.parse( message.getMsgBody() );

							if ( alert_msg != null ) {
								System.out.println( "alert data received for device: " + alert_msg.getDeviceId() + ", timestamp: " + alert_msg.getTimestamp() );
							} else {
								System.out.println( "error parsing alert data" );
							}


							break;

						default:
							System.out.println( "unknown message type: " + message.getMsgType() );
							break;

					}

				}

			} catch ( IOException e ) {
				System.out.println( "failed to read message, exception: " + e.getMessage() );
			} catch ( Exception e ) {
				e.printStackTrace();
			}

			m_sock.close();
			System.out.println( "connection closed" );

		}

	}

}

