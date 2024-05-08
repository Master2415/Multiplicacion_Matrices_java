package Algoritmos;

public class NaivOnArray {
    // Constructor de la clase NaivOnArray que recibe tres matrices, y tres enteros para las dimensiones de las matrices
    public double[][] NaivOnArray(double[][] matrizA, double[][] matrizB, double[][] matrizC, int N, int P, int M){
        // Bucle externo que recorre las filas de la matriz C
        for (int i = 0; i < N; i++) {
            // Bucle interno que recorre las columnas de la matriz C
            for (int j = 0; j < M; j++) {
                // Inicializa el valor de la celda (i, j) en la matriz C a 0.0
                matrizC[i][j] = 0.0;
                // Bucle interno que realiza la multiplicación y suma de elementos de la matriz A y B
                for (int k = 0; k < P; k++) {
                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return matrizC;
    }
}

