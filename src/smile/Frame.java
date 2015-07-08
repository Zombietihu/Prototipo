/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fabian
 */
public final class Frame extends JFrame{
    JLabel  labelTitle;
    JLabel  bg;
    JLabel  labelAbrir;
    JLabel  labelHelp;
    JButton expediente;
    JButton ayuda;
    JPanel  panel;
    
    public Frame(){
        iniciarComponentes();
        setTitle("Smile");
        setSize(500, 600);
        add(panel);
        setVisible(true);
    }
    
    public void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(java.awt.Color.white);
        
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/Imagen/logo.jpg"));
        ImageIcon abrir = new ImageIcon(this.getClass().getResource("/Imagen/abrir.png"));
        ImageIcon help = new ImageIcon(this.getClass().getResource("/Imagen/help.jpeg"));

        
        labelTitle = new JLabel();
        labelTitle.setText("SMILE");
        labelTitle.setBounds(220, 10, 300, 20);
        panel.add(labelTitle);
        
        bg = new JLabel();
        bg.setIcon(icon);
        bg.setBounds(50, 25, 500, 300);
        panel.add(bg);
        
        expediente = new JButton();
        expediente.setIcon(abrir);
        expediente.setBackground(java.awt.Color.white);
        expediente.setBounds(50, 350, 128, 128);
       
        panel.add(expediente);
        expediente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                abrirRadiografia();
            }
        });
        
        labelAbrir = new JLabel();
        labelAbrir.setText("Abrir Radiografia");
        labelAbrir.setBounds(60, 500, 128, 20);
        panel.add(labelAbrir);
        
        ayuda = new JButton();
        ayuda.setIcon(help);
        ayuda.setBackground(java.awt.Color.white);
        ayuda.setBounds(300, 350, 128, 128);
        panel.add(ayuda);
        ayuda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
             
             //Codigo Ayuda   
            }
        });
        
        labelHelp = new JLabel();
        labelHelp.setText("Tutorial");
        labelHelp.setBounds(350, 500, 128, 20);
        panel.add(labelHelp);
    }
    
    public void abrirRadiografia(){
         //Creamos la variable que será devuelta (la creamos como null)
        BufferedImage bmp=null;
        String ruta = null;
        //Creamos un nuevo cuadro de diálogo para seleccionar imagen
        JFileChooser selector=new JFileChooser();
        //Le damos un título
        selector.setDialogTitle("Seleccione una imagen");
        //Filtramos los tipos de archivos
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        //Abrimos el cuadro de diálog
        int flag=selector.showOpenDialog(null);
        //Comprobamos que pulse en aceptar
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                //Devuelve el fichero seleccionado
                File imagenSeleccionada=selector.getSelectedFile();
                ruta = imagenSeleccionada.getPath();
                //Asignamos a la variable bmp la imagen leida
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                  
        }
        //Asignamos la imagen cargada a la propiedad imageActual
        //Retornamos el valor
        System.out.println(ruta);
        Expediente exp = new Expediente(bmp);
        dispose();            
    }
    
}
