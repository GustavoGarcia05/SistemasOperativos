/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logica.Cola;
import Vista.Ventana;

/**
 *
 * @author Gustavo
 */
public class GestorProcesos {
    private Cola procesos;

    public GestorProcesos() {
        procesos = new Cola();
    }
    
    public void calcularTEspera(){
        int espera;
        
    }
    public void agregarProceso(Ventana v){
        String nombre = v.getJtfProceso().getText();
        int llegada = Integer.parseInt( v.getJtfEspera().getText());
        int rafaga = Integer.parseInt( v.getJtfRafaga().getText());
        
        procesos.aniadir(nombre, llegada, rafaga);
    }
    
    

    public Cola getProcesos() {
        return procesos;
    }
    
    
    
}