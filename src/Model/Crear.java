package Model;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Crear {

    // Este método es público y estático, no devuelve ningún valor y puede lanzar una excepción IOException.
    public static void crearMatrizMain() throws IOException{
        // Este bucle se ejecutará 8 veces, calculando potencias de 2 en cada iteración.
        for(int i=1; i<=8;i++){
            // Se calcula la potencia de 2 elevado a la variable i y se almacena en la variable potencia.
            int potencia = (int) Math.pow(2,i);

            // Este bucle se ejecutará dos veces en cada iteración del bucle externo.
            for(int j=1; j<=2;j++){
                // Se llama al método crearMatriz() pasando argumentos específicos.
                crearMatriz(i+"."+j , potencia);
            }
        }
    }

    // Este método también es público y estático, recibe tres parámetros y puede lanzar una excepción IOException.
    public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException {
        // Se crea un objeto FileWriter para escribir en el archivo especificado por ruta.
        FileWriter fw = new FileWriter(ruta, flagAnexarContenido);
        // Se crea un BufferedWriter que envuelve al FileWriter para mejorar la eficiencia en la escritura.
        BufferedWriter bfw = new BufferedWriter(fw);
        // Se escribe el contenido en el archivo a través del BufferedWriter.
        bfw.write(contenido);
        // Se cierran tanto el BufferedWriter como el FileWriter para liberar recursos.
        bfw.close();
        fw.close();
    }


    // Este método es público y estático, recibe la ruta de un archivo como parámetro y devuelve una matriz bidimensional de tipo double.
    public static double[][] leerMatriz(String ruta){

        // Se crea un objeto File que representa el archivo especificado por la ruta.
        File archivo = new File(ruta);
        Scanner scanner;
        // Se inicializa la matriz como nula.
        double[][] matriz = null;
        try {
            // Se crea un objeto Scanner para leer el archivo.
            scanner = new Scanner(archivo);
            // Se lee la primera línea del archivo.
            String primeraLinea = scanner.nextLine();
            // Se separa la primera línea en dimensiones utilizando el espacio como delimitador.
            String[] dimensiones = primeraLinea.split(" ");
            // Se obtienen el número de filas y columnas de la matriz.
            int filas = dimensiones.length;
            int columnas = dimensiones.length;
            // Se crea la matriz con las dimensiones obtenidas.
            matriz = new double[filas][columnas];
            // Se reinicia el objeto Scanner para volver a leer el archivo desde el principio.
            scanner = new Scanner(archivo);
            // Se itera sobre cada fila de la matriz.
            for (int i = 0; i < filas; i++) {
                // Se lee una línea del archivo.
                String linea = scanner.nextLine();
                // Se separa la línea en valores utilizando el espacio como delimitador.
                String[] valores = linea.split(" ");
                // Se itera sobre cada valor para asignarlo a la matriz.
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = Double.parseDouble(valores[j]);
                }
            }
            // Se cierra el objeto Scanner para liberar recursos.
            scanner.close();

        } catch (FileNotFoundException e) {
            // En caso de que el archivo no sea encontrado, se imprime la traza del error.
            e.printStackTrace();
        }

        // Se devuelve la matriz leída desde el archivo.
        return matriz;
    }


    // Este método es privado y estático, no devuelve ningún valor y puede lanzar una excepción IOException.
    private static void crearMatriz(String numeroMatriz, int n) throws IOException {
        // Se crea una matriz de tamaño nxn.
        double[][] matriz = new double[n][n];

        // Se crea un objeto Random para generar valores aleatorios.
        Random random = new Random();

        // Se recorre la matriz para asignar valores aleatorios entre 0 y 999999.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(1000000); // Valor aleatorio entre 0 y 999999
            }
        }

        // Se llama al método guardarMatrices() para guardar la matriz generada.
        guardarMatrices(matriz, numeroMatriz);
    }

    // Este método es privado y estático, no devuelve ningún valor y puede lanzar una excepción IOException.
    private static void guardarMatrices(double[][] matriz, String numeroMatriz) throws IOException {
        // Variable para almacenar la matriz como una cadena.
        String matrizEscrita;

        // Se utiliza un StringBuilder para construir la cadena de la matriz.
        StringBuilder sb = new StringBuilder();
        for (double[] doubles : matriz) {
            for (double aDouble : doubles) {
                sb.append(aDouble);
                sb.append(" ");
            }
            sb.append("\n");
        }

        // Se convierte el StringBuilder a una cadena.
        matrizEscrita = sb.toString();

        // Se llama al método guardarArchivo() para escribir la matriz en un archivo.
        guardarArchivo("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Persistencia/matriz " + numeroMatriz + ".txt", matrizEscrita, false);
    }

}

