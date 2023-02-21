package com.starlucks.member.infrastructure.persistence;

import com.starlucks.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

}
