package autonoma.casa.gui;

import java.awt.Color;
import java.awt.Graphics;

public class Casa extends javax.swing.JFrame {

    public Casa() {
        initComponents();
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
    }
    
    public void paint(Graphics g){
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
        g.setColor(Color.BLACK);
        g.fillRect(325, 370, 50, 80);
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
