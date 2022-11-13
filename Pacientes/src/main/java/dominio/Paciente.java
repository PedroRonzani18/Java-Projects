package dominio;

public class Paciente implements Comparable{
    private int codigo;
    private String nome;
    private int peso;
    private String genero;
    private int idade;
    private int altura;

    public Paciente(int codigo, String nome, int peso, String genero, int idade, int altura) {
        this.codigo = codigo;
        this.nome = nome;
        this.peso = peso;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public int compareTo(Object o){
        Paciente p = (Paciente) o;

        if(this.codigo < p.getCodigo()) return -1;
        else if (this.codigo > p.getCodigo()) return 1;
        else return 0;
    }
}
