package jp.mirageworld.spring.oauth2.box.api.values;

import com.fasterxml.jackson.annotation.*;

public enum OrderDirection {
	ASC, DESC;

	@JsonValue
	public String toJson() {
		return name();
	}

	@JsonCreator
	public static OrderDirection fromJson(String value) {
		return valueOf(value.toUpperCase());
	}

}
