/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author fabian
 */
public class Prueba extends JPanel {
   

    private int contPuntos = 0; //cuenta num puntos
    int ban = 1;
    private Point puntos[] = new Point[100000]; //Arreglo 10000 referencias
    private int x; 
    private int y;
    private int x2;
    private int y2;
    BufferedImage bmp;
    
    public Prueba(BufferedImage bmp){
        this.setSize(1024,600 );
        this.setVisible( true );
        this.bmp = bmp;
       
         addMouseMotionListener(
            new MouseMotionAdapter(){ //clase interna anonima
                public void mouseDragged(MouseEvent evento){
                    if(contPuntos < puntos.length){
                        puntos[contPuntos] = evento.getPoint();
                        contPuntos++;
                        repaint();
                    } //end if
                } //end mouseDragged
            } //end clase interna anonima
         ); //fin llamada addMouseMotionListener
         
         
    

  
         
    } //end constructor
   
    public void paintComponent(Graphics g){
        super.paintComponent(g); //borra el area de dibujo
        
        Dimension height = getSize();
        ImageIcon Img = new ImageIcon(bmp); 
        g.drawImage(Img.getImage(), 0, 0, height.width, height.height, this);
        
        //dibuja puntos en el arreglo
          for(int i=0; i<contPuntos; i++){
            g.fillOval(puntos[i].x, puntos[i].y, 4, 4);
        }
        
        
      
           // g.drawLine(getX(), getY(), getX2(), getY2());
            //g.fillOval(puntos[i].x, puntos[i].y, 4, 4)
          
           // System.out.println("Si estoy entrando"+ ban);       
         
            
        
       
    }
   
    //Establece GUI y registra manejador eventos

    
    
}
