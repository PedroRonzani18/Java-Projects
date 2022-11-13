package com.project.quadradomagico;

public class QuadradoManager {

    private int quadradoMatrix[][];
    private int numeroSelecionado;

    public QuadradoManager() {
        quadradoMatrix = new int[3][3];
        numeroSelecionado = 0;
        limpaMatrix();
    }

    public void setNumeroSelecionado(int numeroSelecionado) {
        this.numeroSelecionado = numeroSelecionado;
    }
    public int getNumeroSelecionado() {
        return numeroSelecionado;
    }

    public void limpaMatrix()
    {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                quadradoMatrix[i][j] = 0;
            }
        }
        numeroSelecionado = 0;
    }

    public int confereVitoria()
    {
        // Sai do metodo se ainda existirem zeros
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (quadradoMatrix[i][j] == 0)
                    return 0;
            }
        }
        // Se chegou nesse ponto significa que ja foram colocados todos os 9 numeros

        // Confere linhas
        for(int i=0; i<3; i++)
            if(quadradoMatrix[i][0] + quadradoMatrix[i][1] + quadradoMatrix[i][2] != 15)
                return 1;

        // Confere colunas
        for(int i=0; i<3; i++)
            if(quadradoMatrix[0][i] + quadradoMatrix[1][i] + quadradoMatrix[2][i] != 15)
                return 1;

        // Confere primeira diagonal
        if(quadradoMatrix[0][0] + quadradoMatrix[1][1] + quadradoMatrix[2][2] != 15)
            return 1;

        // Confere segunda diagonal
        if(quadradoMatrix[0][2] + quadradoMatrix[1][1] + quadradoMatrix[2][0] != 15)
            return 1;

        return 2;
    }

    public int[] confereRepeticao()
    {
        int[] coord = new int[2];

        coord[0] = -1;
        coord[1] = -1;

        for(int i=0; i<3; i++)
        {
            for(int j=0;j<3;j++)
            {
                if(quadradoMatrix[i][j] == numeroSelecionado)
                {
                    quadradoMatrix[i][j] = 0;
                    coord[0] = i;
                    coord[1] = j;
                }
            }
        }
        return coord;
    }

    public int[] fazJogada(int i, int j)
    {
        int[] coord = new int[2];
        coord = confereRepeticao();
        quadradoMatrix[i][j] = numeroSelecionado;

        return coord;
    }
}
