package com.aone.config.security.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.aone.config.security.IAuthenticationFacade;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

	@Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
