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
public class Nodo {

    public String nombre;
    public int tLlegada;
    public int tRafaga;
    public int tComienzo;
    public int tFinal;
    public int tRetorno;
    public int tEspera;
    public Nodo siguiente;

    public Nodo(String nombre, int tLlegada, int tRafaga) {
        this.nombre = nombre;
        this.tLlegada = tLlegada;
        this.tRafaga = tRafaga;

        tComienzo = tFinal = tRetorno = tEspera = 0;
        siguiente = null;

    }
}
