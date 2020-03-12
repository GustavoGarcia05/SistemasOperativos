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
import Vista.Lienzo;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener{

    private Ventana v;
    private GestorProcesos gestor;

    public Control(Ventana v) {
        this.v = v;
        gestor = new GestorProcesos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == v.getBtnRegistrar()) {

            gestor.agregarProceso(v);
            v.limpiarCampos();

        }

        if (e.getSource() == v.getBtnGraficar()) {
            gestor.realizarCalculos();
            v.obtenerModeloTabla().agregarFilas(gestor.getProcesos().obtenerCabeza());
            v.getPanelGrafica().add((new Lienzo()));
            v.setVisible(true);
        }
    }


}
