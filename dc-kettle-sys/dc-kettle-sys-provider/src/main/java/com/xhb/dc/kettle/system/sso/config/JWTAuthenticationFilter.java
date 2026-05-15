package com.xhb.dc.kettle.system.sso.config;

import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * JWTAuthenticationFilter.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    private final TokenStore tokenStore;

    public JWTAuthenticationFilter(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain filterChain)
        throws IOException, ServletException {
        return;
      /*  HttpServletRequest request1 = (HttpServletRequest) request;
        if (request1.getRequestURI().startsWith("/actuator/") || request1.getRequestURI().startsWith("/v2/api-docs")) {

        }
        HttpServletResponse response = (HttpServletResponse) res;
        Authentication authentication = TokenAuthenticationService.getAuthentication(request1, response, tokenStore);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);*/

    }
}
