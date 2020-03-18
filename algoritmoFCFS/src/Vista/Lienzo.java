/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Nodo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Lienzo extends Canvas implements Runnable {

    private int x, y, unidadPatron, ancho, alto;
    private Thread hilo;
    private Ventana v;

    public Lienzo(Ventana v) {
        setSize(2400, 1900);
        setBackground(Color.gray);

        imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TRANSLUCENT);
        imagen.getGraphics().setColor(Color.red);
        x = 0;
        y = 20;
        unidadPatron = 20;
        this.v = v;
        hilo = new Thread(this);
    }

    @Override
    public void paint(Graphics g) {

        for (int i = 10; i < getWidth(); i += unidadPatron) {
            imagen.getGraphics().drawLine(i, 0, i, getWidth());
            imagen.getGraphics().drawString(" " + i / unidadPatron, i, 10);
        }

        g.drawImage(imagen, 0, 0, null);

    }

    private void actualizar(Nodo aux) {
        if (aux == null) {
            hilo.stop();
            return;
        }
        if (x < aux.tFinal * unidadPatron) {
            x += unidadPatron;
        }

    }

    private BufferedImage imagen;

    public void dibujar(Graphics g, Nodo aux) {

        imagen.getGraphics().drawString(aux.nombre, 0, y + unidadPatron / 2 + 5);
        imagen.getGraphics().fillRect(x, y, unidadPatron, unidadPatron);

        g.drawImage(imagen, 0, 0,  null);

    }

    public void iniciar() {
        hilo.start();
    }

    public void pausar() {
        hilo.suspend();
    }

    public void continuar() {
        hilo.resume();
    }

    @Override
    public void run() {
        Nodo aux = v.getC().getM().getProcesos().obtenerCabeza();
        Graphics g = getGraphics();

        while (aux != null) {
            if (x == aux.tFinal * unidadPatron) {
                aux = aux.siguiente;
                y += unidadPatron;
            }
            actualizar(aux);
            dibujar(g, aux);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
