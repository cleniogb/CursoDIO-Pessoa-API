package com.github.cleniogb.pessoa.dto.mapper;

import com.github.cleniogb.pessoa.dto.request.PessoaDTO;
import com.github.cleniogb.pessoa.dto.request.TelefoneDTO;
import com.github.cleniogb.pessoa.entities.Pessoa;
import com.github.cleniogb.pessoa.entities.Telefone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-10T16:04:57-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public Pessoa toModel(PessoaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        if ( dto.getAniversario() != null ) {
            pessoa.setAniversario( LocalDate.parse( dto.getAniversario(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        pessoa.setId( dto.getId() );
        pessoa.setNome( dto.getNome() );
        pessoa.setSobrenome( dto.getSobrenome() );
        pessoa.setCpf( dto.getCpf() );
        pessoa.setTelefones( telefoneDTOListToTelefoneList( dto.getTelefones() ) );

        return pessoa;
    }

    @Override
    public PessoaDTO toDTO(Pessoa dto) {
        if ( dto == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId( dto.getId() );
        pessoaDTO.setNome( dto.getNome() );
        pessoaDTO.setSobrenome( dto.getSobrenome() );
        pessoaDTO.setCpf( dto.getCpf() );
        if ( dto.getAniversario() != null ) {
            pessoaDTO.setAniversario( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getAniversario() ) );
        }
        pessoaDTO.setTelefones( telefoneListToTelefoneDTOList( dto.getTelefones() ) );

        return pessoaDTO;
    }

    protected Telefone telefoneDTOToTelefone(TelefoneDTO telefoneDTO) {
        if ( telefoneDTO == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setId( telefoneDTO.getId() );
        telefone.setTipo( telefoneDTO.getTipo() );
        telefone.setNumero( telefoneDTO.getNumero() );

        return telefone;
    }

    protected List<Telefone> telefoneDTOListToTelefoneList(List<TelefoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Telefone> list1 = new ArrayList<Telefone>( list.size() );
        for ( TelefoneDTO telefoneDTO : list ) {
            list1.add( telefoneDTOToTelefone( telefoneDTO ) );
        }

        return list1;
    }

    protected TelefoneDTO telefoneToTelefoneDTO(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneDTO telefoneDTO = new TelefoneDTO();

        telefoneDTO.setId( telefone.getId() );
        telefoneDTO.setTipo( telefone.getTipo() );
        telefoneDTO.setNumero( telefone.getNumero() );

        return telefoneDTO;
    }

    protected List<TelefoneDTO> telefoneListToTelefoneDTOList(List<Telefone> list) {
        if ( list == null ) {
            return null;
        }

        List<TelefoneDTO> list1 = new ArrayList<TelefoneDTO>( list.size() );
        for ( Telefone telefone : list ) {
            list1.add( telefoneToTelefoneDTO( telefone ) );
        }

        return list1;
    }
}
