package com.todoapp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.todoapp.Service.UserDtlsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDtlsService();
    }

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/home/register").permitAll() // Allow access to register endpoint
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .defaultSuccessUrl("/home/", true) // Redirect to home page after login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
