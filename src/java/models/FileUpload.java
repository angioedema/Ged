package models;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Piotr
 */
@ManagedBean(name = "fileUpload")
@SessionScoped
public class FileUpload implements Serializable {
    Documents doc = new Documents();
  
    public void handleFileUpload(FileUploadEvent event) {  
	System.err.println("handleFileUpload");
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
	doc.setChemin(event.getFile().getFileName() + ".mp3");
	doc.setTaille(String.valueOf(event.getFile().getSize()));
	doc.setFormatDoc("mp3");
    } 
    
    
}  