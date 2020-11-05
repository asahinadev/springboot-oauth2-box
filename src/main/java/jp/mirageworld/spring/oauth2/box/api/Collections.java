package jp.mirageworld.spring.oauth2.box.api;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
public class Collections {

	@Data
	public static final class Order {
		@JsonProperty
		OrderBy by;

		@JsonProperty
		OrderDirection direction;
	}

	public static enum OrderBy {
		id, type, name, collection_type;

		@JsonValue
		@Override
		public String toString() {
			return super.name();
		}

		@JsonCreator
		public static OrderBy valueof(String value) {
			return Enum.valueOf(OrderBy.class, value);
		}
	}

	public static enum OrderDirection {
		ASC, DESC;

		@JsonValue
		@Override
		public String toString() {
			return super.name();
		}

		@JsonCreator
		public static OrderDirection valueof(String value) {
			return Enum.valueOf(OrderDirection.class, value);
		}
	}

	@JsonProperty
	Set<Collection> entries;

	@JsonProperty
	int limit;

	@JsonProperty
	int offset;

	@JsonProperty
	Order order;

	@JsonProperty("total_count")
	int totalCount;
}
