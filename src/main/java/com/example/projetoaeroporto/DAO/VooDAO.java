package com.example.projetoaeroporto.DAO;

import com.example.projetoaeroporto.entity.Voo;

import java.util.List;

public interface VooDAO {
    void reservar(Voo v);
    List<Voo> pesquisarPorId(Integer id);
    void remover(int id);
    void atualizar(int id, Voo v);
}
