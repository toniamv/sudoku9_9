package edu.game.components;


public class SudokuMatriz {
    private Position[][] m_principal;
    private int size;
    private int fq;
    private int lives = 3;
    private boolean isGameOver = false;

    // Dificultade do jogo = nº de quadrantes pr linha (2,3,4)
    public SudokuMatriz(int dif){
        size = dif*3;
        fq = size/3;
        m_principal = new Position[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                m_principal[i][j] = new Position(-1);
            }
        }
    }
    public boolean acabouJogo(){
        return isGameOver;
    }
//Calcula quadrante ((int)i/3)*fq+(int)j/3
    public void printaMatriz(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j+=3){
                System.out.print(m_principal[i][j].getValue() + " ");
                System.out.print(m_principal[i][j+1].getValue() + " ");
                System.out.print(m_principal[i][j+2].getValue());

                if(j+3 < size)System.out.print("|");
                else System.out.println();
            }
            if((i+1)%3 == 0) System.out.println("----------------------");
        }
    }

    public int adicionarNumero(int value, int x, int y){
        if(avaliarPosicao(value, x, y)){
            m_principal[x][y].setValue(value);
            printaMatriz();
            return 0;
        }
        if(avaliarJogo()) return 1;
        System.out.println("Não é recomendado adicionar " + value + " aqui");
        lives = lives-1;
        printaMatriz();
        return -1;
    }

    private int getQuadrante(int x, int y){
        return (x/3)*fq+y/3;
    }

    private boolean avaliarPosicao(int value, int x, int y){
        for(int i = 0; i < size; i++){
            if(m_principal[x][i].getValue() == value) return false;
            if(m_principal[i][y].getValue() == value) return false;
        }
        return avaliaQuadrante(getQuadrante(x,y), value);
    }

    private boolean avaliaQuadrante(int quadrante, int value){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(m_principal[i+3*(quadrante/fq)][j+3*(quadrante%fq)].getValue() == value){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean avaliarJogo(){
        if(lives == 0){
            System.out.println("Game Over!");
            isGameOver = true;
            return false;
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(m_principal[i][j].getValue() == -1) return false;
            }
        }
        return true;
    }
}
