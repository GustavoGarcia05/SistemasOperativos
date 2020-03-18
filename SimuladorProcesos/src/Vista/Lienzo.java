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
    private int numMaxColor = 255;
    private int aumentoColor = 15;

    public Lienzo(Ventana v) {
        setSize(2400, 1900);
        setBackground(Color.gray);

        x = 0;
        y = 20;
        unidadPatron = 20;
        this.v = v;
        hilo = new Thread(this);
    }

    @Override
    public void paint(Graphics g) {
        if (getGraphics() != null) {
            g.setColor(new Color(255, 255, 255));
            for (int i = 10; i < getWidth(); i += unidadPatron) {
                g.drawLine(i, 0, i, getWidth());
                g.drawString(" " + i / unidadPatron, i, 10);

            }
        }

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

    public void dibujar(Graphics g) {
        if (getGraphics() != null) {
            g.fillRect(x, y, unidadPatron, unidadPatron);

        }
    }
    private int rojo = 100, verde = 100, azul = 100;

    private Color cambiarColor() {
        rojo = (int) (Math.random() * 225);
        verde = (int) (Math.random() * 225);
        azul = (int) (Math.random() * 225);

        return new Color(rojo, verde, azul);
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
                g.setColor(cambiarColor());
            }
            actualizar(aux);
            dibujar(g);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
