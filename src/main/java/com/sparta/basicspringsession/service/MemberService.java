package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        Member newMember = new Member(requestDto.getName());
        Member saveMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(saveMember.getId(), saveMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> memberList =  memberRepository.findAll();

        Lisdt<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : memberList) {
            MemberSimpleResponseDto dto = new MemberSimpleResponseDto(member.getName());
            dtoList.add(dto);
        }

        return dtoList;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));

        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateResponseDto(Long memberId, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(memberId),orElseThrow(() -> new NullPointerException("멤버가 없습니다."));

        member.update(requestDto.getName());

        return new MemberUpdateResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));

        memberRepository.delete(member);
    }
}

