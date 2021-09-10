package com.github.cleniogb.pessoa.utils;

import com.github.cleniogb.pessoa.dto.request.TelefoneDTO;
import com.github.cleniogb.pessoa.entities.Telefone;
import com.github.cleniogb.pessoa.enums.TelefoneTipo;

public class TelefoneUtils {

    private static final String TELEFONE_NUMERO = "1199999-9999";
    private static final TelefoneTipo TELEFONE_TIPO = TelefoneTipo.CELULAR;
    private static final long TELEFONE_ID = 1L;

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .numero(TELEFONE_NUMERO)
                .tipo(TELEFONE_TIPO)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(TELEFONE_ID)
                .numero(TELEFONE_NUMERO)
                .tipo(TELEFONE_TIPO)
                .build();
    }
}
