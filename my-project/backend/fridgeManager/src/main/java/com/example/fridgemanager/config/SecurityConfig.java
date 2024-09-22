package com.example.fridgemanager.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors
                .configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOriginPatterns(List.of("http://localhost:8080")); // 도메인 패턴 사용
                    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                    corsConfiguration.setAllowCredentials(true);
                    // 로그 출력
                    System.out.println("########### CORS Configuration: ############# :  " + corsConfiguration);
                    return corsConfiguration;
                })
            )
            .csrf().disable() // CSRF 비활성화 (테스트용)
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                	.requestMatchers("/test.html").permitAll()  // 특정 URL 허용
                	.requestMatchers("/api/hello").permitAll() // API 허용
                    .requestMatchers("/**").permitAll() // 모든 URL에 대해 접근 허용
                    .anyRequest().authenticated()                    
            )
            .formLogin(Customizer.withDefaults()) // 기본 로그인 설정 비활성화
            .httpBasic(Customizer.withDefaults()); // HTTP Basic 인증 비활성화
        
        return http.build();
    }
}