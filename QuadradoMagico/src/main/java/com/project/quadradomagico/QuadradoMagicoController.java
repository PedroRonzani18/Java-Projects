package com.project.quadradomagico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class QuadradoMagicoController implements Initializable {

    QuadradoManager q ;

    @FXML
    private TextField field1, field2, field3, field4, field5, field6, field7, field8, field9;
    @FXML
    private TextField[][] textFieldMatrix;

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonSair, buttonLimpar;

    @FXML
    private Button[][] buttonMatrix;

    public void initMatrix() {
        buttonMatrix = new Button[3][3];

        buttonMatrix[0][0] = button1;
        buttonMatrix[0][1] = button2;
        buttonMatrix[0][2] = button3;
        buttonMatrix[1][0] = button4;
        buttonMatrix[1][1] = button5;
        buttonMatrix[1][2] = button6;
        buttonMatrix[2][0] = button7;
        buttonMatrix[2][1] = button8;
        buttonMatrix[2][2] = button9;

        textFieldMatrix = new TextField[3][3];

        textFieldMatrix[0][0] = field1;
        textFieldMatrix[0][1] = field2;
        textFieldMatrix[0][2] = field3;
        textFieldMatrix[1][0] = field4;
        textFieldMatrix[1][1] = field5;
        textFieldMatrix[1][2] = field6;
        textFieldMatrix[2][0] = field7;
        textFieldMatrix[2][1] = field8;
        textFieldMatrix[2][2] = field9;
    }

    public void clearMatrix() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                textFieldMatrix[i][j].setText("0");
            }
        }

        q.limpaMatrix();
    }

    public void display(String str, String title)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label lbl = new Label();
        lbl.setText(str);

        Button closeButton = new Button("Fechar");
        closeButton.setOnAction(e-> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(lbl,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public void mouseClicked(MouseEvent event) {
        String aux = Integer.toString(q.getNumeroSelecionado());
        int[] coord = new int[2];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(event.getSource() == textFieldMatrix[i][j]){
                    textFieldMatrix[i][j].setText(aux);
                    coord = q.fazJogada(i,j);
                }
            }
        }

        if(coord[0] != -1)
            textFieldMatrix[coord[0]][coord[1]].setText("0");

        if(q.confereVitoria() == 1){
            display("Você perdeu!", "Derrota");
            clearMatrix();
        }
        if(q.confereVitoria() == 2){
            display("Você Venceu!!!", "Vitória");
            clearMatrix();
        }
    }

    public void onClickButton(ActionEvent event) {
        int x=1;

        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++,x++){
                if(event.getSource() == buttonMatrix[i][j]){
                    this.q.setNumeroSelecionado(x);
                }
            }
        }

        if(event.getSource() == buttonSair) System.exit(0);
        if(event.getSource() == buttonLimpar) clearMatrix();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        q = new QuadradoManager();
        initMatrix();
    }
}