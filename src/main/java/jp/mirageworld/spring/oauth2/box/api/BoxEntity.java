package jp.mirageworld.spring.oauth2.box.api;

import java.time.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoxEntity {

	@JsonProperty
	long id;
	@JsonProperty
	String type;
	@JsonProperty
	String name;

	@JsonProperty("created_at")
	OffsetDateTime createdAt;
	@JsonProperty("modified_at")
	OffsetDateTime modifiedAt;

	@JsonAnySetter
	Map<String, Object> anyField = new HashMap<>();
}
