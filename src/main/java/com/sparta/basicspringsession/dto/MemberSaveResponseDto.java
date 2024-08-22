package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class MemberSaveResponseDto {

    private final Long id;
    private final Long name;

    public MemberSaveResponseDto(Long id, Long name) {
        this.id = id;
        this.name = name;
    }
}
