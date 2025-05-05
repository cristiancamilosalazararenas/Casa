// Este es el paquete donde se ubica la clase Casa.
package autonoma.casa.gui;

// Importamos las clases necesarias
import autonoma.casa.elements.Meteorito;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Clase que representa una ventana con una casa y meteoritos cayendo.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.04
 */
public class Casa extends javax.swing.JFrame {

    /**
     * Lista que contiene los meteoritos que caerán.
     */
    private ArrayList<Meteorito> meteoritos;

    /**
     * Constructor que inicializa la ventana y crea los meteoritos.
     */
    public Casa() {
        initComponents();
        this.setSize(700, 700); // Tamaño de la ventana
        this.setLocationRelativeTo(null); // Centrar ventana

        // Creamos 7 meteoritos con diferentes posiciones y velocidades
        meteoritos = new ArrayList<>();
        meteoritos.add(new Meteorito(50, 0, 30, 30, 3, Color.LIGHT_GRAY));
        meteoritos.add(new Meteorito(100, 0, 30, 30, 4, Color.GRAY));
        meteoritos.add(new Meteorito(200, 100, 30, 30, 3, Color.DARK_GRAY));
        meteoritos.add(new Meteorito(300, 0, 30, 30, 4, Color.LIGHT_GRAY));
        meteoritos.add(new Meteorito(400, 200, 30, 30, 3, Color.GRAY));
        meteoritos.add(new Meteorito(500, 100, 30, 30, 4, Color.DARK_GRAY));
        meteoritos.add(new Meteorito(650, 0, 30, 30, 5, Color.LIGHT_GRAY));

        // Hilo para animar los meteoritos
        Thread hilo = new Thread(() -> {
            while (true) {
                // Mueve y verifica cada meteorito
                for (Meteorito m : meteoritos) {
                    m.mover();
                    m.reiniciarSiLlegaAbajo(700); // Límite inferior de la ventana
                }
                repaint(); // Redibuja la escena
                try {
                    Thread.sleep(30); // ~33 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        hilo.start(); // Inicia la animación
    }

    /**
     * Método que dibuja todos los elementos gráficos.
     *
     * @param g El objeto Graphics para dibujar
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Importante para el correcto pintado

        // Fondo - Cielo
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 700, 450);

        // Fondo - Pasto
        g.setColor(Color.GREEN);
        g.fillRect(0, 450, 700, 250);

        // Casa - Paredes
        g.setColor(Color.CYAN);
        g.fillRect(250, 300, 200, 150);

        // Casa - Techo (triángulo)
        int[] xTecho = {225, 350, 475};
        int[] yTecho = {300, 200, 300};
        g.setColor(Color.RED);
        g.fillPolygon(xTecho, yTecho, 3);

        // Casa - Puerta
        g.fillRect(325, 370, 50, 80);

        // Casa - Ventanas
        g.setColor(Color.BLACK);
        g.fillRect(275, 370, 25, 25); // Ventana izquierda
        g.fillRect(400, 370, 25, 25); // Ventana derecha

        // Árbol - Hojas
        g.setColor(Color.GREEN);
        g.fillOval(575, 250, 50, 50);
        g.fillOval(550, 275, 50, 50);
        g.fillOval(600, 275, 50, 50);
        g.fillOval(575, 275, 50, 50);

        // Árbol - Tronco
        g.setColor(new Color(139, 69, 19)); // Color marrón
        g.fillRect(585, 325, 30, 125);

        // Sol
        g.setColor(Color.YELLOW);
        g.fillOval(580, 75, 70, 70);

        // Dibujamos todos los meteoritos
        for (Meteorito m : meteoritos) {
            m.dibujar(g);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Casa().setVisible(true); // Mostrar ventana
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
