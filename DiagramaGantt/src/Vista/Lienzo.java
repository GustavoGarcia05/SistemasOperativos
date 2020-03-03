/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author estudiantes
 */
public class Lienzo extends Canvas{

    public Lienzo() {
        setBackground(Color.cyan);
        //setSize(9000, 7000);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(10, 10, 8000, 6000);
        
    }
    
    public void actualizarTamanio(){
        
    }
    
}
