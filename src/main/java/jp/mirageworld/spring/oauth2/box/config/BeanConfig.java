package jp.mirageworld.spring.oauth2.box.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.oauth2.client.registration.*;
import org.springframework.security.oauth2.client.web.reactive.function.client.*;
import org.springframework.security.oauth2.client.web.server.*;
import org.springframework.web.reactive.function.client.*;

@Configuration
public class BeanConfig {

	protected static final String API = "https://api.box.com/2.0/";

	final ReactiveClientRegistrationRepository client;

	final ServerOAuth2AuthorizedClientRepository auth;

	/**
	 * デフォルトコンストラクタ
	 * 
	 * @param client
	 *                   {@link ReactiveClientRegistrationRepository}
	 * @param auth
	 *                   {@link ServerOAuth2AuthorizedClientRepository}
	 */
	@Autowired
	public BeanConfig(
			ReactiveClientRegistrationRepository client,
			ServerOAuth2AuthorizedClientRepository auth) {
		this.client = client;
		this.auth = auth;
	}

	/**
	 * api.
	 * 
	 * @return {@link WebClient}.
	 */
	@Bean
	public WebClient adminClient() {
		return WebClient.builder().baseUrl(API)
				.filter(oauth2ExchangeFilterFunction())
				.build();
	}

	private ExchangeFilterFunction oauth2ExchangeFilterFunction() {
		return new ServerOAuth2AuthorizedClientExchangeFilterFunction(client, auth);
	}
}
