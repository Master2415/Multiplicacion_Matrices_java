package Main;
import Model.Crear;
import Model.Graficas;
import Model.Metodos_Accion;
import Model.Metodos_tiempo;

import java.io.IOException;


public class Main {

    private static final Metodos_Accion m = new Metodos_Accion();
    private static final Metodos_tiempo mt = new Metodos_tiempo();
    private static final Graficas g = new Graficas();

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        // Crear.crearMatrizMain(); // No es neceario, ya que las matrices estan en persistencia, usarlo para crearlas
        // m.Metodos_Accion_run(); // Por si queremos guardar el resultado de las matrices
        // mt.run_Tiempo(); // solo ejecuta los metodos pero sin graficas
        g.run_Tiempo_Graficas();
    }

}
