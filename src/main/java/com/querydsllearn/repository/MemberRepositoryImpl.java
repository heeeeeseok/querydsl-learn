package com.querydsllearn.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsllearn.dto.MemberSearchCondition;
import com.querydsllearn.dto.MemberTeamDto;
import com.querydsllearn.dto.QMemberTeamDto;
import com.querydsllearn.entity.QMember;
import com.querydsllearn.entity.QTeam;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.querydsllearn.entity.QMember.member;
import static com.querydsllearn.entity.QTeam.team;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberTeamDto> search(MemberSearchCondition condition) {
        return null;
    }

    @Override
    public Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MemberTeamDto> searchComplex(MemberSearchCondition condition, Pageable pageable) {
        return null;
    }
}
