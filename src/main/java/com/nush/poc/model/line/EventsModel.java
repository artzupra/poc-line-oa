package com.nush.poc.model.line;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventsModel {

	private String type;
	private int timestamp;
	private String replyToken;
	private SourceModel source;
	
}
