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
public class Lienzo extends Canvas implements Runnable {

    private int x, y, unidadPatron, ancho, alto;
    private Thread hilo;
    private Ventana v;

    public Lienzo(Ventana v) {
        setBackground(Color.gray);
        setSize(2400, 1900);
        x = 0;
        y = 20;
        unidadPatron = 20;
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
        if (aux != null) {
            x += unidadPatron;
        }
        //System.out.println("nombre: "+aux.nombre+ "x: "+x +"t final:"+(aux.tRafaga * unidadPatron + aux.tLlegada * 20));

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
        Nodo auxUltimo = v.getC().getM().getProcesos().obtenerUltimo();
        while (true) {
            if (getGraphics() != null) {
                System.out.println("nombre: " + aux.nombre + "x: " + x + "t final:" + (aux.tRafaga * unidadPatron + aux.tLlegada * unidadPatron + aux.tComienzo * unidadPatron));

                if (x == (aux.tRafaga * unidadPatron + aux.tLlegada * unidadPatron + aux.tComienzo * unidadPatron)) {
                    y += unidadPatron;
                    aux = aux.siguiente;
                }

                actualizar(aux);
                paint(getGraphics());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
