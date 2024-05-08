package Algoritmos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class III_5_Enhanced_Parallel_Block {

    public double[][] lll_ParallelDo(double[][] A, double[][] B, double[][] C, int size) {
        // Calcula el tamaño de bloque basado en la raíz cuadrada del tamaño total.
        int bsize = (int) Math.sqrt(size);
        // Crea un ExecutorService para manejar los hilos.
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Primer bloque para procesar la primera mitad de la matriz A en paralelo
        executor.execute(() -> {
            for (int i1 = 0; i1 < size / 2; i1 += bsize) {  // Recorre filas de la primera mitad de A
                for (int j1 = 0; j1 < size; j1 += bsize) {  // Recorre columnas de A
                    for (int k1 = 0; k1 < size; k1 += bsize) {  // Recorre bloques de multiplicación
                        for (int i = i1; i < Math.min(i1 + bsize, size); i++) {  // Recorre filas del bloque de A
                            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {  // Recorre columnas del bloque de A
                                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {  // Recorre elementos del bloque de A
                                    A[i][j] += B[i][k] * C[k][j];  // Realiza la multiplicación y suma al resultado
                                }
                            }
                        }
                    }
                }
            }
        });

        // Segundo bloque para procesar la segunda mitad de la matriz A en paralelo
        executor.execute(() -> {
            for (int i1 = size / 2; i1 < size; i1 += bsize) {  // Recorre filas de la segunda mitad de A
                for (int j1 = 0; j1 < size; j1 += bsize) {  // Recorre columnas de A
                    for (int k1 = 0; k1 < size; k1 += bsize) {  // Recorre bloques de multiplicación
                        for (int i = i1; i < Math.min(i1 + bsize, size); i++) {  // Recorre filas del bloque de A
                            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {  // Recorre columnas del bloque de A
                                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {  // Recorre elementos del bloque de A
                                    A[i][j] += B[i][k] * C[k][j];  // Realiza la multiplicación y suma al resultado
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
        while (!executor.isTerminated()) {
            // Espera a que todos los hilos terminen
        }

        // Retorna la matriz resultante A después de la multiplicación.
        return A;
    }

}
