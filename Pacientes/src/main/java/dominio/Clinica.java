package dominio;

import java.util.ArrayList;

public class Clinica {
    private ArrayList<Paciente> pacientes;

    public Clinica() {
        pacientes = new ArrayList<>();
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        pacientes = pacientes;
    }

    public void addPaciente(int codigo, String nome, int peso, String genero, int idade, int altura) {
        Paciente paciente = new Paciente(codigo,nome,peso,genero,idade,altura);
        pacientes.add(paciente);
    }

    public double mediaIdadeHomem(){
        float idade = 0;
        int quant = 0;

        for(Paciente paciente: pacientes){
            if(paciente.getGenero().equals("Masculino")){
                idade += paciente.getIdade();
                quant++;
            }
        }
        if(idade == 0 || quant == 0)
            return 0;

        return idade/quant;
    }

    public int mulherSobrepeso(){
        int quant = 0;

        for(Paciente paciente: pacientes){
            if(paciente.getGenero().equals("Feminino")){
                if(160 <= paciente.getAltura() && paciente.getAltura() <=170){
                    if(paciente.getPeso() >= 70){
                      quant++;
                    }
                }
            }
        }
        return quant;
    }

    public int quantJovens(){
        int quant = 0;

        for(Paciente paciente: pacientes){
            if(18 <= paciente.getIdade() && paciente.getIdade() <= 25){
                quant++;
            }
        }

        return quant;
    }

    public String maisVelho(){
        String nome = "";
        int idade = -1;

        for(Paciente paciente: pacientes){
            if(paciente.getIdade() > idade){
                nome = paciente.getNome();
                idade = paciente.getIdade();
            }
        }
        return nome;
    }

    public String mulherMaisBaixa(){
        int altura = 1000000;
        String nome = "";

        for(Paciente paciente: pacientes){
            if(paciente.getGenero().equals("Feminino")){
                if(paciente.getAltura() < altura){
                    altura = paciente.getAltura();
                    nome = paciente.getNome();
                }
            }
        }
        return nome;
    }

    public String listaPacientes(){
        pacientes.sort(Paciente::compareTo);

        String lista = "";

        for(Paciente paciente: pacientes){
            lista+= Integer.toString(paciente.getCodigo()); lista += ". "; lista += paciente.getNome(); lista += "\n";
        }
        return lista;
    }

    public String exibePacientes(){
        String retorno = "";
        retorno += "Total de pacientes: "; retorno += Integer.toString(pacientes.size()); retorno += "\n";
        retorno += "Média idade homens: "; retorno += Double.toString(mediaIdadeHomem()); retorno += "\n";
        retorno += "Mulheres com sobrepeso: "; retorno += Integer.toString(mulherSobrepeso()); retorno += "\n";
        retorno += "Quantidade de jovens: "; retorno += Integer.toString(quantJovens()); retorno += "\n";
        retorno += "Paciente mais velho: "; retorno += maisVelho(); retorno += "\n";
        retorno += "Mulher mais baixa: "; retorno += mulherMaisBaixa(); retorno += "\n";
        retorno += "Lista de Pacientes:\n"; retorno += listaPacientes(); retorno += "\n";

        return retorno;
    }
}
