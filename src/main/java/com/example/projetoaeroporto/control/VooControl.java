package com.example.projetoaeroporto.control;

import com.example.projetoaeroporto.entity.Voo;
import javafx.beans.property.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VooControl {

    public IntegerProperty id = new SimpleIntegerProperty(0);
    public StringProperty origem = new SimpleStringProperty("");
    public StringProperty destino = new SimpleStringProperty("");
    public ObjectProperty decolagem = new SimpleObjectProperty(LocalDateTime.now());
    public ObjectProperty pouso = new SimpleObjectProperty(LocalDateTime.now());
    public DoubleProperty preco= new SimpleDoubleProperty(0);

    private List<Voo> vooGeral = new ArrayList<>();
    private ObservableList<Voo>  voo = FXCollections.observableArrayList();


    public Voo toEntity() {
        Voo p = new Voo();
        p.setId(id.get());
        p.setOrigem(origem.get());
        p.setDestino(destino.get());
        p.setDecolagem((LocalDateTime)decolagem.get());
        p.setPouso((LocalDateTime)pouso.get());
        return p;
    }

    public void fromEntity(Voo v) {
        id.set(v.getId());
        origem.set(v.getOrigem());
        destino.set(v.getDestino());
        decolagem.set(v.getDecolagem());
        pouso.set(v.getPouso());
    }

    public ObservableList<Voo> getLista() {
        return voo;
    }
}
