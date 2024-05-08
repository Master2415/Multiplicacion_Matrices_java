package Algoritmos;

public class StrassenNaiv extends NaivStandar{

    StrassenNaivStep strassenNaivStep = new StrassenNaivStep();

    public double[][] StrassenNaiv_(double[][] matrizA, double[][] matrizB, double[][] matrizC, int N, int P, int M) {
        // Variables para cálculos relacionados con el tamaño de las matrices y el método de Strassen
        int MaxSize, k, m, NewSize, i, j;

        // Determina el tamaño máximo entre N y P
        MaxSize = max(N,P);

        // Si el tamaño máximo es menor que 16, se ajusta a 16 para garantizar que se pueda calcular 'k'
        if (MaxSize < 16) {
            MaxSize = 16;
        }

        // Calcula 'k' para el método de Strassen
        k = (int) Math.floor(Math.log(MaxSize)/Math.log(2)) - 4;
        m = (int) Math.floor(MaxSize * Math.pow(2,-k)) + 1;

        // Calcula el nuevo tamaño basado en 'm' y 'k'
        NewSize = m * (int) Math.pow(2,k);

        // Crea matrices con el nuevo tamaño para usar el algoritmo de Strassen
        double[][] NewA = new double[NewSize][];
        double[][] NewB = new double[NewSize][];
        double[][] AuxResult = new double[NewSize][];
        for (i = 0; i < NewSize; i++){
            NewA[i] = new double[NewSize];
            NewB[i] = new double[NewSize];
            AuxResult[i] = new double[NewSize];
        }

        // Inicializa las nuevas matrices con ceros
        for (i = 0; i < NewSize; i++) {
            for (j = 0; j < NewSize; j++) {
                NewA[i][j] = 0.0;
                NewB[i][j] = 0.0;
            }
        }

        // Copia los elementos de las matrices originales a las nuevas matrices
        for (i = 0; i < N; i++) {
            for (j = 0; j < P; j++) {
                NewA[i][j] = matrizA[i][j];
            }
        }
        for (i = 0; i < P; i++) {
            for (j = 0; j < M; j++) {
                NewB[i][j] = matrizB[i][j];
            }
        }

        // Llama al método StrassenNaivStep para realizar la multiplicación con el algoritmo de Strassen
        strassenNaivStep.StrassenNaivStep(NewA, NewB, AuxResult, NewSize, m);

        // Extrae el resultado de la matriz auxiliar y lo almacena en la matriz resultado
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                matrizC[i][j] = AuxResult[i][j];
            }
        }
        return matrizC;
    }

    public int max(int N, int P) {
        // Comprueba si N es menor que P
        if (N < P) {
            // Si es así, devuelve P como el máximo
            return P;
        } else {
            // Si no, devuelve N como el máximo
            return N;
        }
    }


}
