package com.example.graphiccontabilidade;

import contabilidade.ControlePagamento;
import contabilidade.Titulo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {

    ControlePagamento controlePagamento;

    @FXML
    private RadioButton radioTitulo, radioConcessionaria, radioAssal, radioAssalComiss, radioComiss, radioTerceiriz;

    @FXML
    private RadioButton[] radioListConta, radioListEmpregado;

    @FXML
    private Button buttonNovo1, buttonNovo2, buttonLimpar1, buttonLimpar2, buttonSair1,buttonSair2,buttonSair3, buttonCalcular;

    @FXML
    private TextField textFieldVencimento, textFieldValor, textFieldNome, textFieldSobrenome, textFieldNumId, textFieldHorasT, textFieldHorasE, textFieldVendas, textFieldBonus, textFieldConta, textFieldEmpregados, textFieldValorTotal;

    @FXML
    public void onButtonConta(ActionEvent event){

        if(event.getSource() == buttonSair1 || event.getSource() == buttonSair2 || event.getSource() == buttonSair3)
            System.exit(0);

        if(event.getSource() == buttonNovo1){
            for(int i=0; i<2; i++){
                if(radioListConta[i].isSelected()){

                    String vencimento = textFieldVencimento.getText();
                    String[] numeros = vencimento.split("/");

                    int dia = Integer.parseInt(numeros[0]);
                    int mes = Integer.parseInt(numeros[1]);
                    int valor = Integer.parseInt(textFieldValor.getText());

                    if(radioListConta[i] == radioTitulo) controlePagamento.criaTitulo(dia,mes,valor);
                    if(radioListConta[i] == radioConcessionaria) controlePagamento.criaConcessionaria(dia,mes,valor);

                    textFieldVencimento.setText("");
                    textFieldValor.setText("");

                    radioListConta[i].setSelected(false);
                }
            }
        }

        if(event.getSource() == buttonLimpar1){
            textFieldVencimento.setText("");
            textFieldValor.setText("");
            for(int i=0; i<2; i++)
                radioListConta[i].setSelected(false);
        }
    }

    @FXML
    public void resetTextFields()
    {
        textFieldNome.setText("");
        textFieldSobrenome.setText("");
        textFieldNumId.setText("");
        textFieldHorasT.setText("");
        textFieldHorasE.setText("");
        textFieldVendas.setText("");
        textFieldBonus.setText("");

        textFieldNome.setStyle("-fx-background-color: #FFFFFF;");
        textFieldSobrenome.setStyle("-fx-background-color: #FFFFFF;");
        textFieldNumId.setStyle("-fx-background-color: #FFFFFF;");
        textFieldHorasT.setStyle("-fx-background-color: #FFFFFF;");
        textFieldHorasE.setStyle("-fx-background-color: #FFFFFF;");
        textFieldVendas.setStyle("-fx-background-color: #FFFFFF;");
        textFieldBonus.setStyle("-fx-background-color: #FFFFFF;");
    }

    @FXML
    public void onButtonEmpregado(ActionEvent event){
        if(event.getSource() == buttonSair2)
            System.exit(0);

        if(event.getSource() == buttonLimpar2) {
            resetTextFields();

            for(int i=0; i<4; i++)
                radioListEmpregado[i].setSelected(false);
        }

        if(event.getSource() == buttonNovo2){
            String nome = textFieldNome.getText();
            String sobrenome = textFieldSobrenome.getText();
            int  numIdent = Integer.parseInt(textFieldNumId.getText());
            int bonus, horasE, vendas, horasT;

            for(int i=0; i<4; i++){
                if(radioListEmpregado[i].isSelected()) {
                    if (radioListEmpregado[i] == radioAssal) {
                        horasE = Integer.parseInt(textFieldHorasE.getText());
                        controlePagamento.createAssalariado(nome, sobrenome, numIdent, horasE);
                    }

                    else if (radioListEmpregado[i] == radioAssalComiss) {
                        bonus = Integer.parseInt(textFieldBonus.getText());
                        controlePagamento.createAssalariadoComissionado(nome, sobrenome, numIdent, bonus);
                    }

                    else if (radioListEmpregado[i] == radioComiss) {
                        vendas = Integer.parseInt(textFieldVendas.getText());
                        controlePagamento.createComissionado(nome, sobrenome, numIdent);
                    }

                    else if (radioListEmpregado[i] == radioTerceiriz) {
                        horasT = Integer.parseInt(textFieldHorasT.getText());
                        controlePagamento.createTerceirizado(nome, sobrenome, numIdent);
                    }
                    radioListEmpregado[i].setSelected(false);
                }
            }
            resetTextFields();
        }
    }

    @FXML
    public void onButtonRelatorio(ActionEvent event){
        if(event.getSource() == buttonSair3)
            System.exit(0);

        if(event.getSource() == buttonCalcular){
            double imposto = controlePagamento.calculaImpostoTotal();
            double salario = controlePagamento.calculaSalarioTotal();
            double total = imposto + salario;

            textFieldConta.setText(Double.toString(imposto));
            textFieldEmpregados.setText(Double.toString(salario));
            textFieldValorTotal.setText(Double.toString(total));
        }
    }

    @FXML
    public void onlyOneOnRadioConta(ActionEvent event){
        for(int i=0; i<2; i++)        {
            if(event.getSource() != radioListConta[i]){
                radioListConta[i].setSelected(false);
            }else{
                radioListConta[i].setSelected(true);
            }
        }
    }

    @FXML
    public void onlyOneOnRadioEmpregado(ActionEvent event){
        for(int i=0; i<4; i++)
        {
            if(event.getSource() != radioListEmpregado[i]){
                radioListEmpregado[i].setSelected(false);
            }else{
                radioListEmpregado[i].setSelected(true);
            }

            textFieldNome.setStyle("-fx-background-color: #FFFFFF;");
            textFieldSobrenome.setStyle("-fx-background-color: #FFFFFF;");
            textFieldNumId.setStyle("-fx-background-color: #FFFFFF;");
            textFieldHorasT.setStyle("-fx-background-color: #FFFFFF;");
            textFieldHorasE.setStyle("-fx-background-color: #FFFFFF;");
            textFieldVendas.setStyle("-fx-background-color: #FFFFFF;");
            textFieldBonus.setStyle("-fx-background-color: #FFFFFF;");


            if(event.getSource() == radioAssal){
                textFieldHorasT.setStyle("-fx-background-color: #D3D3D3;");
                textFieldVendas.setStyle("-fx-background-color: #D3D3D3;");
                textFieldBonus.setStyle("-fx-background-color: #D3D3D3;");
            }

            if(event.getSource() == radioAssalComiss) {
                textFieldHorasT.setStyle("-fx-background-color: #D3D3D3;");
                textFieldHorasE.setStyle("-fx-background-color: #D3D3D3;");
                textFieldVendas.setStyle("-fx-background-color: #D3D3D3;");
            }

            if(event.getSource() == radioComiss) {
                textFieldHorasT.setStyle("-fx-background-color: #D3D3D3;");
                textFieldHorasE.setStyle("-fx-background-color: #D3D3D3;");
                textFieldBonus.setStyle("-fx-background-color: #D3D3D3;");
            }

            if(event.getSource() == radioTerceiriz) {
                textFieldHorasE.setStyle("-fx-background-color: #D3D3D3;");
                textFieldVendas.setStyle("-fx-background-color: #D3D3D3;");
                textFieldBonus.setStyle("-fx-background-color: #D3D3D3;");
            }
        }
    }

    public void initialize(){
        controlePagamento = new ControlePagamento();

        radioListConta = new RadioButton[2];
        radioListConta[0] = radioTitulo;
        radioListConta[1] = radioConcessionaria;

        radioListEmpregado = new RadioButton[4];
        radioListEmpregado[0] = radioAssal;
        radioListEmpregado[1] = radioAssalComiss;
        radioListEmpregado[2] = radioComiss;
        radioListEmpregado[3] = radioTerceiriz;
    }
}