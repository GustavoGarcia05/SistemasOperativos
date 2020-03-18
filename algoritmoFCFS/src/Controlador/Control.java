/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Nodo;
import Modelo.GestorProcesos;
import Modelo.ModeloTabla;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener {

    private Ventana v;
    private GestorProcesos m;

    public Control(Ventana v) {
        this.v = v;
        m = new GestorProcesos(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == v.getRegistrar()) {
            m.agregarProceso(v);
            v.limpiarCampos();

        }
        if (e.getSource() == v.getGraficar()) {
            m.realizarCalculos();
            ModeloTabla tablaAUX = new ModeloTabla();
            tablaAUX.agregarFilas(m.getProcesos().obtenerCabeza());
            v.getTablaDatos().setModel(tablaAUX);
            v.getPintura().iniciar();
        }
        if (e.getSource() == v.getContinuar()) {
            v.dispose();
            v=new Ventana();
           
        }
    }

    public GestorProcesos getM() {
        return m;
    }

    private void imprimirProcesos(String texto) {
        System.out.println(texto);
        Nodo aux = m.getProcesos().obtenerCabeza();
        while (aux != null) {
            System.out.println("nom: " + aux.nombre + "/ lle: " + aux.tLlegada + " raf: " + aux.tRafaga
                    + " com: " + aux.tComienzo + " fin: " + aux.tFinal + " ret: " + aux.tRetorno + " esp: " + aux.tEspera);
            aux = aux.siguiente;
        }
    }

}
