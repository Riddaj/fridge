package com.example.fridgemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll() // '/api/**' 경로를 인증 없이 접근 허용
                .anyRequest().authenticated()
            .and()
            .formLogin().disable(); // 기본 로그인 폼 비활성화
        
        // CORS 설정 추가
        http.cors();
        
        
        return http.build();
    }
    
}
