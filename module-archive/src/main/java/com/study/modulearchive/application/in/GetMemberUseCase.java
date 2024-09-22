package com.study.modulearchive.application.in;

import com.study.modulearchive.domain.Member;

import java.util.List;

public interface GetMemberUseCase {
    List<Member> findMembers();
    Member findOne(Long memberId);

}
