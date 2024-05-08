package Model;

import java.io.IOException;

public class Metodos_tiempo {

    private final Metodos_Accion metodosAccion = new Metodos_Accion();

    public void run() throws IOException {
        tiempoNaivOnArray();
    }

    public void tiempoNaivOnArray() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_NaivOnArray();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para naivOnArray: " + resultado);
    }
}
