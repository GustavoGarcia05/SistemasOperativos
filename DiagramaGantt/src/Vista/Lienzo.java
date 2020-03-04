/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Cola;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author estudiantes
 */
public class Lienzo extends Canvas {
    
    private Cola co;
    public Lienzo(Cola co) {
        this.co=co;
    }


    @Override
    public void paint(Graphics g) {
       if(co.estaVacia()){
           g.setColor(Color.red);
           g.drawRect(10, 10, 100, 100);
       }else{
           setSize(co.tamanio()*100, co.obtenerUltimo().tFinal);
       }
    }
    
    public void actualizarTamanio() {
        
    }

}
