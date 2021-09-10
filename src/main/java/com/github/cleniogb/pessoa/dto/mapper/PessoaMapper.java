package com.github.cleniogb.pessoa.dto.mapper;

import com.github.cleniogb.pessoa.dto.request.PessoaDTO;
import com.github.cleniogb.pessoa.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO dto);

    PessoaDTO toDTO(Pessoa dto);
}
