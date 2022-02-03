package com.jupging.jupgingServer.auth.oauth2;

import com.jupging.jupgingServer.auth.jwt.JwtProvider;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        log.info(authentication.getAuthorities().toString());
        String targetUrl = determineTargetUrl(request, response, authentication);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        String targetUrl = "http://localhost:8080/login/oauth2/code/google?";
        log.info(authentication.getPrincipal().toString());
        //DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
        //String email = oauthUser.getAttribute("email");
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//        User user = userRepository.findByEmail(email)
//            .orElseThrow();
        User user = userPrincipal.getUser();
        log.info(userPrincipal.getUser().toString());
        log.info(userPrincipal.getUsername() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
        log.info(user.toString());
        Long userId = user.getId();
        log.info(user.getId().toString());
        String accessToken = jwtProvider.createAccessToken(userId);

        return UriComponentsBuilder.fromUriString(targetUrl)
            .queryParam("accessToken", accessToken)
            .build()
            .toUriString();
    }
}
