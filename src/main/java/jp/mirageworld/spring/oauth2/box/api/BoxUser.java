package jp.mirageworld.spring.oauth2.box.api;

import java.net.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

import jp.mirageworld.spring.oauth2.box.api.values.*;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoxUser extends BoxEntity {

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

}
