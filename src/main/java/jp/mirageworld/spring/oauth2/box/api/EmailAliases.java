package jp.mirageworld.spring.oauth2.box.api;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
public class EmailAliases {

	@JsonProperty
	Set<EmailAlias> entries;

	@JsonProperty("total_count")
	int totalCount;
}
