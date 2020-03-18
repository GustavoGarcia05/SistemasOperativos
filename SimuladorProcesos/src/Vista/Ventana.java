/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control;
import Modelo.ModeloTabla;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
        //setExtendedState(MAXIMIZED_BOTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initPSuperior();
        initPCentral();
        initPInferior();
        initPanelIzquierdo();
        
        //setResizable(false);
        setVisible(true);
    }
    
    private JButton registrar;
    private JButton pausar;
    private JButton continuar;
    
    private void inicializarBotones(){
        
        registrar = new JButton("Registrar");
        registrar.addActionListener(c);
        panelInferior.add(registrar);
        
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
        
        tLlegada =new JLabel("Tiempo de llegada: ");
        panelSuperior.add(tLlegada);
        
        tRafaga =new JLabel("Tiempo de rafaga: ");
        panelSuperior.add(tRafaga);
    }
    private JTextField jtNombre;
    private JTextField jttRafaga;
    private JTextField jttLlegada;
    
    private void initTextFields(){
        
        jtNombre = new JTextField();
        panelSuperior.add(jtNombre);
        
        jttLlegada =new JTextField();
        panelSuperior.add(jttLlegada);
        
        jttRafaga =new JTextField();
        panelSuperior.add(jttRafaga);
    }
    
    private ScrollPane panelCentral;
    
    private void initPCentral(){
        panelCentral = new ScrollPane();
        initLienzo();
        add(CENTER,panelCentral);
        
    }
    
   // private Lienzo pintura;
    private Lienzo pintura;
    
    public void initLienzo(){
        //pintura= new Lienzo(this);
        pintura= new Lienzo(this);
        panelCentral.add(pintura);
        
    }
    private JTable tablaDatos;
    private void initPanelIzquierdo(){
        tablaDatos = new JTable(new ModeloTabla());
        JScrollPane scroll = new JScrollPane(tablaDatos);
        add(WEST,scroll);
    }
    
    public ModeloTabla  obtenerModeloTablaRegistro() {
        return (ModeloTabla) tablaDatos.getModel();
    }

    public void limpiarCampos() {
        jtNombre.setText("");
        jttLlegada.setText("");
        jttRafaga.setText("");
    }
    
    // Obtener Elementos

    public JButton getRegistrar() {
        return registrar;
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

    public JTextField getJtNombre() {
        return jtNombre;
    }

    public JTextField getJttRafaga() {
        return jttRafaga;
    }

    public JTextField getJttLlegada() {
        return jttLlegada;
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }
    
    
    
    
}
