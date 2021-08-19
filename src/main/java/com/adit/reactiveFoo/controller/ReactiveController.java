package com.adit.reactiveFoo.controller;

import java.time.Duration;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adit.reactiveFoo.dto.Foo;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveController {
	
	@GetMapping(value = "/foos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	private Flux<Foo> getFoos() {
		
		Random random = new Random();
		return Flux.interval(Duration.ofSeconds(1)).map(tick -> new Foo(Long.valueOf(random.nextLong()), "Adit") );
		
	}
}
