package com.SpringBootMetrics.SpringBootMetrics;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class MetricService {

	private final Counter successRequests;
	private final Counter errorRequests;
	private final AtomicInteger openBugs;

	public MetricService(MeterRegistry registry) {

		// Counter for successful requests
		successRequests = Counter.builder("requests.success").description("Number of successful requests")
				.register(registry);

		// Counter for errors
		errorRequests = Counter.builder("requests.error").description("Number of error requests").register(registry);

		// Gauge for tracking open bugs
		openBugs = new AtomicInteger();
		Gauge.builder("bugs.open", openBugs, AtomicInteger::get).description("Current number of open bugs")
				.register(registry);
	}

	public void recordSuccess() {
		successRequests.increment();
	}

	public void recordError() {
		errorRequests.increment();
		openBugs.incrementAndGet();
	}

	public void newBugReported() {
		openBugs.incrementAndGet();
	}

	public void bugResolved() {
		openBugs.decrementAndGet();
	}

}
