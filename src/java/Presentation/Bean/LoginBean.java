package Presentation.Bean;

import DataAccess.DAO.UserDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private final UserDAO query = new UserDAO();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() {
        if (query.loginControl(username, password)) {
            return "home.xhtml?faces-redirect=true";
        }

        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " ", "Email o contraseña erronea"));
        return "";
    }
}
