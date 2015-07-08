/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static javax.print.attribute.Size2DSyntax.MM;

/**
 *
 * @author fabian
 */
public class ImprimirReporte {
    private String nombre;
    private String edad;
    private String sexo;
    private String fecha;
    private String motivo;
    private String descripcion;
    public void ImprimirReporte() throws DocumentException, FileNotFoundException, BadElementException, IOException{
        
        Document document = new Document(PageSize.LETTER.rotate());        
        Image imagen = Image.getInstance("src/Imagen/dental.jpg"); 
        imagen.setAbsolutePosition(250f, 250f);
        imagen.setAlignment(Element.ALIGN_CENTER);
        
        String p1 = "Paciente: " + getNombre();
        String p2 = "Edad: "+getEdad()+ "Sexo: "+getSexo();
        String p3 = "Fecha: "+getFecha();
        String p4 = "Motivo Consulta: "+getMotivo();
        String p5 = "Descrpcion: "+getDescripcion();
        
        PdfWriter.getInstance(document, new FileOutputStream("recibo.pdf"));
        document.open();
        document.add(imagen);
        document.add(new Paragraph(p1));
        document.add(new Paragraph(p2));
        document.add(new Paragraph(p3));
        document.add(new Paragraph(p4));
        document.add(new Paragraph(p5));
        
        PdfPTable table = new PdfPTable(3);  
        
        table.addCell("Clase Esqueletal");
        table.addCell("Norma");
        table.addCell("Inicial");
        table.addCell("Convexidad Facial");
        table.addCell("+2+-2mm");
        table.addCell("");
        
        table.addCell("Maxilar Inferior");
        table.addCell("");
        table.addCell("");
        table.addCell("Eje Facial");
        table.addCell("90°+-3°");
        table.addCell("");
        table.addCell("Prof. Facial");
        table.addCell("87°+-3°");
        table.addCell("");
        table.addCell("Ang.Plano mandibular");
        table.addCell("26°+-4°");
        table.addCell("");
        table.addCell("Altura Facial Inferior");
        table.addCell("47°+-4°");
        table.addCell("");
        table.addCell("Arco Mandibular");
        table.addCell("26°+-4°");
        table.addCell("");
            
        table.addCell("Maxilar Superior");
        table.addCell("");
        table.addCell("");
        table.addCell("Profundidad Maxilar");
        table.addCell("90°+-3");
        table.addCell("");
        
        table.addCell("Dientes");
        table.addCell("");
        table.addCell("");
        table.addCell("A-Pg");
        table.addCell("+1+-2mm");
        table.addCell("");
        table.addCell("Plano Oclusal");
        table.addCell("+1+-1mm");
        table.addCell("");
        table.addCell("Plano Mandibular");
        table.addCell("90°+-5°");
        table.addCell("");
        table.addCell("Plano Bana");
        table.addCell("E.Fac -5°");
        table.addCell("");
        
        table.addCell("Estetica");
        table.addCell("");
        table.addCell("");
        table.addCell("Exposicion del l");
        table.addCell("+2.5 a 3mm");
        table.addCell("");
        table.addCell("Lab. Inf. Plano E");
        table.addCell("-2+-2mm");
        table.addCell("");
        table.addCell("Angulo masofacial inferior");
        table.addCell("85°+-5");
        table.addCell("");
        
        document.add(table);
            
        document.close();
        System.out.println("Entre");
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}



