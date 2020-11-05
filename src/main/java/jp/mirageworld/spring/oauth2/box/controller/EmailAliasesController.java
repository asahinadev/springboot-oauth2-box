package jp.mirageworld.spring.oauth2.box.controller;

import java.util.*;

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
@RequestMapping("/users/{id}/email_aliases")
public class EmailAliasesController {

	final WebClient boxcom;

	@Autowired
	public EmailAliasesController(WebClient boxcom) {
		this.boxcom = boxcom;
	}

	@Validated
	@GetMapping()
	public Mono<EmailAliases> get(@NotEmpty @PathVariable String id) {

		log.debug("{} => {}", "id", id);

		return boxcom.get().uri(b -> b.path("/users/{id}/email_aliases").build(id))
				.retrieve()
				.bodyToMono(EmailAliases.class);
	}

	@Validated
	@PostMapping()
	public Mono<EmailAliases> post(
			@NotEmpty @PathVariable("id") String id,
			@NotEmpty @RequestParam("email") String email) {

		log.debug("{} => {}", "id", id);

		return boxcom.post().uri(b -> b.path("/users/{id}/email_aliases").build(id))
				.bodyValue(Map.of("email", email))
				.retrieve()
				.bodyToMono(EmailAliases.class);
	}

	@Validated
	@DeleteMapping("{email_alias_id}")
	public Mono<Void> delete(
			@NotEmpty @PathVariable("id") String id,
			@NotEmpty @PathVariable("eid") String eid) {

		log.debug("{} => {}", "id", id);

		return boxcom.delete().uri(b -> b.path("/users/{id}/email_aliases/{eid}").build(id, eid))
				.retrieve()
				.bodyToMono(Void.class);
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
