package org.avi1606.ubetprojectauthservices.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.avi1606.ubetprojectauthservices.services.JwtServices;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtServices jwtServices;

    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = null;
        if (request.getCookies() != null) {
            for (Cookie cookies : request.getCookies()) {
                if (cookies.getName().equals("jwtToken")) {
                    token = cookies.getValue();
                }
            }
        }
        if (token == null) {
            filterChain.doFilter(request,response);
            return;
        }

        try {
            String email = jwtServices.extractEmail(token);

            if(email != null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                if (jwtServices.validToken(token, userDetails.getUsername())) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        } catch (Exception e) {
            // If JWT authentication fails, continue without setting authentication
            // This allows public endpoints to still work even with invalid/expired tokens
            System.out.println("JWT authentication failed: " + e.getMessage());
        }

        filterChain.doFilter(request,response);
    }
}
