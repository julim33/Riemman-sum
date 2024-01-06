    import java.awt.event.KeyAdapter;
    import java.awt.event.KeyEvent;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import java.util.Scanner;
    import java.util.function.Function;

    import javax.imageio.ImageIO;
    import javax.swing.ImageIcon;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;

    public class Riemann {

        public static double riemannSum(double a, double b, int n, Function<Double, Double> f) {
            double dx = (b - a) / n;
            double sum = 0;
            for (int i = 0; i < n; i++) {
                double x = a + i * dx;
                double y = f.apply(x + dx / 2);
                double r = Math.pow(y, 2);
                sum += r * dx * Math.PI;
            }
            return sum;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Function<Double, Double> f = x -> Math.pow(x, 2) + 2;
            double a = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el límite inferior de integración: "));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el límite superior de integración: "));
            int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de intervalos: "));

            double volumen = riemannSum(a, b, n, f);
            JOptionPane.showMessageDialog(null, "El volumen aproximado del sólido de revolución valorado en la función x^2+2 es: " + volumen);

            // Crea el botón para abrir la imagen
            JButton button = new JButton("Abrir gráfica");
            button.addActionListener(e -> {
                try {
                    // Crea un objeto File con la ruta y nombre del archivo de la imagen
                    File file = new File("C:\\Users\\Julian\\Downloads\\grafica.jpeg");
                    
                    // Carga la imagen utilizando ImageIO.read()
                    BufferedImage image = ImageIO.read(file);

                    // Crea un ImageIcon con la imagen
                    ImageIcon icon = new ImageIcon(image);

                    // Crea un JLabel con el ImageIcon y lo muestra en un JFrame
    // Crea un JLabel con el ImageIcon y lo muestra en un JFrame
    JFrame frame = new JFrame();
    JLabel label = new JLabel(icon);
    JPanel panel = new JPanel();
    panel.add(label);
    frame.add(panel);
    frame.pack();

    // Centra la ventana en la pantalla
    frame.setLocationRelativeTo(null);

    frame.setVisible(true);


                    frame.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_H && e.isControlDown()) {
                                ps1 secretForm = new ps1();
                                secretForm.setVisible(true);
                            }
                        }
                    });
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            // Crea el panel con el botón y lo agrega a la ventana
    JPanel panel = new JPanel();
    panel.add(button);
    JFrame window = new JFrame();
    window.add(panel);
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
        }
    }
