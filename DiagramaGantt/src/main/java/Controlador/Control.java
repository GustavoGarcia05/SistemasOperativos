/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Cola;
import Logica.Nodo;
import Modelo.GestorProcesos;
import Modelo.ModeloTabla;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener{
    private Ventana v;
    private GestorProcesos gestor;
    
    public Control(Ventana v) {
        this.v=v;
        gestor = new GestorProcesos();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==v.getBtnRegistrar()){
           
           gestor.agregarProceso(v);
           Nodo aAgregar =gestor.getProcesos().obtenerUltimo();
           v.obtenerModeloTabla().agregarFila(aAgregar);
           v.limpiarCampos();

       }
    }
  
    
}
