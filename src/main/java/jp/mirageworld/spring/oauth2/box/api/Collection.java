package jp.mirageworld.spring.oauth2.box.api;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
public class Collection {

	public static enum Type {
		collection;

		@JsonValue
		@Override
		public String toString() {
			return super.name();
		}

		@JsonCreator
		public static Type valueof(String value) {
			return Enum.valueOf(Type.class, value);
		}
	}

	public static enum CollectionType {
		favorites;

		@JsonValue
		@Override
		public String toString() {
			return super.name();
		}

		@JsonCreator
		public static CollectionType valueof(String value) {
			return Enum.valueOf(CollectionType.class, value);
		}
	}

	public static enum Name {
		Favorites;

		@JsonValue
		@Override
		public String toString() {
			return super.name();
		}

		@JsonCreator
		public static Name valueof(String value) {
			return Enum.valueOf(Name.class, value);
		}
	}

	@JsonProperty
	String id;

	@JsonProperty
	Type type;

	@JsonProperty("collection_type")
	CollectionType collectionType;

	@JsonProperty
	Name name;

}
