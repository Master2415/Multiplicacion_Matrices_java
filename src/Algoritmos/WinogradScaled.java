package Algoritmos;

public class WinogradScaled {
    private WinogradOriginal winogradOriginal = new WinogradOriginal();

    public void WinogradScaled(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        int i;

        // Crear copias escaladas de A y B
        double[][] CopyA = new double[N][P];
        for (i = 0; i < N; i++) {
            System.arraycopy(A[i], 0, CopyA[i], 0, P);
        }
        double[][] CopyB = new double[P][M];
        for (i = 0; i < P; i++) {
            System.arraycopy(B[i], 0, CopyB[i], 0, M);
        }

        // Calcular factores de escala
        double a = NormInf(A, N, P);  // Necesitas implementar la función NormInf
        double b = NormInf(B, P, M);  // Necesitas implementar la función NormInf
        double lambda = Math.floor(0.5 + Math.log(b / a) / Math.log(4));

        // Escalar matrices
        MultiplyWithScalar(A, CopyA, N, P, Math.pow(2, lambda));  // Necesitas implementar MultiplyWithScalar
        MultiplyWithScalar(B, CopyB, P, M, Math.pow(2, -lambda));  // Necesitas implementar MultiplyWithScalar

        // Utilizar Winograd con las matrices escaladas
        winogradOriginal.WinogradOriginal(CopyA, CopyB, Result, N, P, M);  // Necesitas implementar WinogradOriginal
    }

    // Función que multiplica una matriz por un escalar y almacena el resultado en otra matriz
    private void MultiplyWithScalar(double[][] inputMatrix, double[][] outputMatrix, int rows, int cols, double scalar) {
        for (int i = 0; i < rows; i++) {  // Itera sobre las filas de la matriz
            for (int j = 0; j < cols; j++) {  // Itera sobre las columnas de la matriz
                outputMatrix[i][j] = inputMatrix[i][j] * scalar;  // Multiplica cada elemento por el escalar y lo guarda en la matriz de salida
            }
        }
    }

    // Función que calcula la norma infinito de una matriz
    private double NormInf(double[][] matrix, int rows, int cols) {
        double maxNorm = 0.0;  // Inicializa la norma máxima como 0
        for (int i = 0; i < rows; i++) {  // Itera sobre las filas de la matriz
            double rowNorm = 0.0;  // Inicializa la norma de la fila como 0
            for (int j = 0; j < cols; j++) {  // Itera sobre las columnas de la matriz
                rowNorm += Math.abs(matrix[i][j]);  // Suma el valor absoluto de cada elemento en la fila
            }
            maxNorm = Math.max(maxNorm, rowNorm);  // Actualiza la norma máxima si la norma de la fila es mayor
        }
        return maxNorm;  // Devuelve la norma máxima de la matriz (norma infinito)
    }

}
