package Algoritmos;

import java.util.stream.IntStream;

public class V_4_Parallel_Block {

    public double[][] v_4ParallelBlock(double[][] matrizA, double[][] matrizB, int size) {
        int bsize = (int) Math.sqrt(size);
        double[][] matrizResultado = new double[size][size];

        // Utiliza IntStream para generar un rango de índices para procesamiento paralelo.
        IntStream.range(0, 1).parallel().forEach(_i -> {  // El rango debería ser más grande para obtener beneficios de paralelización

            // Bucle externo para recorrer la matriz por bloques.
            for (int i1 = 0; i1 < size; i1 += bsize) {  // Recorre filas de la matrizA por bloques
                for (int j1 = 0; j1 < size; j1 += bsize) {  // Recorre columnas de la matrizA por bloques
                    for (int k1 = 0; k1 < size; k1 += bsize) {  // Recorre bloques para la multiplicación
                        // Bucle interno para multiplicar los bloques correspondientes.
                        for (int i = i1; i < i1 + bsize && i < size; i++) {  // Recorre filas del bloque de matrizA
                            for (int j = j1; j < j1 + bsize && j < size; j++) {  // Recorre columnas del bloque de matrizA
                                for (int k = k1; k < k1 + bsize && k < size; k++) {  // Recorre elementos del bloque de matrizA
                                    matrizResultado[i][k] += matrizA[i][j] * matrizB[j][k];  // Multiplica y suma al resultado
                                }
                            }
                        }
                    }
                }
            }
        });
        return matrizResultado;
    }
}
