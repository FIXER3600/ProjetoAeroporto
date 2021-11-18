package com.example.projetoaeroporto.boundary;

import com.example.projetoaeroporto.control.VooControl;
import com.example.projetoaeroporto.entity.Voo;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateTimeStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class VooBoundary extends Application {
    private TextField txtId = new TextField();
    private TextField txtOrigem = new TextField();
    private TextField txtDestino = new TextField();
    private TextField txtDecolagem = new TextField();
    private TextField txtPouso = new TextField();
    private TextField txtAssentos = new TextField();
    private TextField txtPreco = new TextField();

    private TableView<Voo> table=new TableView<>();

    private final VooControl control = new VooControl();

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private Button btnReservar= new Button("Reservar");

    private void criarTabela(){
        TableColumn<Voo,Integer> col1=new TableColumn<>("Id");
        col1.setCellValueFactory(
                new PropertyValueFactory<Voo,Integer>("id")
        );
        TableColumn<Voo,String> col2=new TableColumn<>("Origem");
        col2.setCellValueFactory(
                new PropertyValueFactory<Voo,String>("Origem")
        );
        TableColumn<Voo,String> col3=new TableColumn<>("Destino");
        col3.setCellValueFactory(
                new PropertyValueFactory<Voo,String>("Destino")
        );
        TableColumn<Voo, String> col4=new TableColumn<>("Decolagem");
        col4.setCellValueFactory((item) -> {
                    LocalDateTime d = item.getValue().getDecolagem();
                    return new ReadOnlyStringWrapper(d.format(fmt));
                }
        );


        TableColumn<Voo, Double> col6 = new TableColumn<>("Preco");
        col6.setCellValueFactory(
                new PropertyValueFactory<Voo,Double>("Preco")
        );

        table.getSelectionModel().selectedItemProperty().addListener( (obs, old, novo) -> {
                    control.fromEntity(novo);
                }
        );

        table.getColumns().addAll(col1, col2, col3, col4);
        table.setItems(control.getLista());
    }
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane panPrincipal = new BorderPane();
        GridPane panCampos = new GridPane();

        panPrincipal.setTop(panCampos);
        panPrincipal.setCenter(table);
        
        Scene scn = new Scene(panPrincipal, 600, 400);


        Bindings.bindBidirectional(txtId.textProperty(), control.id, new NumberStringConverter());
        Bindings.bindBidirectional(txtOrigem.textProperty(), control.origem);
        Bindings.bindBidirectional(txtDestino.textProperty(), control.destino);
        Bindings.bindBidirectional(txtDecolagem.textProperty(), control.decolagem, new LocalDateTimeStringConverter());
        Bindings.bindBidirectional(txtPreco.textProperty(), control.preco, new NumberStringConverter());

        panCampos.add(new Label("Id:"), 0, 0);
        panCampos.add(txtId, 1, 0);
        panCampos.add(new Label("Origem:"), 0, 1);
        panCampos.add(txtOrigem, 1, 1);
        panCampos.add(new Label("Destino:"), 0, 2);
        panCampos.add(txtDestino, 1, 2);
        panCampos.add(new Label("Decolagem:"), 0, 3);
        panCampos.add(txtDecolagem, 1, 3);
        panCampos.add(new Label("Preco:"), 0, 4);
        panCampos.add(txtPreco, 1, 4);

        panCampos.add(btnReservar, 0, 5);


        stage.setTitle("Tela de Vôos");
        stage.setScene(scn);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(VooBoundary.class, args);
    }
}
