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
 * @author armellekieffer
 */
@Named
@SessionScoped
public class DatatypeController implements Serializable{
    private Datatype datatype;
    private static List<Datatype> datatypes = null; 
    private DatatypeDAO datatypeDAO;
    
    public DatatypeController() {
        datatypeDAO = new DatatypeDAO();
        datatype = new Datatype();
        ListeDesDatatypes();
    }

    public void ListeDesDatatypes() {
        if (datatypes == null) setDatatypes(datatypeDAO.getDatatypes());
    }
    
    public void ajouteDatatype() {
        datatype.setIdDt(datatypeDAO.ajouteDatatype(datatype));
        datatypes.add(datatype);
        datatype = new Datatype();
    }
    
    public Datatype getDatatype() {
        return datatype;
    }

    public void setDatatype(Datatype datatype) {
        this.datatype = datatype;
    }

    public List<Datatype> getDatatypes() {
        return datatypes;
    }

    public void setDatatypes(List<Datatype> datatypes) {
        DatatypeController.datatypes = datatypes;
    }
}
