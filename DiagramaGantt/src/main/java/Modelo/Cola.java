/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gustavo
 */
public class Cola {

    private Nodo cabecera, ultimo;

    public Cola() {
        cabecera = ultimo = null;
    }

    public void aniadir(String nombre, int tLlegada, int tRafaga) {
        Nodo nuevoNodo = new Nodo(nombre, tLlegada, tRafaga);

        if (cabecera == null) {
            cabecera = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }
        ultimo = nuevoNodo;
    }

    public void eliminar() {
        if (cabecera != null) {
            Nodo eliminar = cabecera;
            cabecera = cabecera.siguiente;
            eliminar.siguiente = null;
            if (cabecera == null) {
                ultimo = null;
            }
        }

    }

    public Nodo obtenerCabeza() {
        if (cabecera == null) {
            return null;
        } else {
            return cabecera;
        }
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

}
