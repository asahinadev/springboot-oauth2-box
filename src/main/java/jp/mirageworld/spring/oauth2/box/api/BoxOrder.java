package jp.mirageworld.spring.oauth2.box.api;

import com.fasterxml.jackson.annotation.*;

import jp.mirageworld.spring.oauth2.box.api.values.*;

import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoxOrder<E extends Enum<E>> {

	@JsonProperty
	E by;

	@JsonProperty
	OrderDirection direction;

}
