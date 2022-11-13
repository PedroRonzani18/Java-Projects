package contabilidade;

import java.util.ArrayList;

public class ControlePagamento {
    private ArrayList<Passivo> pagamentos = new ArrayList<>();

    public ControlePagamento(ArrayList<Passivo> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public ControlePagamento(){}

    public ArrayList<Passivo> getPagamentos() {
        return pagamentos;
    }
    public void setPagamentos(ArrayList<Passivo> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void adicionaPassivo(Passivo passivo){
        pagamentos.add(passivo);
    }

    public double calculaSalarioTotal(){
        int valor=0;

        for(Passivo i: pagamentos) {
            if (i instanceof Empregado)
                valor += i.getValorAPagar(20, 9);
        }
        return valor;
    }

    public void criaTitulo(int dia, int mes, int valor){
        Passivo titulo = new Titulo(dia,mes,valor);
        this.adicionaPassivo(titulo);
    }

    public void criaConcessionaria(int dia, int mes, int valor){
        Passivo concessionaria = new Concessionaria(dia,mes,valor);
        this.adicionaPassivo(concessionaria);
    }

    public void createAssalariado(String nome, String sobrenome, int numIdent, int horasE){
        Passivo assalariado = new Assalariado(nome, sobrenome, numIdent, horasE);
        this.adicionaPassivo(assalariado);
    }

    public void createComissionado(String nome, String sobrenome, int numIdent){
        Passivo comiss = new Comissionado(nome,sobrenome,numIdent);
        this.adicionaPassivo(comiss);

    }

    public void createTerceirizado(String nome, String sobrenome, int numIdent){
        Passivo terc = new Terceirizado(nome, sobrenome,numIdent);
        this.adicionaPassivo(terc);
    }

    public void createAssalariadoComissionado(String nome, String sobrenome, int numIdent, int bonus){
        Passivo asCom = new AssalariadoComissionado(nome, sobrenome, numIdent, bonus/100.0);
        this.adicionaPassivo(asCom);
    }

    public double calculaImpostoTotal(){
        int valor=0;

        for(Passivo i: pagamentos) {
            if (i instanceof Conta)
                valor += i.getValorAPagar(20, 9);
        }
        return valor;
    }
}
