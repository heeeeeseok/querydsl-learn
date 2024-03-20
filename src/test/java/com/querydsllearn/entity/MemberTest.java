package com.querydsllearn.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.querydsllearn.entity.QMember.member;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
public class MemberTest {

    @Autowired
    EntityManager em;
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @BeforeEach
    void init() {
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 20);
        Member member3 = new Member("member3", 30);
        Member member4 = new Member("member4", 40);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    void findMemberGreaterThan20() {
        List<Member> result = jpaQueryFactory
                .selectFrom(member)
                .where(member.age.gt(20))
                .fetch();

        assertThat(result)
                .extracting("username")
                .containsExactly("member3", "member4");
    }
}
