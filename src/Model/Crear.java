package Model;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Crear {

    public static void crearMatrizMain() throws IOException{
        for(int i=1; i<=8;i++){
            int potencia = (int) Math.pow(2,i);
            for(int j=1; j<=2;j++){
                crearMatriz(i+"."+j , potencia);
            }
        }
    }

    public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException {

        FileWriter fw = new FileWriter(ruta, flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();
    }

    public static double[][] leerMatriz(String ruta){

        File archivo = new File(ruta);
        Scanner scanner;
        double[][] matriz = null;
        try {
            scanner = new Scanner(archivo);
            String primeraLinea = scanner.nextLine();
            String[] dimensiones = primeraLinea.split(" ");
            int filas = dimensiones.length;
            int columnas = dimensiones.length;
            matriz = new double[filas][columnas];
            scanner = new Scanner(archivo);
            for (int i = 0; i < filas; i++) {
                String linea = scanner.nextLine();
                String[] valores = linea.split(" ");
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = Double.parseDouble(valores[j]);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matriz;
    }

    private static void crearMatriz(String numeroMatriz, int n) throws IOException {
        double[][] matriz = new double[n][n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(1000000); // Valor aleatorio entre 0 y 999999
            }
        }
        guardarMatrices(matriz, numeroMatriz);
    }

    private static void guardarMatrices(double[][] matriz, String numeroMatriz) throws IOException {
        String matrizEscrita;

        StringBuilder sb = new StringBuilder();
        for (double[] doubles : matriz) {
            for (double aDouble : doubles) {
                sb.append(aDouble);
                sb.append(" ");
            }
            sb.append("\n");
        }

        matrizEscrita = sb.toString();
        guardarArchivo("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + numeroMatriz + ".txt", matrizEscrita, false);
    }
}

