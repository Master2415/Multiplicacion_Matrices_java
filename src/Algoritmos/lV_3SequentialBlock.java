package Algoritmos;

public class lV_3SequentialBlock {

    public double[][] lV_3SequentialBlock_(double[][] matrizA, double[][] matrizB, int size) {
        // Calcula el tamaño de bloque basado en la raíz cuadrada del tamaño total.
        int bsize = (int) Math.sqrt(size);
        // Crea una matriz para almacenar el resultado de la multiplicación.
        double[][] matrizResultado = new double[size][size];

        // Bucle externo para recorrer la matriz por bloques.
        for (int i1 = 0; i1 < size; i1 += bsize) {  // Recorre filas de la matrizA por bloques
            for (int j1 = 0; j1 < size; j1 += bsize) {  // Recorre columnas de la matrizA por bloques
                for (int k1 = 0; k1 < size; k1 += bsize) {  // Recorre bloques para la multiplicación
                    // Bucle interno para multiplicar los bloques correspondientes.
                    for (int i = i1; i < i1 + bsize && i < size; i++) {  // Recorre filas del bloque de matrizA
                        for (int j = j1; j < j1 + bsize && j < size; j++) {  // Recorre columnas del bloque de matrizA
                            for (int k = k1; k < k1 + bsize && k < size; k++) {  // Recorre elementos del bloque para multiplicación
                                matrizResultado[i][k] += matrizA[i][j] * matrizB[j][k];  // Multiplica y suma al resultado
                            }
                        }
                    }
                }
            }
        }

        return matrizResultado;
    }


}
