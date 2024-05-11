package Model;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leer_Tiempos {

    public void ver_Tiempos_leguages() {
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            BufferedReader reader = new BufferedReader(new FileReader("C:/ALL/Codigos/WS_Python/WS/Metodos_de_multiplicacion/Tiempo_Registrado/tiempos.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {  // Verificar el formato de la línea
                    String[] metodoParts = parts[1].split("_");
                    if (metodoParts.length >= 2) {  // Verificar si hay suficientes partes
                        String nombreMetodo = metodoParts[0] + "_" + metodoParts[1];  // Unir las partes del método
                        long tiempo = Long.parseLong(parts[0]);

                        dataset.addValue(tiempo, nombreMetodo, "");
                    } else {
                        System.out.println("Error: Formato incorrecto en línea -> " + line);
                    }
                } else {
                    System.out.println("Error: Formato incorrecto en línea -> " + line);
                }
            }
            reader.close();

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

            ChartPanel chartPanel = new ChartPanel(chart);
            JFrame frame = new JFrame("Gráfica de Tiempos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(chartPanel);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
