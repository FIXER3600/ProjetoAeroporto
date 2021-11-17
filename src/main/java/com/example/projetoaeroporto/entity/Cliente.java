package com.example.projetoaeroporto.entity;

import java.time.LocalDate;

public class Cliente {
    private String Nome;
    private String Rg;
    private LocalDate Nascimento;
    private String Sexo;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public LocalDate getNascimento() {
        return Nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        Nascimento = nascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }
    @Override
    public String toString() {
        return this.Nome;
    }

}
