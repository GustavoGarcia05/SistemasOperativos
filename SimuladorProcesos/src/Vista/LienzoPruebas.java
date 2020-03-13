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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class LienzoPruebas extends Canvas implements Runnable {

    private int x, y, unidadPatron, ancho, alto;
    private Thread hilo;
    private Ventana v;

    public LienzoPruebas(Ventana v) {
        setBackground(Color.gray);
        setSize(2400, 1900);
        x = 0;
        y = 20;
        unidadPatron = 50;
        this.v = v;

        hilo = new Thread(this);
    }

    @Override
    public void paint(Graphics g) {

        if (getGraphics() != null) {
            g.setColor(Color.blue);
            for (int i = 0; i < getWidth(); i += unidadPatron) {
                g.drawLine(i, 0, i, getWidth());
                g.drawString(" " + i / unidadPatron, i, 10);
            }
            g.fillRect(x - unidadPatron, y, unidadPatron, unidadPatron);

        }

    }

    private void actualizar(Nodo aux) {
        if (aux == null) {
            hilo.stop();
            return;
        }
        if (x < aux.tFinal * unidadPatron) {
            System.out.println("final : " + aux.tFinal * unidadPatron + " x : " + x);
            System.out.println("nomb: " + aux.nombre + " x: " + x + " Tfinal:" + aux.tFinal * unidadPatron);
            x += unidadPatron;
        }

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
        while (aux != null) {
            if (x == aux.tFinal * unidadPatron) {
                aux = aux.siguiente;
                y += unidadPatron;
            }
            actualizar(aux);
            paint(getGraphics());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LienzoPruebas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
