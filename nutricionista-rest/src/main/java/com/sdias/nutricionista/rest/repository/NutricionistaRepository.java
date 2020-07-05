package com.sdias.nutricionista.rest.repository;

import com.sdias.nutricionista.rest.datasource.model.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {

}
