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
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Lienzo extends Canvas {
    private int x=0,y=0;
    public Lienzo() {
        setBackground(new Color(0,114,46));
        System.out.println("aqui llega");
    }


    @Override
    public void paint(Graphics g) {
        g.fillOval(x, y, 100, 100);
    }
    
    public void actualizarInformacion(int x, int y) {
        this.x=x;
        this.y=y;
        
        System.out.println("X es: "+x+" Y es : "+y);
    }

}
