package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponseDto {

    private final Long id;
    private final Long name;

    public MemberUpdateResponseDto(Long id, Long name) {
        this.id = id;
        this.name = name;
    }
}