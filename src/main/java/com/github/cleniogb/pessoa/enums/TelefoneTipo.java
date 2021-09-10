package com.github.cleniogb.pessoa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TelefoneTipo {

    CASA("Casa"),
    CELULAR("Celular"),
    COMMERCIAL("Commercial");

    private final String descricao;
}
