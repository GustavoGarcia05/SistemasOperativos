/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control;
import static java.awt.BorderLayout.CENTER;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame {

    private Control c;

    public Ventana() {
        c = new Control(this);
        
        establecerVentana();
        
    }

    private void establecerVentana() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initPSuperior();
        initPCentral();
        initPInferior();
        
        setVisible(true);
    }
    
    private JButton iniciar;
    private JButton pausar;
    private JButton continuar;
    
    private void inicializarBotones(){
        
        iniciar = new JButton("Iniciar");
        iniciar.addActionListener(c);
        panelInferior.add(iniciar);
        
        pausar = new JButton("Pausar");
        pausar.addActionListener(c);
        panelInferior.add(pausar);
        
        continuar = new JButton("continuar");
        continuar.addActionListener(c);
        panelInferior.add(continuar);
    }
    
    private JPanel panelInferior;
    
    private void initPInferior(){
        panelInferior=  new JPanel();
        panelInferior.setLayout(new GridLayout());
        
        inicializarBotones();
        add(SOUTH,panelInferior);
    }
    
    private JPanel panelSuperior;
    
    private void initPSuperior(){
        panelSuperior=  new JPanel();
        panelSuperior.setLayout(new GridLayout(2,3));
        initLabels();
        initTextFields();
        add(NORTH,panelSuperior);
    }
    private JLabel nombre;
    private JLabel tRafaga;
    private JLabel tLlegada;
    
    private void initLabels(){
        
        nombre =new JLabel("Nombre: ");
        panelSuperior.add(nombre);
        
        tRafaga =new JLabel("Tiempo de rafaga: ");
        panelSuperior.add(tRafaga);
        
        tLlegada =new JLabel("Tiempo de llegada: ");
        panelSuperior.add(tLlegada);
    }
    private JTextField jtNombre;
    private JTextField jttRafaga;
    private JTextField jttLlegada;
    
    private void initTextFields(){
        
        jtNombre = new JTextField();
        panelSuperior.add(jtNombre);
        
        jttRafaga =new JTextField();
        panelSuperior.add(jttRafaga);
        
        jttLlegada =new JTextField();
        panelSuperior.add(jttLlegada);
    }
    
    private ScrollPane panelCentral;
    
    private void initPCentral(){
        panelCentral = new ScrollPane();
        initLienzo();
        add(CENTER,panelCentral);
        
    }
    
    private Lienzo pintura;
    
    public void initLienzo(){
        pintura= new Lienzo(this);
        panelCentral.add(pintura);
        
    }
    
    
    // Obtener Elementos

    public JButton getIniciar() {
        return iniciar;
    }

    public JButton getPausar() {
        return pausar;
    }

    public JButton getContinuar() {
        return continuar;
    }

    public Lienzo getPintura() {
        return pintura;
    }

    public Control getC() {
        return c;
    }
    
    
}
