/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import scb.io.SCBPersistenciaException;
import scb.io.SCBPersistenciaSQL;
import scb.ui.Main;

/**
 *
 * @author Erickson
 */
public class Util {
    
    
    private SCBFacade facade;
    private SCBPersistenciaSQL  persistencia;
    
    public Util(){
        facade = SCBFacade.getInstance();
        persistencia = new SCBPersistenciaSQL();
    }
    
    
    public static Date stringToDate(String date) throws ParseException{
            DateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAux;
            dataAux = new Date(forma.parse(date).getTime());
            return dataAux;
	}
    
    public static String dateToString(Date date){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    return dateFormat.format(date);
    }

    
    public static FileFilter getFilter() {  
        FileFilter ff = new FileFilter() {  
  
            public boolean accept(File f) {  
                if (f.isDirectory()) {  
                    return true;  
                }  
  
                String extension = getExtension(f);  
                if (extension != null) {  
                    if (extension.equals(".jpeg")  
                            || extension.equals(".jpg")  
                            || extension.equals(".png")) {  
                        return true;  
                    } else {  
                        return false;  
                    }  
                }  
                return false;  
            }  
            
 
 
  
            @Override  
            public String getDescription() {  
                return "Arquivos de Imagens (.jpg, .jpeg, .png)";  
            }  
        };  
  
        return ff;  
    }  

    public static String getExtension(File f) {  
                String ext = null;  
                String s = f.getName();  
                int i = s.lastIndexOf('.');  

                if (i > 0 && i < s.length() - 1) {  
                    ext = s.substring(i).toLowerCase();  
                }  
                return ext; 
}
    
 
    
    public static Image redimensionar(File file, int width, int heigth) { 
        try {
            BufferedImage imagem = ImageIO.read(file);  
            return imagem.getScaledInstance(width, heigth, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void copyfile(BufferedImage srFile, String dtFile) {  
        try {
            BufferedImage image = null; 
            image = new BufferedImage(130, 140, BufferedImage.TYPE_INT_RGB); 
            Graphics g = image.getGraphics();  
            try{
                g.drawImage(srFile.getScaledInstance(130,140,10000), 0, 0, null);  
            }finally{
                g.dispose();
            } 
            ImageIO.write(image,"PNG",new File(dtFile + ".png"));
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

    }  
    
    public static String dirImageSave(String pasta, String info){
        return System.getProperty("user.dir") + "/src/scb/data/images/"+pasta+"/"+info;
        //return Util.class.getResourceAsStream("/scb/data/images/"+pasta+"/"+info);
    }

    public static String dirImageLoad(String pasta, String info){
        return System.getProperty("user.dir") + "/src/scb/data/images/"+pasta+"/"+info+".png";
        //return Util.class.getResourceAsStream("/scb/data/images/"+pasta+"/"+info+".png");
    }    
    
    public static InputStream getDirCad(){
        return Util.class.getResourceAsStream("/scb/data/images/defaultCadastre.jpg");
        //return System.getProperty("user.dir") + "/src/scb/data/images/defaultCadastre.jpg";
    }
    
  /*public static String getDirCad(){
        return System.getProperty("user.dir") + "/src/scb/data/images/defaultCadastre.jpg";
  } */  
  
    public static InputStream getDirLiv(){
        return Util.class.getResourceAsStream("/scb/data/images/defaultBook.jpg");
    }
    
    public void verificarCadastro(Cadastro c) throws SCBFacadeException, SCBPersistenciaException{
        if(!(persistencia.getCadastro(c.getMatricula()).isEmpty())){
            throw new SCBFacadeException("Matricula já cadastrada no sistema.");
        }
    }
    
    public void verificarLivro(Livro l) throws SCBFacadeException, SCBPersistenciaException{
        if(!(persistencia.getLivro(l.getRegistro()).isEmpty())){
            throw new SCBFacadeException("Livro já cadastrado no sistema.");
        }  
    }    

    
    public void verificarUsuario(Usuario u) throws SCBFacadeException, SCBPersistenciaException{
          if(!(persistencia.getUsuario(u.getUsuario()).isEmpty())){
              throw new SCBFacadeException("Usuário já cadastrado no sistema.");
           } 
    } 
    
    public void verificarEmprestimo(Emprestimo e) throws SCBFacadeException, SCBPersistenciaException{
          if(!(persistencia.getEmprestimo(e.getId()).isEmpty())){
              throw new SCBFacadeException("Empréstimo já cadastrado no sistema.");
           } 
    }      
    
    public static Point gerarPosicao(Dimension i){
        Dimension d = Main.desktop.getSize();
        Point dimension; 
        return dimension = new Point(((d.width - i.width) / 2),((d.height - i.height) / 2));
    }
    
    public static List<Emprestimo> EmprestimosFinalizados(List<Emprestimo> emprestimos){
        List<Emprestimo> aux = new ArrayList<Emprestimo>();
        for(Emprestimo e : emprestimos){
            if(e.getEntrega()){
                aux.add(e);
            }
        }
        return aux;
    }
    
    public static List<Emprestimo> EmprestimosNaoFinalizados(List<Emprestimo> emprestimos){
        List<Emprestimo> aux = new ArrayList<Emprestimo>();
        for(Emprestimo e : emprestimos){
            if(!(e.getEntrega())){
                aux.add(e);
            }
        }
        return aux;
    }    
    
    
    public static List<Emprestimo> EmprestimosNaoFinalizadosAtrasados(List<Emprestimo> emprestimos){
        List<Emprestimo> aux = new ArrayList<Emprestimo>();
        for(Emprestimo e : emprestimos){
            if(!(e.getEntrega()) && e.getDataDevolucao().after(new Date())){
                aux.add(e);
            }
        }
        return aux;
    }        
}
    

  


    
    
