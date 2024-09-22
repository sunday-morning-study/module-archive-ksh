package com.study.modulearchive.adapter.in.web;

import com.study.modulearchive.application.dto.MemberDto;
import com.study.modulearchive.application.in.GetMemberUseCase;
import com.study.modulearchive.application.in.JoinMemberUseCase;
import com.study.modulearchive.domain.Address;
import com.study.modulearchive.domain.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final GetMemberUseCase getMemberUseCase;
    private final JoinMemberUseCase joinMemberUseCase;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        joinMemberUseCase.join(member);
        return "redirect:/";
    }

    @PostMapping("/members/join")
    public String join(@Valid MemberDto memberDto) {
        Member member = new Member();
        member.setName(memberDto.name());
        joinMemberUseCase.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = getMemberUseCase.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
