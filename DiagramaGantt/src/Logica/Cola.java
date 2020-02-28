/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
    
    public Nodo obtenerUltimo(){
        if(ultimo==null){
            return null;
        }else{
            return ultimo;
        }
    }
    public int tamanio(){
        if(estaVacia()){
            return 0;
        }else{
            int i=1;
            Nodo aux = new Nodo("aux", i, i);
            aux = cabecera;
            while(aux!=null && aux.siguiente!=null){
                i++;
                aux=aux.siguiente;
            }
            return i;
        }
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

}