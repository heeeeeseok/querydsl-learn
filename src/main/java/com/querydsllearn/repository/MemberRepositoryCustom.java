package com.querydsllearn.repository;

import com.querydsllearn.dto.MemberSearchCondition;
import com.querydsllearn.dto.MemberTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);
    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);
    Page<MemberTeamDto> searchComplex(MemberSearchCondition condition, Pageable pageable);

}
