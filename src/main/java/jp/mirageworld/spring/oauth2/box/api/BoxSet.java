package jp.mirageworld.spring.oauth2.box.api;

import java.util.*;
import java.util.function.*;

import com.fasterxml.jackson.annotation.*;

import jp.mirageworld.spring.oauth2.box.api.values.*;

import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoxSet<E> implements Iterable<E> {
	@JsonProperty
	int limit;
	@JsonProperty
	int offset;
	@JsonProperty
	BoxOrder<OrderByUsers> order;
	@JsonProperty("total_count")
	int totalCount;

	@JsonProperty
	Set<E> entries;

	public void forEach(Consumer<? super E> action) {
		entries.forEach(action);
	}

	public Iterator<E> iterator() {
		return entries.iterator();
	}

	public Spliterator<E> spliterator() {
		return entries.spliterator();
	}

}
