package com.sdias.nutricionista.rest.service;

import com.sdias.nutricionista.rest.datasource.model.Nutricionista;
import com.sdias.nutricionista.rest.exception.NutricionistaResourceException;
import com.sdias.nutricionista.rest.repository.NutricionistaRepository;
import com.sdias.nutricionista.rest.resource.model.NutricionistaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarNutricionistaServiceImplement {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Autowired
    private NutricionistaConversor service;

    //Cadastrando nutricionista no banco de dados
    public void cadastro(NutricionistaResource nutricionistaResource)
            throws NutricionistaResourceException {

        try{
            Nutricionista nutricionista = service.conversor(nutricionistaResource);
            nutricionistaRepository.saveAndFlush(nutricionista);

        } catch (NutricionistaResourceException e) {
            e.printStackTrace();
        }

    }

}
