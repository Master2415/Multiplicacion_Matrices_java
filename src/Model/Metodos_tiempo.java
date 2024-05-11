package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Metodos_tiempo {

    private final Metodos_Accion metodosAccion = new Metodos_Accion();

    // Metodo que muestra los tiempos registrados, creado con el fin de ejecutar y ver los tiempos en la consola, listo para ser llamado al main
    public void run_Tiempo() throws IOException {
        tiempoNaivOnArray();
        tiempoNaivLoopUnrollingTwo();
        tiempoNaivLoopUnrollingFour();
        tiempoNWinogradOriginal();
        tiempoWinogradScaled();
        tiempoStrassenNaiv();
        tiempoStrassenWinograd();
        tiempolll_3SequentialBlock();
        tiempolll_4ParallelBlock();
        tiempoIII_5_Enhanced_Parallel_Block();
        tiempolV_3SequentialBlock();
        tiempolV_4ParallelBlock();
        tiempolV_5EnhancedParallelBlock();
        tiempov_3SequentialBlock();
        tiempov_4ParallelBlock();
    }

    // Guarda los tiempos registrados en un txt
    public void run_Tiempo_txt() throws IOException {
        guardarTiempo("NaivOnArray_Java");
        guardarTiempo("NaivLoopUnrollingTwo_Java");
        guardarTiempo("NaivLoopUnrollingFour_Java");
        guardarTiempo("WinogradOriginal_Java");
        guardarTiempo("WinogradScaled_Java");
        guardarTiempo("StrassenNaiv_Java");
        guardarTiempo("StrassenWinograd_Java");
        guardarTiempo("lll_3SequentialBlock_Java");
        guardarTiempo("lll_4ParallelBlock_Java");
        guardarTiempo("III_5_Enhanced_Parallel_Block_Java");
        guardarTiempo("lV_3SequentialBlock_Java");
        guardarTiempo("lV_4ParallelBlock_Java");
        guardarTiempo("lV_5EnhancedParallelBlock_Java");
        guardarTiempo("V_3SequentialBlock_Java");
        guardarTiempo("V_4ParallelBlock_Java");
    }


    private void guardarTiempo(String nombreMetodo) throws IOException {
        long inicioTiempo = System.nanoTime();
        switch (nombreMetodo) {
            case "NaivOnArray_Java":
                metodosAccion.x_NaivOnArray();
                break;
            case "NaivLoopUnrollingTwo_Java":
                metodosAccion.x_NaivLoopUnrollingTwo();
                break;
            case "NaivLoopUnrollingFour_Java":
                metodosAccion.x_NaivLoopUnrollingFour();
                break;
            case "WinogradOriginal_Java":
                metodosAccion.x_WinogradOriginal();
                break;
            case "WinogradScaled_Java":
                metodosAccion.x_WinogradScaled();
                break;
            case "StrassenNaiv_Java":
                metodosAccion.x_StrassenNaiv();
                break;
            case "StrassenWinograd_Java":
                metodosAccion.x_StrassenWinograd();
                break;
            case "lll_3SequentialBlock_Java":
                metodosAccion.x_lll_3SequentialBlock();
                break;
            case "lll_4ParallelBlock_Java":
                metodosAccion.x_III_4_Parallel_Block();
                break;
            case "III_5_Enhanced_Parallel_Block_Java":
                metodosAccion.x_iii5EnhancedParallelBlock();
                break;
            case "lV_3SequentialBlock_Java":
                metodosAccion.x_lV_3SequentialBlock();
                break;
            case "lV_4ParallelBlock_Java":
                metodosAccion.x_lV_4ParallelBlock();
                break;
            case "lV_5EnhancedParallelBlock_Java":
                metodosAccion.x_llV_5EnhancedParallelBlock();
                break;
            case "V_3SequentialBlock_Java":
                metodosAccion.x_v_3SequentialBlock();
                break;
            case "V_4ParallelBlock_Java":
                metodosAccion.x_v_4ParallelBlock();
                break;
            default:
                System.out.println("Nombre de método no válido");
                return; // Salir del método si el nombre de método no es válido
        }
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        // Guardar el resultado en el archivo
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/ALL/Codigos/WS_Python/WS/Metodos_de_multiplicacion/Tiempo_Registrado/tiempos.txt", true));
        // BufferedWriter writer = new BufferedWriter(new FileWriter("C:/ALL/Codigos/WS_Java/Analisis_Algoritmos/Multiplicacion_Matrices/src/Tiempo_Registrado/tiempos.txt", true));
        writer.write(resultado + ": " + nombreMetodo + "\n");
        writer.close();
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

    public void tiempolll_3SequentialBlock() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_lll_3SequentialBlock();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para III.3 Sequential block: " + resultado);
    }

    public void tiempolll_4ParallelBlock() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_III_4_Parallel_Block();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para III.4 Parallel Block: " + resultado);
    }

    public void tiempoIII_5_Enhanced_Parallel_Block() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_iii5EnhancedParallelBlock();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para III.5 Enhanced Parallel Block: " + resultado);
    }

    public void tiempolV_3SequentialBlock() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_lV_3SequentialBlock();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para IV.3 Sequential block: " + resultado);
    }

    public void tiempolV_4ParallelBlock() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_lV_4ParallelBlock();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para IV.4 Parallel Block: " + resultado);
    }

    public void tiempolV_5EnhancedParallelBlock() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_llV_5EnhancedParallelBlock();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para IV. 5 Enhanced Parallel Block: " + resultado);
    }

    public void tiempov_3SequentialBlock() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_v_3SequentialBlock();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para V.3 Sequential block: " + resultado);
    }

    public void tiempov_4ParallelBlock() throws IOException {
        long inicioTiempo = System.nanoTime();
        metodosAccion.x_v_4ParallelBlock();
        long finTiempo = System.nanoTime();
        long resultado = finTiempo - inicioTiempo;

        System.out.println("Duracion en nanosegundos para V.4 Parallel Block: " + resultado);
    }

}
