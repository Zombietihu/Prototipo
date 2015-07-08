/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fabian
 */
public final class Expediente extends JFrame implements MouseListener{
    JPanel d_leftPanel;
    JPanel d_rightPanel;
    JPanel d_verticalPanel;
    
    JButton analizar;
    JButton newImg;
    JButton print;
    JButton help;  
    JButton atras;
    JButton exit;
    JButton guardar;
    JButton editar;
    JButton nuevo;
    
    JTextArea pacienteText;
    JTextArea edadText;
    JTextArea calendarioText;
    JTextArea motivoConsultaText;
    JTextArea descripcionText;
    
    JLabel paciente;
    JLabel edad;
    JLabel sexoL;
    JLabel calendario;
    JLabel motivoConsulta;
    JLabel descripcion;
    
    JComboBox sexo;
    
    Calendar c1 = GregorianCalendar.getInstance();
    
    BufferedImage bmp ;
    int ban;
    
     Prueba Imagen;
    
    private int contPuntos = 0; //cuenta num puntos
    private Point puntos[] = new Point[100000]; //Arreglo 10000 referencias
    
    public Expediente(BufferedImage bmp){
         
        this.bmp = bmp;
        iniciarComponentes();
        iniciarBandera();
        nuevaImagen(bmp);
        setTitle("Expedientes");
        setSize(1366, 768);
        setVisible(true);
          
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    
    public void iniciarComponentes(){
        JSplitPane pane=new JSplitPane();
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.setEnabled(true);
        pane.setOneTouchExpandable(true);
        initLeftPanel();
        pane.setLeftComponent(d_leftPanel);
        d_leftPanel.setMinimumSize(new Dimension(320,d_leftPanel.getMinimumSize().height));
        initRightPanel();
        pane.setRightComponent(d_rightPanel);
        d_rightPanel.setMinimumSize(new Dimension(770,d_rightPanel.getMinimumSize().height));
        d_rightPanel.addMouseListener(this);
        
        initVerticalPanel();
        JSplitPane paneV=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        paneV.setTopComponent(pane);
        paneV.setBottomComponent(d_verticalPanel);       
        paneV.setContinuousLayout(true);
        paneV.setDividerLocation(550);       
        paneV.setEnabled(true);
        paneV.setOneTouchExpandable(true);
        add(paneV);
        
    }
    
    public void initLeftPanel(){
       d_leftPanel = new JPanel();
       d_leftPanel.setLayout(null);
       //d_leftPanel.setBackground(java.awt.Color.);
       
       paciente = new JLabel("Paciente:");
       paciente.setBounds(10,10,100,20);
       pacienteText = new JTextArea();
       pacienteText.setBounds(10,30,300,20);
       
       edad = new JLabel("Edad:");
       edad.setBounds(10,60,50,20);
       edadText = new JTextArea();
       edadText.setBounds(60,60,50,20);
       
       sexoL = new JLabel("Sexo:");
       sexoL.setBounds(10, 90, 40, 20);
       sexo = new JComboBox();
       sexo.addItem("");
       sexo.addItem("Masculino");
       sexo.addItem("Femenino");
       sexo.setBounds(60, 90, 100, 20);
       
       calendario = new JLabel("Fecha:"+c1.getTime().toLocaleString());
       calendario.setBounds(10, 120, 250, 20);
       
       motivoConsulta = new JLabel("Motivo de la consulta");
       motivoConsulta.setBounds(10, 150, 200, 20);
       motivoConsultaText = new JTextArea();
       motivoConsultaText.setBounds(10, 180, 300, 100);
       
       descripcion = new JLabel("Descripcion: ");
       descripcion.setBounds(10, 300, 120, 20);
       descripcionText = new JTextArea();
       descripcionText.setBounds(10, 330, 300, 100);
       
       ImageIcon g = new ImageIcon(this.getClass().getResource("/Imagen/guardar.png"));
       guardar = new JButton();
       guardar.setIcon(g);
       guardar.setBounds(10, 450, 48, 48);
       guardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               guardarReporte();
            }
        });
       
       ImageIcon e = new ImageIcon(this.getClass().getResource("/Imagen/editar.png"));
       editar = new JButton();
       editar.setIcon(e);
       editar.setBounds(70, 450, 48, 48);
       editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               editarReporte();
            }
        });
       
       ImageIcon n = new ImageIcon(this.getClass().getResource("/Imagen/Nuevo_Usuario.gif"));
       nuevo = new JButton();
       nuevo.setIcon(n);
       nuevo.setBounds(130, 450, 48, 48);
       nuevo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               nuevoReporte();
            }
        });
       
       d_leftPanel.add(paciente);
       d_leftPanel.add(pacienteText);
       d_leftPanel.add(edad);
       d_leftPanel.add(edadText);
       d_leftPanel.add(sexoL);
       d_leftPanel.add(sexo);
       d_leftPanel.add(calendario);
       d_leftPanel.add(motivoConsulta);
       d_leftPanel.add(motivoConsultaText);
       d_leftPanel.add(descripcion);
       d_leftPanel.add(descripcionText);
       d_leftPanel.add(guardar);
       d_leftPanel.add(editar);
       d_leftPanel.add(nuevo);
    }
    
    public void initRightPanel(){
       d_rightPanel = new JPanel();
       d_rightPanel.setLayout(null);
       d_rightPanel.setBackground(java.awt.Color.white);
       
      
       
    }
    
    public void initVerticalPanel(){
        d_verticalPanel = new JPanel();
        d_verticalPanel.setLayout(null);
        d_verticalPanel.setBackground(java.awt.Color.white);
        
        ImageIcon a = new ImageIcon(this.getClass().getResource("/Imagen/analizar.jpg"));
        ImageIcon i = new ImageIcon(this.getClass().getResource("/Imagen/new.png"));
        ImageIcon p = new ImageIcon(this.getClass().getResource("/Imagen/print.png"));
        ImageIcon h = new ImageIcon(this.getClass().getResource("/Imagen/help.jpeg"));
        ImageIcon r = new ImageIcon(this.getClass().getResource("/Imagen/return.png"));
        ImageIcon s = new ImageIcon(this.getClass().getResource("/Imagen/exit.png"));
        
        analizar = new JButton();
        analizar.setIcon(a);
        analizar.setBackground(java.awt.Color.white);
        analizar.setBounds(10, 10, 128, 128);
        analizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    analizarRadiografia();
                } catch (IOException ex) {
                    Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        newImg = new JButton();
        newImg.setIcon(i);
        newImg.setBackground(java.awt.Color.white);
        newImg.setBounds(180, 10, 128, 128);
        newImg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BufferedImage bmp2=null;
                JFileChooser selector=new JFileChooser();
                selector.setDialogTitle("Seleccione una imagen");
                FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
                selector.setFileFilter(filtroImagen);
                
                int flag=selector.showOpenDialog(null);
        //Comprobamos que pulse en aceptar
                 if(flag==JFileChooser.APPROVE_OPTION){
                    try {
                //Devuelve el fichero seleccionado
                      File imagenSeleccionada=selector.getSelectedFile();
                //Asignamos a la variable bmp la imagen leida
                      bmp2 = ImageIO.read(imagenSeleccionada);
                     }  catch (Exception ex) {
                    }
                  
                    }
              nuevaImagen(bmp2);
            }
        });
        
        print = new JButton();
        print.setIcon(p);
        print.setBackground(java.awt.Color.white);
        print.setBounds(360, 10, 128, 128);
        print.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    imprimir();
                } catch (DocumentException ex) {
                    Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        help = new JButton();
        help.setIcon(h);
        help.setBackground(java.awt.Color.white);
        help.setBounds(540, 10, 128, 128);
        help.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               ayuda();
            }
        });
        
        atras = new JButton();
        atras.setIcon(r);
        atras.setBackground(java.awt.Color.white);
        atras.setBounds(720, 10, 128, 128);
        atras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                atras();
            }
        });
        
        exit = new JButton();
        exit.setIcon(s);
        exit.setBackground(java.awt.Color.white);
        exit.setBounds(900, 10, 128, 128);
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                salir();
            }
        });
        
        d_verticalPanel.add(analizar);
        d_verticalPanel.add(newImg);
        d_verticalPanel.add(print);
        d_verticalPanel.add(help);
        d_verticalPanel.add(atras);
        d_verticalPanel.add(exit);
    }

    public void analizarRadiografia() throws IOException{
       
        File imagenSeleccionada=new File("/home/fabian/NetBeansProjects/Smile/src/Paciente/andrea-castro-trazado1.jpg");
       
        BufferedImage bmp1=ImageIO.read(imagenSeleccionada);
        Imagen = new Prueba(bmp1);
        Imagen.addMouseListener(this);
        d_rightPanel.removeAll();
        d_rightPanel.add(Imagen);
        d_rightPanel.repaint();
    }
    
    public void atras(){
        Frame frame = new Frame();
        this.dispose();
    }
    
    public void ayuda(){
         JOptionPane.showMessageDialog(null, "En construccion");
    }
    
        
    public void editarReporte(){
        pacienteText.enable();
        edadText.enable();
        motivoConsultaText.enable();
        descripcionText.enable();
        sexo.enable();
    }
    
    public void guardarReporte(){
        if (pacienteText.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo Paciente esta Vacio.");
            return;
        }else{
            Pattern pat = Pattern.compile("[a-zA-Z]");
            Matcher mat = pat.matcher(pacienteText.getText());
            if (mat.matches()) {
                JOptionPane.showMessageDialog(null, "Campo Paciente Invalido, debe contener solo letras.");
                return;
            }
        }
        
        
       
                    
        pacienteText.disable();
        edadText.disable();
        motivoConsultaText.disable();
        descripcionText.disable();
        sexo.disable();
        
    }
    public int iniciarBandera(){
        ban =1;
        return 1;
    }
    
    public void imprimir() throws DocumentException, FileNotFoundException, BadElementException, IOException{
        
       
         ImprimirReporte imprime = new ImprimirReporte();
         imprime.setNombre(pacienteText.getText());
         imprime.setEdad(edadText.getText());
         imprime.setSexo(sexo.getSelectedItem().toString());
         imprime.setFecha( calendario.getText());
         imprime.setMotivo(motivoConsultaText.getText());
         imprime.setDescripcion( descripcionText.getText());
         imprime.ImprimirReporte();
    }
    
    public void nuevaImagen(BufferedImage bmp1){
       
        Imagen = new Prueba(bmp1);
        Imagen.addMouseListener(this);
        d_rightPanel.removeAll();
        d_rightPanel.add(Imagen);
        d_rightPanel.repaint();
       
              
    }
    
    public void nuevoReporte(){
        pacienteText.setText("");
        edadText.setText("");
        motivoConsultaText.setText("");
        descripcionText.setText("");
        sexo.setSelectedIndex(0);
        pacienteText.enable();
        edadText.enable();
        motivoConsultaText.enable();
        descripcionText.enable();
        sexo.enable();
    }        
    
  
    
    public void salir(){
        this.dispose();
    }

    @Override
     public void mouseClicked(MouseEvent e) {
      Point p = MouseInfo.getPointerInfo().getLocation();
       
      
            System.out.println("x: "+p.x+" | y: "+p.y);
           
    }
    
    public void mousePressed(MouseEvent e) {
        
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == d_rightPanel){
            System.out.println("Entro al Panel  ");
            d_rightPanel.repaint();
        }
  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == d_rightPanel){
            System.out.println("Salio del panel");
        }
    }

    
    
    
}
