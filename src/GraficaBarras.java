import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraficaBarras extends JPanel implements Runnable {
    private List<Integer> humanosRegistrados = new ArrayList<>();
    private List<Integer> animalesRegistradas = new ArrayList<>();
    private static final int MAX_ELEMENTOS_GRAFICO = 100;

    @Override
    public void run() {
        while (true) {
            // Actualizar los gráficos con nuevos valores en el hilo
            setHumanosRegistrados(InterfazGrafica.registrosHumanos);
            setAnimalesRegistradas(InterfazGrafica.registrosAnimales);
            repaint();

            // Tiempo para mi hilo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setHumanosRegistrados(List<Integer> humanosRegistrados) {
        this.humanosRegistrados = humanosRegistrados;
    }

    public void setAnimalesRegistradas(List<Integer> animalesRegistradas) {
        this.animalesRegistradas = animalesRegistradas;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja los ejes X e Y
        g.setColor(Color.BLACK);
        g.drawLine(60, 150, 160, 150); // Eje X
        g.drawLine(60, 150, 60, 50);  // Eje Y

        // Asegura que solo se muestren los últimos 100 elementos de las listas
        int inicioHumanos = Math.max(humanosRegistrados.size() - MAX_ELEMENTOS_GRAFICO, 0);
        int inicioAnimales = Math.max(animalesRegistradas.size() - MAX_ELEMENTOS_GRAFICO, 0);
        List<Integer> humanosUltimos = humanosRegistrados.subList(inicioHumanos, humanosRegistrados.size());
        List<Integer> animalesUltimas = animalesRegistradas.subList(inicioAnimales, animalesRegistradas.size());

        // Encuentra la máxima cantidad de autos y motos
        int maxHumanos = humanosUltimos.isEmpty() ? 0 : humanosUltimos.stream().mapToInt(Integer::intValue).max().getAsInt();
        int maxAnimales = animalesUltimas.isEmpty() ? 0 : animalesUltimas.stream().mapToInt(Integer::intValue).max().getAsInt();

        // altura máxima deseada (100 en este caso)
        int escalaHumanos = maxHumanos == 0 ? 1 : Math.min(100, 100 * 100 / maxHumanos);
        int escalaAnimales = maxAnimales == 0 ? 1 : Math.min(100, 100 * 100 / maxAnimales);


        g.setColor(Color.blue);
        for (int altura : humanosRegistrados) {
            int alturaGraficoHumanos = altura * escalaHumanos / 100;
            g.fillRect(70, 150 - alturaGraficoHumanos, 30, alturaGraficoHumanos);
        }

        g.setColor(Color.green);
        for (int altura : animalesRegistradas) {
            int altoGraficoAnimales = altura * escalaAnimales / 100;
            g.fillRect(130, 150 - altoGraficoAnimales, 30, altoGraficoAnimales);
        }

        //etiquetas
        g.setColor(Color.BLACK);
        g.drawString("Humanos", 70, 170);
        g.drawString("Animales", 130, 170);
        g.drawString("Cantidad", 90, 10);
    }
}
