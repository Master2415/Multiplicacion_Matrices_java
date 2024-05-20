package Algoritmos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class III_5_Enhanced_Parallel_Block {

    public double[][] lll_ParallelDo(double[][] A, double[][] B, double[][] C, int size) {
        // Calcula el tamaño de bloque basado en la raíz cuadrada del tamaño total.
        int bsize = (int) Math.sqrt(size);

        // Crea una matriz de resultado para almacenar los resultados de la multiplicación.
        double[][] matrizResultado = new double[size][size];

        // Crea un ExecutorService para manejar los hilos.
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Primer bloque para procesar la primera mitad de la matriz A en paralelo
        executor.execute(() -> {
            // Recorre filas de la primera mitad de A por bloques
            for (int i1 = 0; i1 < size / 2; i1 += bsize) {
                // Recorre columnas de A por bloques
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    // Recorre bloques para la multiplicación
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        // Recorre filas del bloque de A
                        for (int i = i1; i < Math.min(i1 + bsize, size / 2); i++) {
                            // Recorre columnas del bloque de A
                            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {
                                // Recorre elementos del bloque de A
                                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {
                                    // Realiza la multiplicación y suma al resultado
                                    matrizResultado[i][j] += A[i][k] * B[k][j];
                                }
                            }
                        }
                    }
                }
            }
        });

        // Segundo bloque para procesar la segunda mitad de la matriz A en paralelo
        executor.execute(() -> {
            // Recorre filas de la segunda mitad de A por bloques
            for (int i1 = size / 2; i1 < size; i1 += bsize) {
                // Recorre columnas de A por bloques
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    // Recorre bloques para la multiplicación
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        // Recorre filas del bloque de A
                        for (int i = i1; i < Math.min(i1 + bsize, size); i++) {
                            // Recorre columnas del bloque de A
                            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {
                                // Recorre elementos del bloque de A
                                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {
                                    // Realiza la multiplicación y suma al resultado
                                    matrizResultado[i][j] += A[i][k] * B[k][j];
                                }
                            }
                        }
                    }
                }
            }
        });

        // Cierra el ExecutorService para detener la ejecución de nuevos hilos.
        executor.shutdown();

        // Espera a que todos los hilos terminen de ejecutarse.
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La ejecución fue interrumpida", e);
        }

        // Retorna la matriz resultante después de la multiplicación.
        return matrizResultado;
    }

}
