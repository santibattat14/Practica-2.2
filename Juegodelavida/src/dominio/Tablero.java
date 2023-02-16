package dominio;

	
public class Tablero {
    private int[][] board;
    private int filas;
    private int columnas;

    public Tablero (int[][] initialBoard) {
        this.board = initialBoard;
        this.filas = initialBoard.length;
        this.columnas= initialBoard[0].length;
    }

    public void transitarAlEstadoSiguiente() {
        int[][] newBoard = new int[filas][columnas];

        // Calculate new board based on the rules of the game
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int count = generarEstadoActualPorMontecarlo(i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        newBoard[i][j] = 1;
                    }
                }
            }
        }

        board = newBoard; // Update current board
    }



    private int generarEstadoActualPorMontecarlo(int fila, int columna) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = (fila + i + filas) % filas;
                int c = (columna + j + columnas) % columnas;
                if (board[r][c] == 1 && !(i == 0 && j == 0)) {
                    count++;
                }
            }
        }
        return count;
    }


     public void printBoard() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


	
