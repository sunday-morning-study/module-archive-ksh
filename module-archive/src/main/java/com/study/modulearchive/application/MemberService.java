package com.study.modulearchive.application;

import com.study.modulearchive.application.in.JoinMemberUseCase;
import com.study.modulearchive.application.in.GetMemberUseCase;
import com.study.modulearchive.application.out.FindMemberPort;
import com.study.modulearchive.application.out.SaveMemberPort;
import com.study.modulearchive.domain.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements GetMemberUseCase, JoinMemberUseCase {

    private final FindMemberPort findMemberPort;
    private final SaveMemberPort saveMemberPort;

    /**
     * 회원 가입
     */
    @Override
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        saveMemberPort.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = findMemberPort.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    @Override
    public List<Member> findMembers() {
        return findMemberPort.findAll();
    }

    @Override
    public Member findOne(Long memberId) {
        return findMemberPort.findOne(memberId);
    }

}
