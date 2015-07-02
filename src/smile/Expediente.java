/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author fabian
 */
public class Expediente extends JFrame {
    JPanel d_leftPanel;
    JPanel d_rightPanel;
    JPanel d_verticalPanel;
    
    JButton analizar;
    JButton newImg;
    JButton print;
    JButton help;  
    JButton atras;
    JButton exit;
    
    String path;
    
    public Expediente(String ruta){
        path = ruta;
        iniciarComponentes();
        setTitle("Expedientes");
        setSize(1366, 768);
        setVisible(true);
    }
    
    public void iniciarComponentes(){
        JSplitPane pane=new JSplitPane();
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.setEnabled(true);
        pane.setOneTouchExpandable(true);
        initLeftPanel();
        pane.setLeftComponent(d_leftPanel);
        d_leftPanel.setMinimumSize(new Dimension(200,d_leftPanel.getMinimumSize().height));
        initRightPanel();
        pane.setRightComponent(d_rightPanel);
        d_rightPanel.setMinimumSize(new Dimension(770,d_rightPanel.getMinimumSize().height));
        
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
       d_leftPanel.setBackground(java.awt.Color.BLUE);
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
        
        newImg = new JButton();
        newImg.setIcon(i);
        newImg.setBackground(java.awt.Color.white);
        newImg.setBounds(180, 10, 128, 128);
        
        print = new JButton();
        print.setIcon(p);
        print.setBackground(java.awt.Color.white);
        print.setBounds(360, 10, 128, 128);
        
        help = new JButton();
        help.setIcon(h);
        help.setBackground(java.awt.Color.white);
        help.setBounds(540, 10, 128, 128);
        
        atras = new JButton();
        atras.setIcon(r);
        atras.setBackground(java.awt.Color.white);
        atras.setBounds(720, 10, 128, 128);
        
        exit = new JButton();
        exit.setIcon(s);
        exit.setBackground(java.awt.Color.white);
        exit.setBounds(900, 10, 128, 128);
        
        d_verticalPanel.add(analizar);
        d_verticalPanel.add(newImg);
        d_verticalPanel.add(print);
        d_verticalPanel.add(help);
        d_verticalPanel.add(atras);
        d_verticalPanel.add(exit);
    }

    
}
