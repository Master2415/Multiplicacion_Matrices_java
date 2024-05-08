package Model;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Graficas {

    private final Metodos_Accion metodosAccion = new Metodos_Accion();

    public void run_Tiempo_Graficas() {
        try {
            generarGrafica();
        } catch (IOException e) {
            System.err.println("Error al generar la gráfica: " + e.getMessage());
        }
    }

    private void generarGrafica() throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        long tiempoNaivOnArray = obtenerTiempo(() -> {
            try {
                metodosAccion.x_NaivOnArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoNaivOnArray,  "NaivOnArray", "");

        long tiempoNaivLoopUnrollingTwo = obtenerTiempo(() -> {
            try {
                metodosAccion.x_NaivLoopUnrollingTwo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoNaivLoopUnrollingTwo, "NaivLoopUnrollingTwo", "");

        long tiempoNaivLoopUnrollingFour = obtenerTiempo(() -> {
            try {
                metodosAccion.x_NaivLoopUnrollingFour();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoNaivLoopUnrollingFour, "NaivLoopUnrollingFour", "");

        long tiempoWinogradOriginal = obtenerTiempo(() -> {
            try {
                metodosAccion.x_WinogradOriginal();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoWinogradOriginal, "WinogradOriginal", "");

        long tiempoWinogradScaled = obtenerTiempo(() -> {
            try {
                metodosAccion.x_WinogradScaled();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoWinogradScaled, "WinogradScaled", "");

        long tiempoStrassenNaiv = obtenerTiempo(() -> {
            try {
                metodosAccion.x_StrassenNaiv();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoStrassenNaiv, "StrassenNaiv", "");

        long tiempoStrassenWinograd = obtenerTiempo(() -> {
            try {
                metodosAccion.x_StrassenWinograd();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoStrassenWinograd,  "StrassenWinograd", "");

        long tiempoIII3SequentialBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_lll_3SequentialBlock();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoIII3SequentialBlock,  "III.3 Sequential block", "");

        long tiempoIII4ParallelBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_III_4_Parallel_Block();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoIII4ParallelBlock, "III.4 Parallel Block", "");

        long tiempoIII5EnhancedParallelBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_iii5EnhancedParallelBlock();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoIII5EnhancedParallelBlock, "III.5 Enhanced Parallel Block", "");

        long tiempoIV3SequentialBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_lV_3SequentialBlock();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoIV3SequentialBlock,  "IV.3 Sequential block", "");

        long tiempoIV4ParallelBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_lV_4ParallelBlock();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoIV4ParallelBlock, "IV.4 Parallel Block", "");

        long tiempoIV5EnhancedParallelBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_llV_5EnhancedParallelBlock();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoIV5EnhancedParallelBlock,"IV.5 Enhanced Parallel Block", "");

        long tiempoV3SequentialBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_v_3SequentialBlock();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoV3SequentialBlock, "V.3 Sequential block", "");

        long tiempoV4ParallelBlock = obtenerTiempo(() -> {
            try {
                metodosAccion.x_v_4ParallelBlock();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        dataset.addValue(tiempoV4ParallelBlock, "V.4 Parallel Block", "");

        System.out.println("Tiempo NaivOnArray: " + tiempoNaivOnArray + " ns");
        System.out.println("Tiempo NaivLoopUnrollingTwo: " + tiempoNaivLoopUnrollingTwo + " ns");
        System.out.println("Tiempo NaivLoopUnrollingFour: " + tiempoNaivLoopUnrollingFour + " ns");
        System.out.println("Tiempo WinogradOriginal: " + tiempoWinogradOriginal + " ns");
        System.out.println("Tiempo WinogradScaled: " + tiempoWinogradScaled + " ns");
        System.out.println("Tiempo StrassenNaiv: " + tiempoStrassenNaiv + " ns");
        System.out.println("Tiempo StrassenWinograd: " + tiempoStrassenWinograd + " ns");
        System.out.println("Tiempo III.3 Sequential block: " + tiempoIII3SequentialBlock + " ns");
        System.out.println("Tiempo III.4 Parallel Block: " + tiempoIII4ParallelBlock + " ns");
        System.out.println("Tiempo III.5 Enhanced Parallel Block: " + tiempoIII5EnhancedParallelBlock + " ns");
        System.out.println("Tiempo IV.3 Sequential block: " + tiempoIV3SequentialBlock + " ns");
        System.out.println("Tiempo IV.4 Parallel Block: " + tiempoIV4ParallelBlock + " ns");
        System.out.println("Tiempo IV.5 Enhanced Parallel Block: " + tiempoIV5EnhancedParallelBlock + " ns");
        System.out.println("Tiempo V.3 Sequential block: " + tiempoV3SequentialBlock + " ns");
        System.out.println("Tiempo V.4 Parallel Block: " + tiempoV4ParallelBlock + " ns");

        JFreeChart chart = ChartFactory.createBarChart(
                "Tiempos de ejecución de métodos", // Título del gráfico
                "Métodos", // Etiqueta del eje X
                "Tiempo (nanosegundos)", // Etiqueta del eje Y
                dataset, // Dataset con los datos
                PlotOrientation.VERTICAL, // Orientación del gráfico
                true, // Incluir leyenda
                true, // Incluir tooltips
                false // Incluir URLs
        );

        JFrame frame = new JFrame("Tiempos de ejecución");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private long obtenerTiempo(Runnable metodo) throws IOException {
        long inicio = System.nanoTime();
        metodo.run();
        long fin = System.nanoTime();
        return fin - inicio;
    }

}
