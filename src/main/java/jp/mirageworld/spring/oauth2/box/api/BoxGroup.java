package jp.mirageworld.spring.oauth2.box.api;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoxGroup extends BoxEntity {

	@JsonProperty("group_type")
	String groupType;

}
