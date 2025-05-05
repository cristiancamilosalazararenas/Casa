package autonoma.casa.elements;

import java.awt.Color;
import java.awt.Graphics;

//Creación de la clase
public class Meteorito {
    
    //Atributos de la clase Meteorito
    private int x, y, ancho, alto, velocidad;
    private Color color;

    //Constructor de la clase Meteorito
    public Meteorito(int x, int y, int ancho, int alto, int velocidad, Color color){
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.velocidad = velocidad;
        this.color = color;
    }

    //Método que permitirá que se muevan los meteoritos a cierta velocidad
    public void mover(){
        y += velocidad;
    }
    
    //Método que devuelve el meteorito a su posición inicial si pasa el alto del JFrame
    public void reiniciarSiLlegaAbajo(int limiteY){
        if(y > limiteY){
            y = 0;//El meteorito volverá a la coordenada 0 en Y.
        }
    }
    
    //Método que se encarga de dibujar al meteorito
     public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, ancho, alto);
    }
}
