package com.example.pacientes;

import dominio.Clinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable{

    private Clinica clinica;
    private Scene sceneRelat;
    private Stage stageRelatorio;
    private RelatorioController relatorioController;

    @FXML
    private TextField textFieldCodigo, textFieldNome, textFieldPeso, textFieldIdade, textFieldAltura;

    @FXML
    private Button buttonIncluir, buttonRelatorio, buttonSair;

    @FXML
    private RadioButton radioFeminino, radioMasculino;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clinica = new Clinica();
        FXMLLoader fxmlLoader2 = new FXMLLoader();
        fxmlLoader2.setLocation(getClass().getResource("relatorio.fxml"));
        try {
            sceneRelat = new Scene(fxmlLoader2.load(), 403, 413);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stageRelatorio = new Stage();

        relatorioController = fxmlLoader2.getController();
        relatorioController.setClinica(this.clinica);
        stageRelatorio.setTitle("Relatorio");
        stageRelatorio.setScene(sceneRelat);
    }

    @FXML
    public void onButton(ActionEvent event) {
        if(event.getSource() == buttonSair)
            System.exit(0);

        if(event.getSource() == buttonIncluir){
            int codigo = Integer.parseInt(textFieldCodigo.getText());
            String nome = textFieldNome.getText();
            int peso = Integer.parseInt(textFieldPeso.getText());
            int idade = Integer.parseInt(textFieldIdade.getText());
            int altura = Integer.parseInt(textFieldAltura.getText());
            String genero = "";

            if(radioFeminino.isSelected())
                genero = "Feminino";
            else if(radioMasculino.isSelected())
                genero = "Masculino";

            clinica.addPaciente(codigo, nome, peso, genero, idade, altura);

            textFieldCodigo.setText("");
            textFieldNome.setText("");
            textFieldPeso.setText("");
            textFieldIdade.setText("");
            textFieldAltura.setText("");

            radioMasculino.setSelected(false);
            radioFeminino.setSelected(false);
        }

        if(event.getSource() == buttonRelatorio){
            relatorioController.atualizaRlatorio();
            stageRelatorio.show();
        }
    }

    @FXML
    public void onlyOneRadio(ActionEvent event){
        if(event.getSource() == radioFeminino){
            radioFeminino.setSelected(true);
            radioMasculino.setSelected(false);
        }else if(event.getSource() == radioMasculino){
            radioMasculino.setSelected(true);
            radioFeminino.setSelected(false);
        }
    }
}