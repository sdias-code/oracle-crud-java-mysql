package com.sdias.nutricionista.rest.service;

import com.sdias.nutricionista.rest.datasource.model.Nutricionista;
import com.sdias.nutricionista.rest.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarNutricionistasServiceImplement {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    public List<Nutricionista> buscarTodosOsNutricionistas(){
        List<Nutricionista> nutricionistaList = nutricionistaRepository
                .findAll();
        return nutricionistaList;
    }

}
