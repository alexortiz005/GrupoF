/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Usuario;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author andrew
 */
public class UserDAO {

    public EntityManagerFactory emf ;
    EntityManager em;
    String unidadPersistencia="TerminalPU";
    
    public UserDAO(){
        emf = Persistence.createEntityManagerFactory(unidadPersistencia);
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public boolean loginControl(String username, String password) {
        
        Usuario user = null;  
        String campoUser = "email";
        String campoPass = "contrase\u00f1a";
                  
        try {
           
             user = em.createNamedQuery("Usuario.control", Usuario.class)
                     .setParameter(campoUser, username)
                     .setParameter(campoPass, password)
                     .getSingleResult();
            if (user != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
