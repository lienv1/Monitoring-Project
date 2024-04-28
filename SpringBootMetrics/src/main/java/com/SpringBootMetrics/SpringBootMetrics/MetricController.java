package com.SpringBootMetrics.SpringBootMetrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MetricController {

	@Autowired
	private MetricService metricService;

	public MetricController(MetricService metricService) {
		this.metricService = metricService;
	}

	@PostMapping("/succeed")
	public ResponseEntity<Void> increaseSuccess() {
		System.out.println("Increase suc");
		metricService.recordSuccess();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/fail")
	public ResponseEntity<Void> increaseFail() {
		System.out.println("increase fail");
		metricService.recordError();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/bug/new")
	public ResponseEntity<Void> reportNewBug() {
		metricService.newBugReported();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/bug/resolve")
	public ResponseEntity<Void> resolveBug() {
		metricService.bugResolved();
		return ResponseEntity.ok().build();
	}

}
