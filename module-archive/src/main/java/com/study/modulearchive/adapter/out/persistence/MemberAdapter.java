package com.study.modulearchive.adapter.out.persistence;

import com.study.modulearchive.application.out.FindMemberPort;
import com.study.modulearchive.application.out.SaveMemberPort;
import com.study.modulearchive.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberAdapter implements FindMemberPort, SaveMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

}
