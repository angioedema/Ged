/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Katia
 */
@Named(value = "selectGenre")
@SessionScoped
public class SelectGenre implements Serializable {
    private String valeur;
    private List<Documents> docs;
    private final DocumentsDAO docDAO;

    public SelectGenre() {
	this.docDAO = new DocumentsDAO();
    }
    
    public void loadListeGenre()  {
	docs = docDAO.getGenre(this.valeur);
    }

    public String getValeur() {
	return valeur;
    }

    public List<Documents> getDocs() {
	return docs;
    }

    public void setDocs(List<Documents> docs) {
	this.docs = docs;
    }

    public void setValeur(String valeur) {
	this.valeur = valeur;
    }
    
}
