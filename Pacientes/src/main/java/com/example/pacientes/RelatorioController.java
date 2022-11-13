package com.example.pacientes;

import dominio.Clinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class RelatorioController implements Initializable{

    Clinica clinica;

    @FXML
    private TextArea textAreaRelatorio;

    @FXML
    private Button buttonFechar;

    public void setClinica(Clinica clinica){
        this.clinica = clinica;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clinica = new Clinica();
    }

    public void atualizaRlatorio(){
        textAreaRelatorio.setText(clinica.exibePacientes());
    }

    @FXML
    public void onButton(ActionEvent event){
        if(event.getSource() == buttonFechar){
            Stage stage = (Stage) this.buttonFechar.getScene().getWindow();
            stage.close();
        }
    }
}