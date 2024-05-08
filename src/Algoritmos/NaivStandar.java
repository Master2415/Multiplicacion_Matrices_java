package Algoritmos;

public class NaivStandar {
    // Método para multiplicación de matrices de manera estándar
    public void NaivStandard(double[][] matrizA, double[][] matrizB, double[][] matrizC, int N, int P, int M){
        double aux; // Variable auxiliar para almacenar temporariamente el resultado de la multiplicación

        // Ciclo para recorrer las filas de la matriz A
        for (int i = 0; i < N; i++) {
            // Ciclo para recorrer las columnas de la matriz B
            for (int j = 0; j < M; j++) {
                aux = 0.0; // Inicializar la variable auxiliar en 0
                // Ciclo para realizar la multiplicación y acumulación de elementos de la matriz A y B
                for (int k = 0; k < P; k++) {
                    aux += matrizA[i][k] * matrizB[k][j]; // Multiplicar elementos y acumular el resultado en aux
                }
                matrizC[i][j] = aux; // Almacenar el resultado final en la matriz C
            }
        }
    }
}
