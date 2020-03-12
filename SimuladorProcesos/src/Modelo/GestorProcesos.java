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
        procesos.aniadir("E", 4, 2);
        procesos.aniadir("D", 3, 5);
        procesos.aniadir("C", 2, 4);
        procesos.aniadir("B", 1, 4);
        procesos.aniadir("A", 0, 8);

    }

    public Cola getProcesos() {
        return procesos;
    }

}
