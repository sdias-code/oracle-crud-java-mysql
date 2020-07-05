package com.sdias.nutricionista.rest.service;

import com.sdias.nutricionista.rest.datasource.model.Nutricionista;
import com.sdias.nutricionista.rest.exception.NutricionistaResourceException;
import com.sdias.nutricionista.rest.resource.model.NutricionistaResource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NutricionistaConversor {

    public Nutricionista conversor(
            NutricionistaResource nutricionistaResource)
            throws NutricionistaResourceException {

        try {
            Nutricionista nutricionista = new Nutricionista();
            Long idPaciente = checkIdPaciente(nutricionistaResource.getIdPaciente());

            LocalDate idade = checkIdade(nutricionistaResource.getIdade());
            nutricionista.setIdPaciente(idPaciente);
            nutricionista.setIdade(idade);
            nutricionista.setCodigoRegistro(nutricionistaResource.getCodigoRegistro());
            nutricionista.setNome(nutricionistaResource.getNome());
            return nutricionista;

        }catch (Exception e){
            throw new NutricionistaResourceException(
                    "Falha ao converter o resource para entidade, resource"+
                    nutricionistaResource);
        }

    }

    private Long checkIdPaciente(String idPaciente){
        return Long.parseLong(idPaciente);
    }

    private LocalDate checkIdade(String idade){
        return LocalDate.parse(idade);
    }
}
