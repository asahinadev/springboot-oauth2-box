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
@RequestMapping("/groups")
public class GroupsController {

	final WebClient boxcom;

	@Autowired
	public GroupsController(WebClient boxcom) {
		this.boxcom = boxcom;
	}

	@Validated
	@GetMapping("")
	public Mono<BoxSet<BoxGroup>> index(
			@Min(100) @Max(1000) @RequestParam(defaultValue = "100", required = false) int limit,
			@PositiveOrZero @RequestParam(defaultValue = "0", required = false) int offset) {

		log.debug("{} => {}", "limit", limit);
		log.debug("{} => {}", "offset", offset);

		return boxcom.get().uri(b -> b.path("groups")
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
	public Mono<BoxGroup> get(
			@NotEmpty @PathVariable String id) {

		log.debug("{} => {}", "id", "id");

		return boxcom.get().uri(b -> b.path(
				"groups/{id}").build(id))
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<>() {
					// 処理は必要ない
				});
	}

	/**
	 * List members of group.
	 * 
	 * @param id
	 *               group id.
	 * 
	 * @return json
	 */
	@Validated
	@GetMapping("{id}/memberships")
	public Mono<BoxGroup> getMemberships(
			@NotEmpty @PathVariable String id) {

		log.debug("{} => {}", "id", "id");

		return boxcom.get().uri(b -> b.path(
				"groups/{id}/memberships").build(id))
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<>() {
					// 処理は必要ない
				});
	}

	/**
	 * Get group membership.
	 * 
	 * @param id
	 *               membership id
	 * 
	 * @return json
	 */
	@Validated
	@GetMapping("memberships/{id}")
	public Mono<BoxGroup> getMembership(
			@NotEmpty @PathVariable String id) {

		log.debug("{} => {}", "id", "id");

		return boxcom.get().uri(b -> b.path(
				"group_memberships/{id}").build(id))
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
