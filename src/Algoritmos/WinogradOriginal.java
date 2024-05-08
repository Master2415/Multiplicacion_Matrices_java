package Algoritmos;

public class WinogradOriginal {
    public double[][] WinogradOriginal_(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        int i, j, k;
        double aux;
        int upsilon = P % 2;
        int gamma = P - upsilon;
        double[] y = new double[M];
        double[] z = new double[N];

        // Cálculo de y
        for (i = 0; i < M; i++) {
            aux = 0.0;
            // Bucle para calcular la sumatoria de productos de elementos de A
            for (j = 0; j < gamma; j += 2) {
                aux += A[i][j] * A[i][j+1];
            }
            y[i] = aux; // Almacena el resultado en el vector y
        }

        // Cálculo de z
        for (i = 0; i < N; i++) {
            aux = 0.0;
            // Bucle para calcular la sumatoria de productos de elementos de B
            for (j = 0; j < gamma; j += 2) {
                aux += B[j][i] * B[j+1][i];
            }
            z[i] = aux; // Almacena el resultado en el vector z
        }

        // Verifica si upsilon es igual a 1
        if (upsilon == 1) {
            int PP = P - 1;
            // Bucle externo que recorre las filas de Result
            for (i = 0; i < M; i++) {
                // Bucle interno que recorre las columnas de Result
                for (k = 0; k < N; k++) {
                    aux = 0.0;
                    // Bucle para calcular la sumatoria de productos para el caso especial de upsilon igual a 1
                    for (j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k]);
                    }
                    // Asigna el resultado ajustado a la celda correspondiente de Result
                    Result[i][k] = aux - y[i] - z[k] + A[i][PP] * B[PP][k];
                }
            }
        } else {
            // Bucle externo que recorre las filas de Result para el caso general
            for (i = 0; i < M; i++) {
                // Bucle interno que recorre las columnas de Result para el caso general
                for (k = 0; k < N; k++) {
                    aux = 0.0;
                    // Bucle para calcular la sumatoria de productos para el caso general
                    for (j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k]);
                    }
                    // Asigna el resultado ajustado a la celda correspondiente de Result
                    Result[i][k] = aux - y[i] - z[k];
                }
            }
        }

        // Liberación de memoria asignada a los vectores y z
        y = null;
        z = null;
        return Result;
    }
}

