package Algoritmos;

public class III_3_Sequential_block {

    public double[][] lll_3SequentialBlock(double[][] matrizA, double[][] matrizB, int size) {
        // Calcula el tamaño de bloque basado en la raíz cuadrada del tamaño total.
        int bsize = (int) Math.sqrt(size);
        // Crea una matriz para almacenar el resultado de la multiplicación.
        double[][] matrizResultado = new double[size][size];

        // Bucle externo para recorrer la matriz por bloques.
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    // Bucle interno para multiplicar los bloques.
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                // Multiplica los elementos de los bloques y suma al resultado.
                                matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                            }
                        }
                    }
                }
            }
        }
        return matrizResultado;
    }

}
