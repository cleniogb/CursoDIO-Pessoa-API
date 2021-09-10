package com.github.cleniogb.pessoa.utils;

import com.github.cleniogb.pessoa.dto.request.PessoaDTO;
import com.github.cleniogb.pessoa.entities.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String NOME = "Clenio";
    private static final String SOBRENOME = "Borges";
    private static final String CPF = "999.999.999-99";
    private static final long PESSOA_ID = 1L;
    public static final LocalDate ANIVERSARIO = LocalDate.of(1977, 9, 21);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .aniversario("21-09-1977")
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PESSOA_ID)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .aniversario(ANIVERSARIO)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }




}
