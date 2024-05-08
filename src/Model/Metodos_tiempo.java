package Model;

import java.io.IOException;

public class Metodos_tiempo {

    private final Metodos_Accion metodosAccion = new Metodos_Accion();

    public void run_Tiempo() throws IOException {
        //tiempoNaivOnArray();
        //tiempoNaivLoopUnrollingTwo();
        //tiempoNaivLoopUnrollingFour();
        //tiempoNWinogradOriginal();
        //tiempoWinogradScaled();
        //tiempoStrassenNaiv();
        //tiempoStrassenWinograd();
    }

    public void tiempoNaivOnArray() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_NaivOnArray();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para naivOnArray: " + resultado);
    }

    public void tiempoNaivLoopUnrollingTwo() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_NaivLoopUnrollingTwo();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para NaivLoopUnrollingTwo: " + resultado);
    }

    public void tiempoNaivLoopUnrollingFour() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_NaivLoopUnrollingFour();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para NaivLoopUnrollingFour: " + resultado);
    }

    public void tiempoNWinogradOriginal() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_WinogradOriginal();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para WinogradOriginal: " + resultado);
    }

    public void tiempoWinogradScaled() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_WinogradScaled();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para WinogradScaled: " + resultado);
    }

    public void tiempoStrassenNaiv() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_StrassenNaiv();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para StrassenNaiv: " + resultado);
    }

    public void tiempoStrassenWinograd() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_StrassenWinograd();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para StrassenWinograd: " + resultado);
    }


}
