package jp.mirageworld.spring.oauth2.box.api.values;

import com.fasterxml.jackson.annotation.*;

public enum OrderByUsers {
	ID, NAME, TYPE, CREATED_AT, MODIFIED_AT;

	@JsonValue
	public String toJson() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static OrderByUsers fromJson(String value) {
		return valueOf(value.toUpperCase());
	}

}
