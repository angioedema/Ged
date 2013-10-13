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

/**
 *
 * @author Katia
 */
@Named(value = "userDAO")
@SessionScoped
public class UserDAO implements Serializable {
      Session session = null;

    public UserDAO() {
    }
    
    public List getUsers() {
        List<Users> users = null;
        try {
            session = utils.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Users");
            users = (List<Users>) q.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    } 
}