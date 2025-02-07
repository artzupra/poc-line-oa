package com.nush.poc.model.line;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebHookModel {

	private String destination;
	private List<EventsModel> events;
	
}
