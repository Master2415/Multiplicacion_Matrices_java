package Algoritmos;

public class NaivLoopUnrollingFour {
    // Constructor de la clase NaivLoopUnrollingFour que recibe tres matrices y tres enteros para las dimensiones de las matrices
    public double[][] NaivLoopUnrollingFour_(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        // Declaración de variables enteras i, j, k y una variable auxiliar para almacenar temporariamente resultados
        int i, j, k;
        double aux;

        // Verifica si P es divisible por 4
        if (P % 4 == 0) {
            // Bucle externo que recorre las filas de la matriz Result
            for (i = 0; i < N; i++) {
                // Bucle interno que recorre las columnas de la matriz Result
                for (j = 0; j < M; j++) {
                    aux = 0.0;
                    // Bucle interno con incremento de 4 para aplicar unrolling
                    for (k = 0; k < P; k += 4) {
                        // Realiza la multiplicación y suma de elementos de la matriz A y B
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }
                    // Asigna el valor calculado a la celda correspondiente de la matriz Result
                    Result[i][j] = aux;
                }
            }
        } else if (P % 4 == 1) {
            // Si P es congruente a 1 modulo 4
            int PP = P - 1;
            // Mismo esquema que el caso anterior pero con un elemento adicional al final
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 4) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }
                    Result[i][j] = aux + A[i][PP]*B[PP][j];
                }
            }
        } else if (P % 4 == 2) {
            // Si P es congruente a 2 modulo 4
            int PP = P - 2;
            int PPP = P - 1;
            // Mismo esquema que el caso anterior pero con dos elementos adicionales al final
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 4) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }
                    Result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j];
                }
            }
        } else {
            // Si P es congruente a 3 modulo 4
            int PP = P - 3;
            int PPP = P - 2;
            int PPPP = P - 1;
            // Mismo esquema que el caso anterior pero con tres elementos adicionales al final
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 4) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }
                    Result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j] + A[i][PPPP]*B[PPPP][j];
                }
            }
        }
        return Result;
    }
}

