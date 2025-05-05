// Este es el paquete donde se ubica la clase Meteorito.
package autonoma.casa.elements;

// Importamos las clases necesarias para los gráficos
import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que representa un meteorito con movimiento vertical.
 *
 * @author      Cristian Camilo Salazar Arenas
 * @version     1.0
 * @since       2025.05.04
 */
public class Meteorito {

    /**
     * Coordenada x del meteorito.
     */
    private int x;

    /**
     * Coordenada y del meteorito.
     */
    private int y;

    /**
     * Ancho del meteorito en píxeles.
     */
    private int ancho;

    /**
     * Alto del meteorito en píxeles.
     */
    private int alto;

    /**
     * Velocidad de caída del meteorito.
     */
    private int velocidad;

    /**
     * Color del meteorito.
     */
    private Color color;

    /**
     * Constructor que crea un nuevo meteorito.
     *
     * @param x La posición horizontal inicial
     * @param y La posición vertical inicial
     * @param ancho El ancho del meteorito
     * @param alto El alto del meteorito
     * @param velocidad La velocidad de caída
     * @param color El color del meteorito
     */
    public Meteorito(int x, int y, int ancho, int alto, int velocidad, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.velocidad = velocidad;
        this.color = color;
    }

    /**
     * Mueve el meteorito hacia abajo según su velocidad.
     */
    public void mover() {
        y += velocidad;
    }

    /**
     * Reinicia la posición del meteorito si llega al límite inferior.
     *
     * @param limiteY El límite inferior del área de movimiento
     */
    public void reiniciarSiLlegaAbajo(int limiteY) {
        if (y > limiteY) {
            y = 0; // Vuelve a la parte superior
        }
    }

    /**
     * Dibuja el meteorito en el contexto gráfico especificado.
     *
     * @param g El objeto Graphics donde se dibujará
     */
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, ancho, alto);
    }

    // Métodos getter para acceder a las propiedades del meteorito
    /**
     * @return La coordenada x actual
     */
    public int getX() {
        return x;
    }

    /**
     * @return La coordenada y actual
     */
    public int getY() {
        return y;
    }

    /**
     * @return El ancho del meteorito
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @return El alto del meteorito
     */
    public int getAlto() {
        return alto;
    }
}