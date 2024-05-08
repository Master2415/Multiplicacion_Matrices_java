package Algoritmos;

public class StrassenWinograd {

    StrassenWinogradStep strassenWinogradStep = new StrassenWinogradStep();
    StrassenNaiv strassenNaiv = new StrassenNaiv(); // usado para llamar al metodo max

    public double[][] StrassenWinograd_(double[][] matrizA, double[][] matrizB, double[][] matrizC, int N, int P, int M) {

        int MaxSize, k, m, NewSize, i, j;
        MaxSize = strassenNaiv.max(N,P);
        MaxSize = strassenNaiv.max(MaxSize,M);
        if ( MaxSize < 16){
            MaxSize = 16; // otherwise it is not possible to compute k
        }
        k = (int) Math.floor(Math.log(MaxSize)/Math.log(2)) - 4;
        m = (int) Math.floor(MaxSize * Math.pow(2,-k)) + 1;
        NewSize = m * (int) Math.pow(2,k);


        // add zero rows and columns to use Strassens algorithm
        double[][] NewA = new double[NewSize][];
        double[][] NewB = new double[NewSize][];
        double[][] AuxResult = new double[NewSize][];
        for (i = 0; i < NewSize; i++){
            NewA[i] = new double[NewSize];
            NewB[i] = new double[NewSize];
            AuxResult[i] = new double[NewSize];
        }

        for( i = 0; i < NewSize; i++){
            for( j = 0; j < NewSize; j++){
                NewA[i][j] = 0.0;
                NewB[i][j] = 0.0;
            }
        }
        for( i = 0; i < N; i++){
            for( j = 0; j < P; j++){
                NewA[i][j] = matrizA[i][j];
            }
        }
        for( i = 0; i < P; i++){
            for( j = 0; j < M; j++){
                NewB[i][j] = matrizB[i][j];
            }
        }

        strassenWinogradStep.StrassenWinogradStep(NewA, NewB, AuxResult, NewSize, m);

        // extract the result
        for( i = 0; i < N; i++){
            for( j = 0; j < M; j++){
                matrizC[i][j] = AuxResult[i][j];
            }
        }
        return matrizC;
    }


}
