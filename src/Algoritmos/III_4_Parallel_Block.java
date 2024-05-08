package Algoritmos;

public class III_4_Parallel_Block {

    public double[][] lll_4ParallelBlock(double[][] matrizA, double[][] matrizB, int size) {
        // Calcula el tamaño de bloque basado en la raíz cuadrada del tamaño total.
        int bsize = (int) Math.sqrt(size);
        // Crea una matriz para almacenar el resultado de la multiplicación.
        double[][] matrizResultado = new double[size][size];

        // Crea un arreglo de threads para manejar el procesamiento paralelo.
        Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];

        // Inicia los hilos para procesamiento paralelo.
        for (int t = 0; t < threads.length; t++) {
            final int threadIndex = t;
            threads[t] = new Thread(() -> {
                // Cada hilo se encarga de una parte de la matriz.
                for (int i1 = threadIndex * bsize; i1 < size; i1 += threads.length * bsize) {
                    for (int j1 = 0; j1 < size; j1 += bsize) {
                        for (int k1 = 0; k1 < size; k1 += bsize) {
                            // Multiplica los bloques correspondientes de las matrices.
                            for (int i = i1; i < Math.min(i1 + bsize, size); i++) {
                                for (int j = j1; j < Math.min(j1 + bsize, size); j++) {
                                    for (int k = k1; k < Math.min(k1 + bsize, size); k++) {
                                        matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                                    }
                                }
                            }
                        }
                    }
                }
            });
            threads[t].start();  // Inicia el hilo.
        }

        // Espera a que todos los hilos terminen su trabajo.
        for (Thread thread : threads) {
            try {
                thread.join();  // Espera a que el hilo termine.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error al esperar a los hilos: " + e.getMessage());
            }
        }
        return matrizResultado;
    }

}
