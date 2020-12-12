/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_XML;

import Classes_NF.NotaFiscal;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafaella.almeida.ad.OUROLAC
 */
public class CriarXML {
        
    public String caminho = "C:\\Users\\rafaella.almeida.ad.OUROLAC\\Desktop\\Enviado_NotaFiscal.xml";
    
    public String transformeEmStringXml(Object obj){

        XStream xstream = new XStream(new DomDriver());
        //xstream.alias("NotaFiscal", NotaFiscal.class); 

        String xml = xstream.toXML(obj);
        return xml;
    }

    public void gerarArquivo(String xml){
        PrintWriter print = null;
        
        try{
            File file = new File(caminho);
            print = new PrintWriter(file);
            print.write(xml);
            print.flush();
            print.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(CriarXML.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            print.close();
        }
    }
}