/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author fabian
 */
public class Paint extends javax.swing.JPanel{
    public Paint() {
        this.setSize(300, 400); //se selecciona el tamaño del panel
    }

    public void paint(Graphics grafico) {
        super.paintComponents(grafico);
        Dimension height = getSize();
        ImageIcon Img = new ImageIcon(getClass().getResource("/Imagen/dental.jpg")); 
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, this);
        
       

        //setOpaque(false);
        
    }
    
}
