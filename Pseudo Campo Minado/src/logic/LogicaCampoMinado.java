package logic;

import java.security.SecureRandom;

public class LogicaCampoMinado {
    private int [][] campo; // 0 - bomba / 1 - sem bomba
    private static int posSemMinas = 84; //posicao sem minas
    private int tentativas;
    private SecureRandom random;

    public LogicaCampoMinado() {
        campo = new int [7][12];
        tentativas = 10;
        random = new SecureRandom();
        
        preencheCampo();
    }
    
    private void preencheCampo(){
        int posI, posJ;
        
        for(int i = 0; i < posSemMinas; i++){
            posI = random.nextInt(7);
            posJ = random.nextInt(12);
            
            if(campo[posI][posJ] == 1)
                i--;
            else
                campo[posI][posJ] = 1;
        }
    }
    
    private void limpaCampo(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 12; j++){
                campo[i][j] = 0;
            }
        }
    }
    
    public int realizaJogada(int i, int j){ // 2 - vitoria /1 - tentativa correta / 0 - derrota
        if(campo[i][j] == 1){ // sem bomba
            tentativas--;
            if(tentativas == 0){
                reinicia();
                return 2;
            }
            return 1;
        } //booooooom
        reinicia();
        return 0;
    }
    
    public void reinicia(){
        tentativas = 10;
        limpaCampo();
        preencheCampo();
    }

    public int getTentativas() {
        return tentativas;
    }
    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
}