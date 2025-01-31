package com.client.ws.rasmooplus.filters;

import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.UserCredentials;
import com.client.ws.rasmooplus.repository.UserCredentialsRepository;
import com.client.ws.rasmooplus.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


public class AuthenticationFilter  extends OncePerRequestFilter {



    private TokenService tokenService;


    private UserCredentialsRepository userCredentialsRepository;



    public AuthenticationFilter(TokenService tokenService,UserCredentialsRepository userCredentialsRepository) {
        this.tokenService = tokenService;
        this.userCredentialsRepository = userCredentialsRepository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getBearerToken(request);
        if(tokenService.isValid(token)) {
            authByToken(token);
        }
        filterChain.doFilter(request, response);

    }

    private void authByToken(String token) {
        Long userId  = tokenService.getUserId(token);
        var userOpt = userCredentialsRepository.findById(userId);
        if(userOpt.isEmpty()) {
            throw  new NotFoundException("Usuario não encontrado");
        }
        UserCredentials userCredentials = userOpt.get();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userCredentials,null ,userCredentials.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String getBearerToken( HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (Objects.nonNull(token) && token.startsWith("Bearer")) {
            return token.substring(7, token.length());
        }
        return null;
    }
}
