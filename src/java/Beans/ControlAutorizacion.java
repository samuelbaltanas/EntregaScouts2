package Beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Entidadaes.Rol;
import Entidadaes.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author francis
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        // Implementar el método
        // Devuelve la página Home dependiendo del rol del usuario
        // Si no hay usuario debe devolver la página de login
        // Si el usuario es el administrador debe devolver la página admin.xhtml
        // Si el usuario es un usuario normal debe devolver la página normal.xhtml
        String page = null;
        if(this.usuario == null)
            return null;
        
        switch (this.usuario.getRol().getId()) {
                case EDUCANDO:
                    page = "normal.xhtml";
                    break;
                case SCOUTER:
                    page = "admin.xhtml";
                    break;
                default:
                    break;
            }
        
        return page;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
