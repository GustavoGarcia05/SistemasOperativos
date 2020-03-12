/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Nodo;
import Modelo.GestorProcesos;
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

        if (e.getSource() == v.getIniciar()) {
            m.agregarProceso(v);
            m.getProcesos().ordenarBurbuja();
            m.realizarCalculos();
            v.getPintura().iniciar();
            imprimirProcesos("agregar proceso");
        }
        if (e.getSource() == v.getPausar()) {
            v.getPintura().pausar();
            imprimirProcesos("ordenar procesos");
        }
        if (e.getSource() == v.getContinuar()) {
            v.getPintura().continuar();
            imprimirProcesos("realizar calculos");
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
