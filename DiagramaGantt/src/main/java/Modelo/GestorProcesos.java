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
public class GestorProcesos {
    private Cola procesos;

    public GestorProcesos(Cola procesos) {
        this.procesos = procesos;
    }
    
    public void calcularTEspera(){
        if(!procesos.estaVacia()){
            //procesos.obtenerCabeza().tEspera=procesos.obtenerCabeza().siguiente.tEspera+procesos.obtenerCabeza().;
                    
        }
    }

    public Cola getProcesos() {
        return procesos;
    }
    
    
    
}
