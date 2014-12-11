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

public class MessageData {

	private String msgType = null;

	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType( String msgType ) {
		this.msgType = msgType;
	}


	private String msgBody = null;

	public String getMsgBody() {
		return this.msgBody;
	}

	public void setMsgBody( String msgBody ) {
		this.msgBody = msgBody;
	}

}

