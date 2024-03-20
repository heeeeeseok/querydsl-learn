package com.querydsllearn.controller;

import com.querydsllearn.dto.MemberSearchCondition;
import com.querydsllearn.dto.MemberTeamDto;
import com.querydsllearn.entity.Member;
import com.querydsllearn.entity.Team;
import com.querydsllearn.repository.MemberRepository;
import com.querydsllearn.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberSearchController {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @PostMapping("/members/init")
    public String init() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        return "init data success";
    }

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberWithCondition(MemberSearchCondition condition) {
        return memberRepository.search(condition);
    }

    @GetMapping("/v2/members")
    public Page<MemberTeamDto> searchMemberWithCondition(MemberSearchCondition condition, Pageable pageable) {
        return memberRepository.searchPage(condition, pageable);
    }
}
