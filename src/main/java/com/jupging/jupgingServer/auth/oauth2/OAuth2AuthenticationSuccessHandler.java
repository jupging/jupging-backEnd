package com.jupging.jupgingServer.auth.oauth2;

import com.jupging.jupgingServer.auth.jwt.JwtProvider;
import com.jupging.jupgingServer.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        log.info(authentication.getAuthorities().toString());
        String targetUrl = determineTargetUrl(request, response, authentication);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        String targetUrl = "http://localhost:8000/oauth2/redirect?";
        log.info(authentication.getPrincipal().toString());
        User user = (User) authentication.getPrincipal();
        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = user.getRefreshToken();

        // refreshToken을 보내는게 맞나? 안보내도 될거 같기도
        // http://localhost:3000/oauth2/redirect?accessToken={jwt accessToken}?refreshToken={jwt refreshToken}
        return UriComponentsBuilder.fromUriString(targetUrl)
            .queryParam("accessToken", accessToken)
            .queryParam("refreshToken", refreshToken)
            .build()
            .toUriString();
    }
}
