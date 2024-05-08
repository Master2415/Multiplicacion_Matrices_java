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


    public void Metodos_Accion_run() throws IOException { // Opcional llamarlo en el run() de la clase Main
        x_NaivOnArray();
        x_NaivLoopUnrollingTwo();
        x_NaivLoopUnrollingFour();
        x_WinogradOriginal();
        x_WinogradScaled();
        x_StrassenNaiv();
        x_StrassenWinograd();
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
