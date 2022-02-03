package com.jupging.jupgingServer.configs;

import com.jupging.jupgingServer.auth.jwt.JwtFilter;
import com.jupging.jupgingServer.auth.jwt.JwtProvider;
import com.jupging.jupgingServer.auth.oauth2.CustomOAuth2UserService;
import com.jupging.jupgingServer.auth.oauth2.OAuth2AuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService oAuth2UserService;
    private final JwtProvider jwtProvider;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
        .authorizeRequests()
            .antMatchers("/auth/sign-in", "/auth/sign-up").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(
                new JwtFilter(jwtProvider),
                UsernamePasswordAuthenticationFilter.class
            )
        .oauth2Login()
            .authorizationEndpoint()
                .baseUri("/oauth2/authorize")
                .and()
//            .redirectionEndpoint()
//                .baseUri("/*/oauth2/code/*")
//                .and()
            .userInfoEndpoint()
                .userService(oAuth2UserService)
                .and()
            .successHandler(oAuth2AuthenticationSuccessHandler);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
