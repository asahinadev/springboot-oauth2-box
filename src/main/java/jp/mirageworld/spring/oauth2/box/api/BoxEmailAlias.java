package jp.mirageworld.spring.oauth2.box.api;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoxEmailAlias {
	@JsonProperty
	long id;
	@JsonProperty
	String type;
	@JsonProperty
	String email;
	@JsonProperty("is_confirmed")
	boolean confirmed;
}
