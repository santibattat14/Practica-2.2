package dominio;

	
public class Tablero {
    private int[][] tablero;
    private int filas;
    private int columnas;

    public Tablero (int[][] initialTablero) {
        this.tablero = initialTablero;
        this.filas = initialTablero.length;
        this.columnas= initialTablero[0].length;
    }

    public void transitarAlEstadoSiguiente() {
        int[][] newTablero = new int[filas][columnas];

        // Calculate new board based on the rules of the game
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int count = generarEstadoActualPorMontecarlo(i, j);
                if (tablero[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        newTablero[i][j] = 0;
                    } else {
                        newTablero[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        newTablero[i][j] = 1;
                    }
                }
            }
        }

        tablero = newTablero; // Update current board
    }



    public int generarEstadoActualPorMontecarlo(int fila, int columna) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = (fila + i + filas) % filas;
                int c = (columna + j + columnas) % columnas;
                if (tablero[r][c] == 1 && !(i == 0 && j == 0)) {
                    count++;
                }
            }
        }
        return count;
    }


     public void inprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}


	
