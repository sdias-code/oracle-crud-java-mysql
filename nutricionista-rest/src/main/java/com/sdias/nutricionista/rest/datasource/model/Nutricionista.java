package com.sdias.nutricionista.rest.datasource.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "nutricionista")
public class Nutricionista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private LocalDate idade;

    @Column(name = "codigo_registro")
    private String CodigoRegistro;

    @Column(name = "id_paciente")
    private Long idPaciente;

    public Nutricionista() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String getCodigoRegistro() {
        return CodigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        CodigoRegistro = codigoRegistro;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
