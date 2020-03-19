/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.JOptionPane;

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

    private int ajuste;

    public void ordenarBurbuja() {
        if (!this.estaVacia()) {

            Nodo[] sinOrdenar = new Nodo[tamanio()-1];
            Nodo cab = obtenerCabeza();
            Nodo aux = obtenerCabeza().siguiente;
            int iterador = 0;

            while (aux != null) {
                sinOrdenar[iterador] = aux;
                aux = aux.siguiente;
                iterador++;
            }
            //ordenado por burbuja

            for (int i = 0; i < (sinOrdenar.length - 1); i++) {
                for (int j = 0; j < (sinOrdenar.length - 1); j++) {
                    if (sinOrdenar[j].tRafaga > sinOrdenar[j + 1].tRafaga) {
                        aux = (Nodo) sinOrdenar[j];
                        sinOrdenar[j] = sinOrdenar[j + 1];
                        sinOrdenar[j + 1] = aux;
                    }
                }

            }

            Cola ordenada = new Cola();
            ordenada.aniadir(cab.nombre, cab.tLlegada, cab.tRafaga);
            for (int i = 0; i < sinOrdenar.length; i++) {
                ordenada.aniadir(sinOrdenar[i].nombre, sinOrdenar[i].tLlegada, sinOrdenar[i].tRafaga);
            }

            if (ordenada.obtenerCabeza().tLlegada != 0) {
                aux = ordenada.cabecera;
                ajuste = aux.tLlegada;
                while (aux != null) {
                    aux.tLlegada -= ajuste;
                    aux = aux.siguiente;
                }
            }

            this.cabecera = ordenada.cabecera;

        } else {
            JOptionPane.showMessageDialog(null, "No existen procesos");
        }
    }

    public Nodo obtenerCabeza() {
        if (cabecera == null) {
            return null;
        } else {
            return cabecera;
        }
    }

    public Nodo obtenerUltimo() {
        if (ultimo == null) {
            return null;
        } else {
            return ultimo;
        }
    }

    public int tamanio() {
        if (estaVacia()) {
            return 0;
        } else {
            int i = 1;

            Nodo aux = cabecera;

            while (aux != null && aux.siguiente != null) {
                i++;
                aux = aux.siguiente;
            }
            return i;
        }
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

    public int getAjuste() {
        return ajuste;
    }

}
