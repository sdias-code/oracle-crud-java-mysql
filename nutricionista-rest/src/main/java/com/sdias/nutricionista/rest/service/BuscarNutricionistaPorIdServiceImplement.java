package com.sdias.nutricionista.rest.service;

import com.sdias.nutricionista.rest.datasource.model.Nutricionista;
import com.sdias.nutricionista.rest.exception.NutricionistaNotFoundException;
import com.sdias.nutricionista.rest.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarNutricionistaPorIdServiceImplement {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Autowired
    private CadastrarNutricionistaServiceImplement autalizarCadastro;

    public Nutricionista buscarPorId(Long id)
            throws NutricionistaNotFoundException {
        Optional<Nutricionista> optionalNutricionista = getOptional(id);

        Nutricionista nutricionista = null;
        if (!optionalNutricionista.isPresent()){
            throw new NutricionistaNotFoundException("Nutricionista não encontrado pelo id"+id);
        }else {
            nutricionista = optionalNutricionista.get();
        }
        return nutricionista;
    }

    private Optional<Nutricionista> getOptional(Long id) {
        return nutricionistaRepository.findById(id);
    }

    public void deletarPorId(Long id)
            throws NutricionistaNotFoundException {

        Optional<Nutricionista> optionalNutricionista = getOptional(id);

        if (!optionalNutricionista.isPresent()){
            throw new NutricionistaNotFoundException("Nutricionista não encontrado pelo id"+id);
        }else {
            nutricionistaRepository.delete(optionalNutricionista.get());
        }
    }

}
