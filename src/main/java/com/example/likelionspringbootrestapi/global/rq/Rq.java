package com.example.likelionspringbootrestapi.global.rq;

import com.example.likelionspringbootrestapi.domain.member.member.entity.Member;
import com.example.likelionspringbootrestapi.domain.member.member.service.MemberService;
import com.example.likelionspringbootrestapi.global.security.SecurityUser;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.concurrent.atomic.AtomicMarkableReference;

@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final MemberService memberService;
    private Member member;
    private final EntityManager entityManager;

    public Member getMember() {
        if (member == null) {
            SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            long memberId = user.getId();

            member = entityManager.getReference(Member.class, memberId);
        }

        return member;
    }
}
