/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.HeadlessException;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import oracle.jrockit.jfr.JFR;

/**
 *
 * @author Estudiantes
 */
public class VentanaPrueba extends JFrame{

    public VentanaPrueba() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        
        
        ScrollPane scrollCanvas =new ScrollPane();
        scrollCanvas.add(new Lienzo());
        add(scrollCanvas);
        setVisible(true);
    }
    
}
