package jp.mirageworld.spring.oauth2.box.api;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
public class EmailAlias {

	public static enum Type {
		email_alias;

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

	@JsonProperty
	String id;

	@JsonProperty
	Type type;

	@JsonProperty
	String email;

	@JsonProperty("is_confirmed")
	boolean confirmed;

}
