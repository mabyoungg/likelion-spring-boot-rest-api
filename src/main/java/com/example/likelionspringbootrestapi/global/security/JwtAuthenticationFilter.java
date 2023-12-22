package com.example.likelionspringbootrestapi.global.security;

import com.example.likelionspringbootrestapi.domain.member.member.entity.Member;
import com.example.likelionspringbootrestapi.domain.member.member.service.MemberService;
import com.example.likelionspringbootrestapi.global.rq.Rq;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final MemberService memberService;
    private final Rq rq;

    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String apiKey = rq.getHeader("X-ApiKey", null);

        if (apiKey != null) {
            SecurityUser user = memberService.getUserFromApiKey(apiKey);

            rq.setAuthentication(user);
        }

        filterChain.doFilter(request, response);
    }
}
