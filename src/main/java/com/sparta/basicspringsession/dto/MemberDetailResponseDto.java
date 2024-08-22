package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class MemberDetailResponseDto {

    private final Long id;
    private final Long name;

    public MemberDetailResponseDto(Long id, Long name) {
        this.id = id;
        this.name = name;
    }

}
