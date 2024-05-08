package Algoritmos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IV_5_Enhanced_Parallel_Block {

    public double[][] lV_5EnhancedParallelBlock(double[][] matrizA, double[][] matrizB, double[][] matrizC, int size) {
        int bsize = (int) Math.sqrt(size);
        double[][] matrizResultado = new double[size][size];
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Primer bloque para procesar la primera mitad de la matriz A en paralelo
        executor.execute(() -> {
            for (int i1 = 0; i1 < size / 2; i1 += bsize) {  // Recorre filas de la primera mitad de A por bloques
                for (int j1 = 0; j1 < size; j1 += bsize) {  // Recorre columnas de A por bloques
                    for (int k1 = 0; k1 < size; k1 += bsize) {  // Recorre bloques para la multiplicación
                        for (int i = i1; i < Math.min(i1 + bsize, size); i++) {  // Recorre filas del bloque de A
                            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {  // Recorre columnas del bloque de A
                                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {  // Recorre elementos del bloque de A
                                    matrizResultado[i][k] += matrizB[i][j] * matrizC[j][k];  // Multiplica y suma al resultado
                                }
                            }
                        }
                    }
                }
            }
        });

        // Segundo bloque para procesar la segunda mitad de la matriz A en paralelo
        executor.execute(() -> {
            for (int i1 = size / 2; i1 < size; i1 += bsize) {  // Recorre filas de la segunda mitad de A por bloques
                for (int j1 = 0; j1 < size; j1 += bsize) {  // Recorre columnas de A por bloques
                    for (int k1 = 0; k1 < size; k1 += bsize) {  // Recorre bloques para la multiplicación
                        for (int i = i1; i < Math.min(i1 + bsize, size); i++) {  // Recorre filas del bloque de A
                            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {  // Recorre columnas del bloque de A
                                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {  // Recorre elementos del bloque de A
                                    matrizResultado[i][k] += matrizB[i][j] * matrizC[j][k];  // Multiplica y suma al resultado
                                }
                            }
                        }
                    }
                }
            }
        });

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Espera a que todos los hilos terminen de ejecutarse
        }

        // A es la matriz de resultado modificada por los hilos
        matrizA = matrizResultado;
        return matrizA;
    }
}
