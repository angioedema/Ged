/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Katia
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    private Users user;
    private static List<Users> users = null;
    private UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
        user = new Users(null, null);
        ListeDesUsers();
    }

    public void ListeDesUsers() {
        if (users == null) {
            setUsers(userDAO.getUsers());
        }
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        UserController.users = users;
    }
    
    public String checkUser() {       
        for (Users u: users) {
            //si le login passe en parametre est present dans la liste
            //recuperee a partir de la base de donnees
            if (u.getLogin().equals(this.user.getLogin()))  {
                //si le mot de passe renseigne est correct
                if (u.getPassword().equals(this.user.getPassword())) {
                    return "main.xhtml";
                }
                //si le mot de passe renseigne n'est pas correct
                else    {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "INFO", "INFO  "));
                }
            }
        }
        return "index.html";
    } 
}
