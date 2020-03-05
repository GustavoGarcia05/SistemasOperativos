/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logica.Cola;
import Logica.Nodo;
import Vista.Ventana;
import com.sun.xml.internal.ws.client.ContentNegotiation;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class GestorProcesos {

    private Cola procesos;

    public GestorProcesos() {
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
            actual.tEspera = actual.tRetorno-actual.tRafaga;
            actual = actual.siguiente;

        }
    }
    
    public void realizarCalculos(){
        procesos.ordenarBurbuja();
        calcularTFinal();
        calcularTRetorno();
        calcularTEspera();
    }
    public void agregarProceso(Ventana v) {
        if(v.getJtfProceso().getText().equals("") ||v.getJtfEspera().equals("") || v.getJtfRafaga().equals("")){
            JOptionPane.showMessageDialog(v, " Se han dejado campos sin rellenar");
        }else{
        String nombre = v.getJtfProceso().getText();
        int llegada = Integer.parseInt(v.getJtfEspera().getText());
        int rafaga = Integer.parseInt(v.getJtfRafaga().getText());

        procesos.aniadir(nombre, llegada, rafaga);
        }
    }



    public Cola getProcesos() {
        return procesos;
    }

}
