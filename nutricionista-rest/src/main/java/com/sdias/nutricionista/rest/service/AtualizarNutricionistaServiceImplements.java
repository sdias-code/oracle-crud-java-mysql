package com.sdias.nutricionista.rest.service;

import com.sdias.nutricionista.rest.datasource.model.Nutricionista;
import com.sdias.nutricionista.rest.exception.NutricionistaNotFoundException;
import com.sdias.nutricionista.rest.repository.NutricionistaRepository;
import com.sdias.nutricionista.rest.resource.model.NutricionistaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AtualizarNutricionistaServiceImplements {

    @Autowired
    NutricionistaRepository nutricionistaRepository;

    public Nutricionista atualizarNutricionista(NutricionistaResource nutricionistaResource, Long id)
            throws NutricionistaNotFoundException {

        Nutricionista buscarPorId = nutricionistaRepository.findById(id)
                .orElseThrow(()-> new NutricionistaNotFoundException("Nutricionista não encontrado pelo id"+ id));

        buscarPorId.setNome(nutricionistaResource.getNome());
        buscarPorId.setIdade(LocalDate.parse(nutricionistaResource.getIdade()));
        buscarPorId.setCodigoRegistro(nutricionistaResource.getCodigoRegistro());
        buscarPorId.setIdPaciente(Long.valueOf(nutricionistaResource.getIdPaciente()));

        final Nutricionista upateNutricionista = nutricionistaRepository.save(buscarPorId);
        return upateNutricionista;
    }
}
