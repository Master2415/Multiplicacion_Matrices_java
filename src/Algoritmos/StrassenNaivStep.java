package Algoritmos;

public class StrassenNaivStep {

    NaivStandar naivStandar = new NaivStandar();

    public void StrassenNaivStep(double[][] A, double[][] B, double[][] Result, int N, int m) {
        int i, j, NewSize;

        if ((N % 2 == 0) && (N > m)){
            NewSize = N / 2;

            // decompose A and B
            // create ResultPart, Aux1,...,Aux7 and Helper1, Helper2
            double[][] A11 = new double[NewSize][];
            double[][] A12 = new double[NewSize][];
            double[][] A21 = new double[NewSize][];
            double[][] A22 = new double[NewSize][];
            double[][] B11 = new double[NewSize][];
            double[][] B12 = new double[NewSize][];
            double[][] B21 = new double[NewSize][];
            double[][] B22 = new double[NewSize][];

            double[][] ResultPart11 = new double[NewSize][];
            double[][] ResultPart12 = new double[NewSize][];
            double[][] ResultPart21 = new double[NewSize][];
            double[][] ResultPart22 = new double[NewSize][];

            double[][] Helper1 = new double[NewSize][];
            double[][] Helper2 = new double[NewSize][];

            double[][] Aux1 = new double[NewSize][];
            double[][] Aux2 = new double[NewSize][];
            double[][] Aux3 = new double[NewSize][];
            double[][] Aux4 = new double[NewSize][];
            double[][] Aux5 = new double[NewSize][];
            double[][] Aux6 = new double[NewSize][];
            double[][] Aux7 = new double[NewSize][];

            for (i = 0; i < NewSize; i++){

                A11[i] = new double[NewSize];
                A12[i] = new double[NewSize];
                A21[i] = new double[NewSize];
                A22[i] = new double[NewSize];
                B11[i] = new double[NewSize];
                B12[i] = new double[NewSize];
                B21[i] = new double[NewSize];
                B22[i] = new double[NewSize];

                ResultPart11[i] = new double[NewSize];
                ResultPart12[i] = new double[NewSize];
                ResultPart21[i] = new double[NewSize];
                ResultPart22[i] = new double[NewSize];

                Helper1[i] = new double[NewSize];
                Helper2[i] = new double[NewSize];

                Aux1[i] = new double[NewSize];
                Aux2[i] = new double[NewSize];
                Aux3[i] = new double[NewSize];
                Aux4[i] = new double[NewSize];
                Aux5[i] = new double[NewSize];
                Aux6[i] = new double[NewSize];
                Aux7[i] = new double[NewSize];
            }

            //fill new matrices
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A11[i][j] = A[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A12[i][j] = A[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A21[i][j] = A[NewSize + i][j];
                }
            }

            for( i = 0; i < NewSize; i++) {
                for (j = 0; j < NewSize; j++) {
                    A22[i][j] = A[NewSize + i][NewSize + j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B11[i][j] = B[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B12[i][j] = B[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B21[i][j] = B[NewSize + i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B22[i][j] = B[NewSize + i][NewSize + j];
                }
            }

            // computing the seven aux. variables
            Plus(A11, A22, Helper1, NewSize, NewSize);
            Plus(B11, B22, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux1, NewSize, m);

            Plus(A21, A22, Helper1, NewSize, NewSize);
            StrassenNaivStep(Helper1, B11, Aux2, NewSize, m);

            Minus(B12, B22, Helper1, NewSize, NewSize);
            StrassenNaivStep(A11, Helper1, Aux3, NewSize, m);

            Minus(B21, B11, Helper1, NewSize, NewSize);
            StrassenNaivStep(A22, Helper1, Aux4, NewSize, m);

            Plus(A11, A12, Helper1, NewSize, NewSize);
            StrassenNaivStep(Helper1, B22, Aux5, NewSize, m);

            Minus(A21, A11, Helper1, NewSize, NewSize);
            Plus(B11, B12, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux6, NewSize, m);

            Minus(A12, A22, Helper1, NewSize, NewSize);
            Plus(B21, B22, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux7, NewSize, m);

            // computing the four parts of the result
            Plus(Aux1, Aux4, ResultPart11, NewSize, NewSize);
            Minus(ResultPart11, Aux5, ResultPart11, NewSize, NewSize);
            Plus(ResultPart11, Aux7, ResultPart11, NewSize, NewSize);

            Plus(Aux3, Aux5, ResultPart12, NewSize, NewSize);

            Plus(Aux2, Aux4, ResultPart21, NewSize, NewSize);

            Plus(Aux1, Aux3, ResultPart22, NewSize, NewSize);
            Minus(ResultPart22, Aux2, ResultPart22, NewSize, NewSize);
            Plus(ResultPart22, Aux6, ResultPart22, NewSize, NewSize);

            // store results in the "result matrix"
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[i][j] = ResultPart11[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[i][NewSize + j] = ResultPart12[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[NewSize + i][j] = ResultPart21[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[NewSize + i][NewSize + j] = ResultPart22[i][j];
                }
            }

            // free helper variables
            A11 = null;
            A12 = null;
            A21 = null;
            A22 = null;

            B11 = null;
            B12 = null;
            B21 = null;
            B22 = null;

            ResultPart11 = null;
            ResultPart12 = null;
            ResultPart21 = null;
            ResultPart22 = null;

            Helper1 = null;
            Helper2 = null;

            Aux1 = null;
            Aux2 = null;
            Aux3 = null;
            Aux4 = null;
            Aux5 = null;
            Aux6 = null;
            Aux7 = null;

        } else {
            // use naiv algorithm
            naivStandar.NaivStandard(A, B, Result, N, N, N);
        }
    }

    public void Minus(double[][] A, double[][] B, double[][] Result, int N, int M) {
        // Itera sobre las filas de las matrices A, B y Result
        for (int i = 0; i < N; i++) {
            // Itera sobre las columnas de las matrices A, B y Result
            for (int j = 0; j < M; j++) {
                // Realiza la resta entre los elementos correspondientes de A y B, y lo asigna a Result
                Result[i][j] = A[i][j] - B[i][j];
            }
        }
    }

    public void Plus(double[][] A, double[][] B, double[][] Result, int N, int M) {
        // Itera sobre las filas de las matrices A, B y Result
        for (int i = 0; i < N; i++) {
            // Itera sobre las columnas de las matrices A, B y Result
            for (int j = 0; j < M; j++) {
                // Realiza la suma entre los elementos correspondientes de A y B, y lo asigna a Result
                Result[i][j] = A[i][j] + B[i][j];
            }
        }
    }


}
