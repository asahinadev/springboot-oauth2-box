package jp.mirageworld.spring.oauth2.box.api.values;

import com.fasterxml.jackson.annotation.*;

public enum AccountStatus {
	ACTIVE, INACTIVE, CANNOT_DELETE_EDIT, CANNOT_DELETE_EDIT_UPLOAD;

	@JsonValue
	public String toJson() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static AccountStatus fromJson(String value) {
		return valueOf(value.toUpperCase());
	}
}
