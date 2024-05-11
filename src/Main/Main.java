package Main;
import Model.*;

import java.io.IOException;


public class Main {

    private static final Metodos_Accion m = new Metodos_Accion();
    private static final Metodos_tiempo mt = new Metodos_tiempo();
    private static final Graficas g = new Graficas();
    private static final Leer_Tiempos l = new Leer_Tiempos();

    public static void main(String[] args) throws IOException {
        run();
    }

    /*
     * Importante.
     * Antes de ejecutar el codigo primero verificar que existan las matrices, para asi llamar las instancias
     */
    private static void run() throws IOException {
        //Crear.crearMatrizMain(); // Llamado para crear las matrices
        //m.Metodos_Accion_run(); // Por si queremos guardar el resultado de las matrices, como prueba
        //mt.run_Tiempo(); // llamado para visualizar los tiempos en consola
        //mt.run_Tiempo_txt(); // guarda el tiempo de los metodos en un archivo txt
        //g.run_Tiempo_Graficas(); // Genera las graficas de las multplicaciones
        //l.ver_Tiempos_leguages(); // Genera las graficas de un txt, donde se almacenan los tiempos de los lenguajes (java, python)
    }

}
