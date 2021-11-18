module com.example.projetoaeroporto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetoaeroporto to javafx.fxml;

    exports com.example.projetoaeroporto.boundary;
    opens com.example.projetoaeroporto.boundary to javafx.fxml;
    exports com.example.projetoaeroporto.control;
    opens com.example.projetoaeroporto.control to javafx.fxml;
    exports com.example.projetoaeroporto.entity;
    opens com.example.projetoaeroporto.entity to javafx.fxml;
}