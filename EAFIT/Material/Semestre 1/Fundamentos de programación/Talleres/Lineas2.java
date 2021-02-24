import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * Ejemplo de Gráficas 2D
 * @author htrefftz
 */
public class Lineas2 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        //puntos(g);
        //lineas(g);
        rectangulosOvalos(g);
        //textos(g);
        //rectangulos(g);
        //drawBook(g, 100, 200);
        //robot(g);
        juanJose(g);
    }
    
    public void juanJose(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(150, 150, 200, 200);
        g.setColor(Color.BLACK);
        g.fillOval(200, 50, 100, 100);
    }
    
    public void robot(Graphics g) {
        // Cabeza
        g.setColor(Color.RED);
        g.fillRect(110, 10, 30, 50);
        // Cuerpo
        g.fillRect(100, 55, 50, 100);
        // Brazos
        g.setColor(Color.BLACK);
        g.drawLine(65, 70, 100, 70);
        g.drawLine(150, 70, 185, 70);
        // Paticas
        g.drawLine(115, 160, 115, 210);
        g.drawLine(135, 160, 135, 210);
    }
    
    public void puntos(Graphics g) {
        this.setBackground(Color.YELLOW);
        g.setColor(Color.BLUE);
        g.drawLine(20, 20, 20, 20);
        g.drawLine(40, 40, 40, 40);
        g.drawLine(60, 60, 60, 60);
        g.drawLine(80, 80, 80, 80);
    }
    
    public void lineas(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(100, 100, 200, 300);    
        g.setColor(Color.RED);
        g.drawLine(200, 50, 50, 200);    
    }
    
    public void rectangulosOvalos(Graphics g) {
        g.setColor(Color.BLACK);
        // x, y, ancho, alto
        g.fillRect(10, 30, 100, 50);
        g.setColor(Color.RED);
        // x, y, ancho, alto
        g.fillOval(60, 40, 40, 70);        
    }
    
    public void textos(Graphics g) {
        g.setColor(Color.BLUE);
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 9; y++) {
                g.drawString("Java", x * 40, y * 25);
            }
        }
    }
    
    public void rectangulos(Graphics g) {
        for (int i = 0; i < 5; i++) {
            g.drawRect(11 + 20 * i, 98 - 20 * i, 20, 20);
        }
    }
    
    // Draws a BJP textbook at the given x/y position.    
    public void drawBook(Graphics g, int x, int y) {
        g.setColor(Color.CYAN);            // cyan background
        g.fillRect(x, y, 100, 100);
        
        g.setColor(Color.WHITE);           // white "bjp" text
        g.drawString("BJP", x + 50, y + 20);
        
        g.setColor(new Color(191, 118, 73));
        for (int i = 0; i < 10; i++) {     // orange "bricks"
            g.fillRect(x, y + 10 * i, 10 * (i + 1), 9);
        }
    }

    
    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Lineas");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new Lineas2());
        // Asignarle tamaño
        frame.setSize(500, 400);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }

}
