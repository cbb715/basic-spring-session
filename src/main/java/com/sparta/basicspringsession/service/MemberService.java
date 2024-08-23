package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.MemberSaveRequestDto;
import com.sparta.basicspringsession.dto.MemberSaveResponseDto;
import com.sparta.basicspringsession.dto.MemberSimpleResponseDto;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {

        Member newMember = new Member(requestDto.getName());
        Member savedMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> memberList = memberRepository.findAll();

        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : memberList) {
            dtoList.add(new MemberSimpleResponseDto(member.getId(), member.getName()));
        }
        return dtoList;
    }
}