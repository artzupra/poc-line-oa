package com.nush.poc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class LineOAPOCController {

	@SuppressWarnings({ "unchecked" })
	@Operation(summary = "webhook")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Resource is created") })
	@PostMapping(value = "/webhook", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> webhhok(@RequestBody Map<String, Object> request) {
		System.out.println("Received Webhook: " + request);
		List<Map<String, Object>> events = (List<Map<String, Object>>) request.get("events");
		if (events != null && !events.isEmpty()) {
			for (Map<String, Object> event : events) {
				if ("join".equals(event.get("type"))) {
					Map<String, Object> source = (Map<String, Object>) event.get("source");
					if ("group".equals(source.get("type"))) {
						String groupId = (String) source.get("groupId");
						System.out.println("🔹 Group ID: " + groupId);
					}
				}
			}
		}
		return ResponseEntity.ok("Webhook received");
	}

}
