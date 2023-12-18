package com.example.likelionspringbootrestapi.domain.member.member.repository;

import com.example.likelionspringbootrestapi.domain.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
