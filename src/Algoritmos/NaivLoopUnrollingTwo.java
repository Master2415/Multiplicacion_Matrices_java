package Algoritmos;

public class NaivLoopUnrollingTwo {

    // Constructor de la clase NaivLoopUnrollingTwo que recibe tres matrices y tres enteros para las dimensiones de las matrices
    public void NaivLoopUnrollingTwo(double[][] matrizA, double[][] matrizB, double[][] matrizC, int N, int P, int M) {
        // Declaración de variables enteras i, j, k y una variable auxiliar para almacenar temporariamente resultados
        int i, j, k;
        double aux;

        // Verifica si P es par
        if (P % 2 == 0) {
            // Bucle externo que recorre las filas de la matriz C
            for (i = 0; i < N; i++) {
                // Bucle interno que recorre las columnas de la matriz C
                for (j = 0; j < M; j++) {
                    aux = 0.0;
                    // Bucle interno con incremento de 2 para aplicar unrolling
                    for (k = 0; k < P; k += 2) {
                        // Realiza la multiplicación y suma de elementos de la matriz A y B
                        aux += matrizA[i][k] * matrizB[k][j] + matrizA[i][k + 1] * matrizB[k + 1][j];
                    }
                    // Asigna el valor calculado a la celda correspondiente de la matriz C
                    matrizC[i][j] = aux;
                }
            }
        } else {
            // Si P es impar, se calcula PP como P - 1
            int PP = P - 1;
            // Bucle externo que recorre las filas de la matriz C
            for (i = 0; i < N; i++) {
                // Bucle interno que recorre las columnas de la matriz C
                for (j = 0; j < M; j++) {
                    aux = 0.0;
                    // Bucle interno con incremento de 2 para aplicar unrolling
                    for (k = 0; k < PP; k += 2) {
                        // Realiza la multiplicación y suma de elementos de la matriz A y B
                        aux += matrizA[i][k] * matrizB[k][j] + matrizA[i][k + 1] * matrizB[k + 1][j];
                    }
                    // Añade el producto de la última columna de A con la última fila de B al resultado anterior
                    matrizC[i][j] = aux + matrizA[i][PP] * matrizB[PP][j];
                }
            }
        }
    }
}
