package jp.mirageworld.spring.oauth2.box.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.reactive.*;
import org.springframework.security.config.web.server.*;
import org.springframework.security.config.web.server.ServerHttpSecurity.*;
import org.springframework.security.web.server.*;

@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain configure(ServerHttpSecurity http) throws Exception {
		return http

				// 認証必要
				.authorizeExchange((AuthorizeExchangeSpec exchange) -> {
					// プライバシーポリシー
					exchange.pathMatchers("/privacy").permitAll();
					// 特定商取引法
					exchange.pathMatchers("/order").permitAll();
					// 会社概要
					exchange.pathMatchers("/about").permitAll();
					// 上記以外
					exchange.anyExchange().authenticated();
				})

				// OAUTH2 LOGIN
				.oauth2Login().and()

				.build();
	}

}