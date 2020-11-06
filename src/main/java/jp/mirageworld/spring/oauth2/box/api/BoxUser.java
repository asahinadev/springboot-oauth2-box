package jp.mirageworld.spring.oauth2.box.api;

import java.net.*;
import java.time.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

import jp.mirageworld.spring.oauth2.box.api.values.*;

import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoxUser {
	@JsonProperty
	long id;
	@JsonProperty
	String type;
	@JsonProperty
	String name;
	@JsonProperty
	String address;
	@JsonProperty
	String language;
	@JsonProperty
	URI avatar_url;
	@JsonProperty("notification_email")
	Set<BoxEmailAlias> notificationEmail;
	@JsonProperty
	String phone;
	@JsonProperty
	String login;
	@JsonProperty("job_title")
	String jobTitle;
	@JsonProperty
	AccountStatus status;
	@JsonProperty("max_upload_size")
	long maxUploadSize;
	@JsonProperty("space_amount")
	long spaceAmount;
	@JsonProperty("space_used")
	long spaceUsed;
	@JsonProperty
	String timezone;
	@JsonProperty("created_at")
	OffsetDateTime createdAt;
	@JsonProperty("modified_at")
	OffsetDateTime modifiedAt;

	@JsonAnySetter
	Map<String, Object> anyField = new HashMap<>();
}
