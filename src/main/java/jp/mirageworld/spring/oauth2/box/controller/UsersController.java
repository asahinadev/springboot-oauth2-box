package jp.mirageworld.spring.oauth2.box.controller;

import java.util.*;

import javax.validation.constraints.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.*;

import jp.mirageworld.spring.oauth2.box.api.*;

import lombok.extern.slf4j.*;
import reactor.core.publisher.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

	final WebClient boxcom;

	@Autowired
	public UsersController(WebClient boxcom) {
		this.boxcom = boxcom;
	}

	@Validated
	@GetMapping("")
	public Mono<BoxSet<BoxUser>> index(
			@Min(100) @Max(1000) @RequestParam(defaultValue = "100", required = false) int limit,
			@PositiveOrZero @RequestParam(defaultValue = "0", required = false) int offset) {

		log.debug("{} => {}", "limit", limit);
		log.debug("{} => {}", "offset", offset);

		return boxcom.get().uri(b -> b.path("users")
				.queryParam("limit", limit)
				.queryParam("offset", offset)
				.build())
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<>() {
					// 処理は必要ない
				});
	}

	@Validated
	@GetMapping("{id}")
	public Mono<BoxUser> get(
			@NotEmpty @PathVariable String id) {

		log.debug("{} => {}", "id", "");

		return boxcom.get().uri(b -> b.path("users/{id}").build(id))
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<>() {
					// 処理は必要ない
				});
	}

	@ExceptionHandler(WebClientResponseException.class)
	public Mono<Map<String, Object>> exceptionHandler(WebClientResponseException exception) {
		return Mono.just(Map.of(
				// code
				"code", "" + exception.getRawStatusCode(),
				// message
				"message", exception.getMessage()));
	}
}
