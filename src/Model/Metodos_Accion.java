package Model;

import Algoritmos.*;

import java.io.IOException;

public class Metodos_Accion {

    private final NaivOnArray naivOnArray = new NaivOnArray();
    private final NaivLoopUnrollingTwo naivLoopUnrollingTwo = new NaivLoopUnrollingTwo();
    private final NaivLoopUnrollingFour naivLoopUnrollingFour = new NaivLoopUnrollingFour();
    private final WinogradOriginal winogradOriginal = new WinogradOriginal();
    private final WinogradScaled winogradScaled = new WinogradScaled();
    private final StrassenNaiv naivStrassenNaiv = new StrassenNaiv();
    private final StrassenWinograd naivStrassenWinograd = new StrassenWinograd();
    private final III_3_Sequential_block iii3SequentialBlock  = new III_3_Sequential_block();
    private final III_4_Parallel_Block III_4_Parallel_Block = new III_4_Parallel_Block();
    private final III_5_Enhanced_Parallel_Block iii5EnhancedParallelBlock  = new III_5_Enhanced_Parallel_Block();
    private final lV_3SequentialBlock lv3SequentialBlock = new lV_3SequentialBlock();
    private final lV_4ParallelBlock lv4ParallelBlock = new lV_4ParallelBlock();
    private final IV_5_Enhanced_Parallel_Block iv5EnhancedParallelBlock  = new IV_5_Enhanced_Parallel_Block();
    private final V_3_Sequential_block v3SequentialBlock = new V_3_Sequential_block();
    private final V_4_Parallel_Block v4ParallelBlock = new V_4_Parallel_Block();



    public void Metodos_Accion_run() throws IOException { // Opcional llamarlo en el run() de la clase Main
        x_NaivOnArray();
        x_NaivLoopUnrollingTwo();
        x_NaivLoopUnrollingFour();
        x_WinogradOriginal();
        x_WinogradScaled();
        x_StrassenNaiv();
        x_StrassenWinograd();
        x_lll_3SequentialBlock();
        x_III_4_Parallel_Block();
        x_iii5EnhancedParallelBlock();
        x_lV_3SequentialBlock();
        x_lV_4ParallelBlock();
        x_llV_5EnhancedParallelBlock();
        x_v_3SequentialBlock();
        x_v_4ParallelBlock();
    }

    public void x_NaivOnArray() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = naivOnArray.NaivOnArray_(matriz1, matriz2, matrizC, potencia, potencia, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_NaivLoopUnrollingTwo() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = naivLoopUnrollingTwo.NaivLoopUnrolling_Two(matriz1, matriz2, matrizC, potencia, potencia, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_NaivLoopUnrollingFour() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = naivLoopUnrollingFour.NaivLoopUnrollingFour_(matriz1, matriz2, matrizC, potencia, potencia, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_WinogradOriginal() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = winogradOriginal.WinogradOriginal_(matriz1, matriz2, matrizC, potencia, potencia, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_WinogradScaled() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = winogradScaled.WinogradScaled_(matriz1, matriz2, matrizC, potencia, potencia, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_StrassenNaiv() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = naivStrassenNaiv.StrassenNaiv_(matriz1, matriz2, matrizC, potencia, potencia, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_StrassenWinograd() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = naivStrassenWinograd.StrassenWinograd_(matriz1, matriz2, matrizC, potencia, potencia, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_lll_3SequentialBlock() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = iii3SequentialBlock.lll_3SequentialBlock(matriz1, matriz2, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_III_4_Parallel_Block() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = III_4_Parallel_Block.lll_4ParallelBlock(matriz1, matriz2, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_iii5EnhancedParallelBlock() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = iii5EnhancedParallelBlock.lll_ParallelDo(matriz1, matriz2, matrizC, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_lV_3SequentialBlock() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = lv3SequentialBlock.lV_3SequentialBlock_(matriz1, matriz2, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_lV_4ParallelBlock() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = lv4ParallelBlock.lV_4ParallelBlock_(matriz1, matriz2, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_llV_5EnhancedParallelBlock() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = iv5EnhancedParallelBlock.lV_5EnhancedParallelBlock(matriz1, matriz2, matrizC, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_v_3SequentialBlock() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = v3SequentialBlock.v_3SequentialBlock(matriz1, matriz2, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }

    public void x_v_4ParallelBlock() throws IOException {
        for (int i = 1; i <= 8; i++) {

            // Leer las dos matrices desde archivos
            double[][] matriz1 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".1.txt");
            double[][] matriz2 = Model.Crear.leerMatriz("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + i + ".2.txt");
            int potencia = (int) Math.pow(2, i);
            double[][] matrizC = new double[potencia][potencia];

            double[][] resultadoMultiplicacion = v4ParallelBlock.v_4ParallelBlock(matriz1, matriz2, potencia);

            // Guardar el resultado de la multiplicación en un archivo
            String numeroResultado = i + ".resultado";
            //guardarResultado(resultadoMultiplicacion, numeroResultado); //Guardamos el resultado de la multiplicacion en el txt

        }
    }




    private void guardarResultado(double[][] resultado, String numeroResultado) throws IOException {
        String ruta = "C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/" + numeroResultado + ".txt";  // Asegúrate de incluir la carpeta Resultados
        StringBuilder contenido = new StringBuilder();
        for (double[] fila : resultado) {
            for (double elemento : fila) {
                contenido.append(elemento).append(" ");
            }
            contenido.append("\n");
        }

        Crear.guardarArchivo(ruta, contenido.toString(), false);  // Llamada al método guardarArchivo con flagAnexarContenido en false
    }

}
