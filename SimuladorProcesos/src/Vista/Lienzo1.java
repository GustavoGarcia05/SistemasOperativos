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
public class Lienzo1 extends Canvas implements Runnable {

    private int x, y, unidadPatron, ancho, alto;
    private Thread hilo;
    private Ventana v;
    private int numMaxColor = 255;
    private int aumentoColor = 15;

    public Lienzo1(Ventana v) {
        setSize(2400, 1900);

        imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        x = 0;
        y = 20;
        unidadPatron = 20;
        this.v = v;
        hilo = new Thread(this);
    }

    @Override
    public void paint(Graphics g) {
        /*if (getGraphics() != null) {
            imagen.getGraphics().setColor(new Color(255, 255, 255));
            for (int i = 10; i < getWidth(); i += unidadPatron) {
                imagen.getGraphics().drawLine(i, 0, i, getWidth());
                imagen.getGraphics().drawString(" " + i / unidadPatron, i, 10);
                if (imagen != null) {
                    g.drawImage(imagen, 0, 0, null);
                }
            }
        }*/
        imagen.getGraphics().fillRect(0, 0, 100, 100);
        imagen.getGraphics().setColor(Color.red);
        imagen.getGraphics().fillRect(0, 0, 50,50);
        g.drawImage(imagen, 0, 0, null);
        repaint();
        
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
            imagen.getGraphics().fillRect(x, y, unidadPatron, unidadPatron);

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
                imagen.getGraphics().setColor(cambiarColor());
            }
            actualizar(aux);
            dibujar(g);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
