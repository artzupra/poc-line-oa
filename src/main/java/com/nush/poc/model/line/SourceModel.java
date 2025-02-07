package com.nush.poc.model.line;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SourceModel {
	
	private String type;
	private String groupId;
	
}
