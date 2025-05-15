import edu.game.components.SudokuMatriz;

public class Main {
    public static void main(String[] args) {
        SudokuMatriz matriz = new SudokuMatriz(2);
        matriz.adicionarNumero(1, 0, 0);
        matriz.adicionarNumero(2, 0, 1);
        matriz.adicionarNumero(2, 0, 2);
        matriz.adicionarNumero(2, 1, 0);
        matriz.adicionarNumero(2, 1, 2);
    }
}