package com.auth.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {

	
	
	
	 @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails admin = User.builder().username("aakash").password(passwordEncoder().encode("1234")).roles("ADMIN")
				.build();

		UserDetails user = User.builder().username("karan").password(passwordEncoder().encode("1122")).roles("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

		return security.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.GET).hasRole("USER")
						.requestMatchers(HttpMethod.POST).hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
						.anyRequest().authenticated())
				.httpBasic(org.springframework.security.config.Customizer.withDefaults()).build();
	}
}
