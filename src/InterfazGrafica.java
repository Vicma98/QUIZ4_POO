import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class InterfazGrafica extends JFrame implements ActionListener {
    static JLabel lblAnimales, lblHumanos, lblHora;
    static JTextField txtHumanos;
    static JButton btnOK;
    static JTextField txtAnimales;

    static GraficaBarras graficos;
    static List<Integer> registrosAnimales = new ArrayList<>();
    static List<Integer> registrosHumanos = new ArrayList<>();

    public InterfazGrafica() {
        lblHora = new JLabel();
        lblHora.setBounds(200, 20, 150, 30);

        lblAnimales = new JLabel("Animales");
        lblAnimales.setBounds(20, 40, 120, 40);
        txtAnimales = new JTextField();
        txtAnimales.setBounds(20, 80, 140, 30);

        lblHumanos = new JLabel("Humanos");
        lblHumanos.setBounds(20, 120, 120, 40);
        txtHumanos = new JTextField();
        txtHumanos.setBounds(20, 160, 140, 30);

        btnOK = new JButton("Registrar");
        btnOK.setBounds(200, 80, 100, 80);
        btnOK.addActionListener(this);
        btnOK.setForeground(Color.BLACK);

        graficos = new GraficaBarras();
        graficos.setBounds(120, 200, 400, 300); // Establece el tamaño y la posición del gráfico

        Thread hiloActualizacion = new Thread(graficos);
        hiloActualizacion.start();

        RelojHilo_3 hiloReloj = new RelojHilo_3();
        hiloReloj.start();

        add(lblHumanos);
        add(lblAnimales);
        add(lblHora);
        add(txtHumanos);
        add(txtAnimales);
        add(btnOK);
        add(graficos);

        setLayout(null);
        setTitle("Quiz_4");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnOK)){
            int carro = Integer.parseInt(txtHumanos.getText());
            int moto = Integer.parseInt(txtAnimales.getText());

            registrosAnimales.add(moto);
            registrosHumanos.add(carro);
            txtHumanos.setText("");
            txtAnimales.setText("");

            graficos.setHumanosRegistrados(registrosHumanos);
            graficos.setAnimalesRegistradas(registrosAnimales);
        }


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazGrafica();
        });
    }

}
