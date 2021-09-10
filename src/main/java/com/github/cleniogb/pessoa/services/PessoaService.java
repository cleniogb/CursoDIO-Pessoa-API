package com.github.cleniogb.pessoa.services;

import com.github.cleniogb.pessoa.dto.mapper.PessoaMapper;
import com.github.cleniogb.pessoa.entities.Pessoa;
import com.github.cleniogb.pessoa.exception.PessoaNaoEncontradaException;
import lombok.AllArgsConstructor;
import com.github.cleniogb.pessoa.dto.request.PessoaDTO;
import com.github.cleniogb.pessoa.dto.response.MessageResponseDTO;
import com.github.cleniogb.pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private final PessoaRepository PessoaRepository;

    private final PessoaMapper PessoaMapper;

    public MessageResponseDTO create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = PessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = PessoaRepository.save(pessoa);

        MessageResponseDTO messageResponse = createMessageResponse("Pessoa adicionada com ID ", savedPessoa.getId());

        return messageResponse;
    }

    public PessoaDTO findById(Long id) throws PessoaNaoEncontradaException {
        Pessoa Pessoa = PessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));

        return PessoaMapper.toDTO(Pessoa);
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> people = PessoaRepository.findAll();
        return people.stream()
                .map(PessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        PessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));

        Pessoa updatedPessoa = PessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = PessoaRepository.save(updatedPessoa);

        MessageResponseDTO messageResponse = createMessageResponse("Pessoa com ID %s atualizada com sucesso", savedPessoa.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PessoaNaoEncontradaException {
        PessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));

        PessoaRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
