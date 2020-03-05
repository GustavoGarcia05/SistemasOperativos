/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Cola;
import Logica.Nodo;
import Modelo.GestorProcesos;
import Modelo.ModeloTabla;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener, Runnable {

    private Ventana v;
    private GestorProcesos gestor;
    private Thread actualizador;

    public Control(Ventana v) {
        this.v = v;
        gestor = new GestorProcesos();
        actualizador = new Thread(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == v.getBtnRegistrar()) {

            gestor.agregarProceso(v);
            v.limpiarCampos();

        }

        if (e.getSource() == v.getBtnGraficar()) {
            //v.inicializarPanelGrafico(gestor.getProcesos());
            gestor.realizarCalculos();
            v.obtenerModeloTabla().agregarFilas(gestor.getProcesos().obtenerCabeza());
            actualizador.start();
        }
    }

    private int x = 0, y = 0;

    @Override
    public void run() {
        try {
            actualizador.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            v.getDiagramaGantt().actualizarInformacion(x,y);
            x+=100; y+=100;
        }
        
    }

}
