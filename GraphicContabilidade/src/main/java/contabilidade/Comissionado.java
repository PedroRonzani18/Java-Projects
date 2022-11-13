package contabilidade;

public class Comissionado extends Empregado{
    private double valorVendas;

    public Comissionado(String nome, String sobrenome, int numIdent) {
        super(nome, sobrenome, numIdent);
    }

    public double getValorVendas() {
        return valorVendas;
    }
    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto) {
        return valorVendas * 0.06;
    }
}
