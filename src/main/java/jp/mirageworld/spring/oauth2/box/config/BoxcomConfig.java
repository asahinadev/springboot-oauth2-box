package jp.mirageworld.spring.oauth2.box.config;

import org.springframework.boot.context.properties.*;
import org.springframework.stereotype.*;

import lombok.*;

@Data
@Component
@ConfigurationProperties(prefix = "jp.mirageworld.spring.oauth2.box.config")
public class BoxcomConfig {

	String accessToken;
}
