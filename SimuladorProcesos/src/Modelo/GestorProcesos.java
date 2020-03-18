/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Control;
import Logica.Cola;
import Logica.Nodo;
import Vista.Ventana;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class GestorProcesos {

    private Cola procesos;
    private Control c;

    public GestorProcesos(Control c) {
        this.c = c;
        procesos = new Cola();
    }

    private void calcularTFinal() {
        if (!procesos.estaVacia()) {
            Nodo actual = procesos.obtenerCabeza();
            Nodo anterior = actual;

            while (actual != null && anterior != null) {
                if (actual != procesos.obtenerCabeza()) {
                    actual.tComienzo = anterior.tFinal;
                    actual.tFinal = actual.tRafaga + actual.tComienzo;
                } else {
                    actual.tComienzo = actual.tLlegada;
                    actual.tFinal = actual.tRafaga + actual.tComienzo;

                }

                anterior = actual;
                actual = actual.siguiente;
            }

        }
    }

    private void calcularTRetorno() {
        
        Nodo actual = procesos.obtenerCabeza();
        while (actual != null) {
            actual.tRetorno = actual.tFinal - actual.tLlegada;
            actual = actual.siguiente;

        }
        
    }

    private void calcularTEspera() {
        Nodo actual = procesos.obtenerCabeza();
        while (actual != null) {
            actual.tEspera = actual.tRetorno - actual.tRafaga;
            actual = actual.siguiente;

        }
    }

    public void realizarCalculos() {
        procesos.ordenarBurbuja();
        calcularTFinal();
        calcularTRetorno();
        calcularTEspera();
    }

public void agregarProceso(Ventana v) {
        if(v.getJtNombre().getText().equals("") ||v.getJttRafaga().getText().equals("") || v.getJttLlegada().getText().equals("")){
            JOptionPane.showMessageDialog(v, " Se han dejado campos sin llenar");
        }else {
            
        String nombre = v.getJtNombre().getText();
        int llegada = Integer.parseInt(v.getJttLlegada().getText());
        int rafaga = Integer.parseInt(v.getJttRafaga().getText());
        
        Nodo aux = new Nodo(nombre, llegada, rafaga);
        v.obtenerModeloTablaRegistro().agregarFila(aux);
        procesos.aniadir(nombre, llegada, rafaga);
        
        }
    }

    public Cola getProcesos() {
        return procesos;
    }

}
