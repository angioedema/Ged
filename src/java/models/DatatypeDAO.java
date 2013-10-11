/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


@Named(value = "datatypeDAO")
@SessionScoped
public class DatatypeDAO implements Serializable {
      Session session = null;

    public DatatypeDAO() {
    }
    
    public List getDatatypes() {
        List<Datatype> datatypes = null;
        try {
            session = utils.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Datatype");
            datatypes = (List<Datatype>) q.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datatypes;
    } 
    
    
     public Integer ajouteDatatype(Datatype datatype) {
        Integer datatypeId = null;
        try {
            session = utils.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            datatypeId = (Integer) session.save(datatype); 
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datatypeId;
    } 
    
}
