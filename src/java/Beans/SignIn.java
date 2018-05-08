/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidadaes.Usuario;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sam
 */
@Named(value = "signIn")
@RequestScoped
public class SignIn {
    
    private Usuario user = new Usuario();
    
    @Inject
    ControlAutorizacion ctrl;
    
    @PersistenceContext(unitName = "TareaScouts2PU")
    private EntityManager em;
    
    public void setAlias(String acc){
        this.user.setAlias(acc);
    }
    
    public String getAlias(){
        return this.user.getAlias();
    }
    
    public void setNombre(String acc){
        this.user.setNombre(acc);
    }
    
    public String getNombre(){
        return this.user.getNombre();
    }
    
    public void setApellido(String acc){
        this.user.setApellidos(acc);
    }
    
    public String getApellido(){
        return this.user.getApellidos();
    }
    
     public void setDni(String acc){
        this.user.setDni(acc);
    }
    
    public String getDni(){
        return this.user.getDni();
    }
    
    public void setEmail(String acc){
        this.user.setEmail(acc);
    }
    
    public String getEmail(){
        return this.user.getEmail();
    }
    
    public void setDireccion(String acc){
        this.user.setDireccion(acc);
    }
    
    public String getDireccion(){
        return this.user.getDireccion();
    }
    
    public void setPhone(String acc){
        this.user.setTelefono(acc);
    }
    
    public String getPhone(){
        return this.user.getTelefono();
    }
    
    public Date getBirthdate(){
        return this.user.getFecha_nacimiento();
    }
    
    public void setBirthdate(Date d){
        this.user.setFecha_nacimiento(d);
    }
    
    public String autenticar(){
    
        if(em.find(Usuario.class, this.user.getAlias()) != null){
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, 
                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                           "El alias ya esta en uso. Elija otro para continuar.", 
                           "El alias ya esta en uso. Elija otro para continuar.")
           );
           return null; 
        }
        
        
        
        return null;
    }
    
    /**
     * Creates a new instance of SignIn
     */
    public SignIn() {
    }
    
}
