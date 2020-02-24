/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cola;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener{
    private Ventana v;

    
    public Control(Ventana v) {
        this.v=v;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==v.getBtnRegistrar()){
           
           v.getJtfProceso().setText("");
           v.getJtfEspera().setText("");
           v.getJtfRafaga().setText("");
                  
       }
    }
    
}
