package com.github.cleniogb.pessoa.controllers;

import com.github.cleniogb.pessoa.dto.request.PessoaDTO;
import com.github.cleniogb.pessoa.dto.response.MessageResponseDTO;
import com.github.cleniogb.pessoa.exception.PessoaNaoEncontradaException;
import com.github.cleniogb.pessoa.services.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.create(pessoaDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaDTO findById(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return pessoaService.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> listAll() {
        return pessoaService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        return pessoaService.update(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PessoaNaoEncontradaException {
        pessoaService.delete(id);
    }
}
