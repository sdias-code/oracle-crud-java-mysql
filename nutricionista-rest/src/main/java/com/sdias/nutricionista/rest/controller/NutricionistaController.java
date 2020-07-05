package com.sdias.nutricionista.rest.controller;

import com.sdias.nutricionista.rest.datasource.model.Nutricionista;
import com.sdias.nutricionista.rest.exception.NutricionistaNotFoundException;
import com.sdias.nutricionista.rest.exception.NutricionistaResourceException;
import com.sdias.nutricionista.rest.repository.NutricionistaRepository;
import com.sdias.nutricionista.rest.resource.model.NutricionistaResource;
import com.sdias.nutricionista.rest.service.AtualizarNutricionistaServiceImplements;
import com.sdias.nutricionista.rest.service.BuscarNutricionistaPorIdServiceImplement;
import com.sdias.nutricionista.rest.service.BuscarNutricionistasServiceImplement;
import com.sdias.nutricionista.rest.service.CadastrarNutricionistaServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/nutricionista")
public class NutricionistaController {

    @Autowired
    NutricionistaRepository nutricionistaRepository;

    @Autowired
    private BuscarNutricionistasServiceImplement serviceBuscar;

    @Autowired
    private BuscarNutricionistaPorIdServiceImplement serviceBuscarPorId;

    @Autowired
    private CadastrarNutricionistaServiceImplement serviceCadastrar;

    @Autowired
    private AtualizarNutricionistaServiceImplements serviceAtualizarPorId;

    @GetMapping
    public List<Nutricionista> buscarTodos() {
        return serviceBuscar.buscarTodosOsNutricionistas();
    }

    @GetMapping(path = "/{id}")
    public Nutricionista buscarPorId(
            @PathVariable(name = "id", required = true) Long id)
            throws NutricionistaNotFoundException {
        return serviceBuscarPorId.buscarPorId(id);
    }

    @PostMapping
    public void salvarNutricionista(
            @RequestBody NutricionistaResource nutricionista)
            throws NutricionistaResourceException {
        serviceCadastrar.cadastro(nutricionista);
    }

    @PutMapping(path = "/{id}")
    public Nutricionista updateNutricionista(
            @PathVariable(value = "id") Long id,
            @Valid @RequestBody NutricionistaResource nutricionistaResource)
            throws NutricionistaNotFoundException {
        Nutricionista nutricionista = serviceAtualizarPorId.atualizarNutricionista(nutricionistaResource, id);
        return nutricionista;

    }


    @DeleteMapping(path = "/{id}")
    public void deleteNutricionista(
            @PathVariable(name = "id", required = true) Long id)
            throws NutricionistaNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }
}
