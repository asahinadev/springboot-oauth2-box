package jp.mirageworld.spring.oauth2.box.controller;

import javax.validation.constraints.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.*;

import jp.mirageworld.spring.oauth2.box.api.*;

import lombok.extern.slf4j.*;
import reactor.core.publisher.*;

@Slf4j
@RestController
@RequestMapping("/collections")
public class CollectionsController {

	final WebClient boxcom;

	@Autowired
	public CollectionsController(WebClient boxcom) {
		this.boxcom = boxcom;
	}

	@Validated
	@GetMapping("")
	public Mono<Collections> index(
			@Min(100) @Max(1000) @RequestParam(defaultValue = "100", required = false) int limit,
			@PositiveOrZero @RequestParam(defaultValue = "0", required = false) int offset) {

		log.debug("{} => {}", "id", "");
		log.debug("{} => {}", "limit", limit);
		log.debug("{} => {}", "offset", offset);

		return boxcom.get().uri(b -> b.path("collections")
				.queryParam("limit", limit)
				.queryParam("offset", offset)
				.build())
				.retrieve()
				.bodyToMono(Collections.class);
	}

	@Validated
	@GetMapping("{id}")
	public Mono<Collections> index(
			@NotEmpty @PathVariable String id,
			@Min(100) @Max(1000) @RequestParam(defaultValue = "100", required = false) int limit,
			@PositiveOrZero @RequestParam(defaultValue = "0", required = false) int offset) {

		log.debug("{} => {}", "id", id);
		log.debug("{} => {}", "limit", limit);
		log.debug("{} => {}", "offset", offset);

		return boxcom.get().uri(b -> b.path("collections/{id}/items")
				.queryParam("limit", limit)
				.queryParam("offset", offset)
				.build(id))
				.retrieve()
				.bodyToMono(Collections.class);
	}

	@ExceptionHandler(WebClientResponseException.class)
	public Mono<ErrorMessage> exceptionHandler(WebClientResponseException exception) {
		return Mono.fromCallable(() -> {
			ErrorMessage errors = new ErrorMessage();

			errors.setCode("" + exception.getRawStatusCode());
			errors.setMessage(exception.getStatusText());

			return errors;
		});
	}

}
