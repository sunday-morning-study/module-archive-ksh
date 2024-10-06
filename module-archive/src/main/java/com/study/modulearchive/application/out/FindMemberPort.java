package com.study.modulearchive.application.out;

import com.study.modulearchive.domain.Member;

import java.util.List;

public interface FindMemberPort {
    Member findOne(Long id);
    List<Member> findAll();
    List<Member> findByName(String name);

}
