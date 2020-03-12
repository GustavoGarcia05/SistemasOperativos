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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Lienzo extends Canvas implements Runnable{
    private int x,y;
    private Thread hilo;
    public Lienzo() {
        setBackground(new Color(0,114,46));
        x=y=0;
        hilo= new Thread(this);
        hilo.start();
    }


    @Override
    public void paint(Graphics g) {
        if(g==null){
            
        }else{
        g.fillOval(x, y, 100, 100);
            
        }
    }

    @Override
    public void run() {
        while(true){
            x+=1;
            paint(this.getGraphics());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

}
