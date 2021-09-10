package com.github.cleniogb.pessoa.mapper;

import com.github.cleniogb.pessoa.dto.mapper.PessoaMapper;
import com.github.cleniogb.pessoa.dto.request.PessoaDTO;
import com.github.cleniogb.pessoa.dto.request.TelefoneDTO;
import com.github.cleniogb.pessoa.entities.Pessoa;
import com.github.cleniogb.pessoa.entities.Telefone;
import com.github.cleniogb.pessoa.utils.PessoaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PessoaMapperTest {

    @Autowired
    private PessoaMapper pessoaMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PessoaDTO pessoaDTO = PessoaUtils.createFakeDTO();
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);

        assertEquals(pessoaDTO.getNome(), pessoa.getNome());
        assertEquals(pessoaDTO.getSobrenome(), pessoa.getSobrenome());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefoneDTO.getTipo(), telefone.getTipo());
        assertEquals(telefoneDTO.getNumero(), telefone.getNumero());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Pessoa pessoa = PessoaUtils.createFakeEntity();
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);

        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getSobrenome(), pessoaDTO.getSobrenome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefone.getTipo(), telefoneDTO.getTipo());
        assertEquals(telefone.getNumero(), telefoneDTO.getNumero());
    }
}
