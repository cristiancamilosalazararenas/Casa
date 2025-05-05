package autonoma.casa.gui;

import autonoma.casa.elements.Meteorito;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Casa extends javax.swing.JFrame {
    
    private ArrayList<Meteorito> meteoritos;

    //Constructor del JFrame
    public Casa() {
        initComponents();
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        
        // Inicializamos la lista de meteoritos
        meteoritos = new ArrayList<>();
        meteoritos.add(new Meteorito(50, 0, 30, 30, 3, Color.LIGHT_GRAY));
        meteoritos.add(new Meteorito(100, 0, 30, 30, 4, Color.GRAY));
        meteoritos.add(new Meteorito(200, 100, 30, 30, 3, Color.DARK_GRAY));
        meteoritos.add(new Meteorito(300, 0, 30, 30, 4, Color.LIGHT_GRAY));
        meteoritos.add(new Meteorito(400, 200, 30, 30, 3, Color.GRAY));
        meteoritos.add(new Meteorito(500, 100, 30, 30, 4, Color.DARK_GRAY));
        meteoritos.add(new Meteorito(650, 0, 30, 30, 5, Color.LIGHT_GRAY));
        
        // Iniciamos hilo para moverlos
        Thread hilo = new Thread(() -> {
            while (true) {
                for (Meteorito m : meteoritos) {
                    m.mover();
                    m.reiniciarSiLlegaAbajo(700);
                }
                repaint(); // redibuja la pantalla
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        hilo.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g); // importante para que la ventana se pinte bien
        //Alrededores
        //Creación del cielo
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 700, 450);
        //Creación del pasto
        g.setColor(Color.green);
        g.fillRect(0, 450, 700, 250);
        //Creación de la casa
        //Creación de las paredes
        g.setColor(Color.cyan);
        g.fillRect(250, 300, 200, 150);
        //Creación del techo
        int[] x = {225, 350, 475};
        int[] y = {300, 200, 300};
        g.setColor(Color.RED);
        g.fillPolygon(x, y, 3);
        //Creación de la puerta
        g.fillRect(325, 370, 50, 80);
        //Creación de las ventanas
        g.setColor(Color.BLACK);
        g.fillRect(275, 370, 25, 25);//Ventana izquierda
        g.fillRect(400, 370, 25, 25);//Ventana derecha
        //Creación del árbol
        //Creación de las hojas
        g.setColor(Color.GREEN);
        g.fillOval(575, 250, 50, 50);
        g.fillOval(550, 275, 50, 50);
        g.fillOval(600, 275, 50, 50);
        g.fillOval(575, 275, 50, 50);
        //Creación del tronco
        g.setColor(new Color(139, 69, 19));
        g.fillRect(585, 325, 30, 125);
        //Creación del sol
        g.setColor(Color.YELLOW);
        g.fillOval(580, 75, 70, 70);
        //Creación de los meteoritos
        //Usamos un for each para dibujar cada meteorito
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
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Casa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
