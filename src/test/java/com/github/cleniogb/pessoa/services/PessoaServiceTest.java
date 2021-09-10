package com.github.cleniogb.pessoa.services;

import com.github.cleniogb.pessoa.dto.mapper.PessoaMapper;
import com.github.cleniogb.pessoa.dto.request.PessoaDTO;
import com.github.cleniogb.pessoa.dto.response.MessageResponseDTO;
import com.github.cleniogb.pessoa.entities.Pessoa;
import com.github.cleniogb.pessoa.repositories.PessoaRepository;
import com.github.cleniogb.pessoa.utils.PessoaUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PessoaDTO personDTO = PessoaUtils.createFakeDTO();
        Pessoa expectedSavedPessoa = PessoaUtils.createFakeEntity();

        when(pessoaMapper.toModel(personDTO)).thenReturn(expectedSavedPessoa);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(expectedSavedPessoa);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPessoa.getId());
        MessageResponseDTO successMessage = pessoaService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPessoaId) {
        return MessageResponseDTO.builder()
                .message("Pessoa adicionada com ID " + savedPessoaId)
                .build();
    }

}
