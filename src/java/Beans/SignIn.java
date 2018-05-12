/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidadaes.Grupo;
import Entidadaes.Localidad;
import Entidadaes.Usuario;

import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sam
 */
@Named(value = "signIn")
@RequestScoped
public class SignIn {
        
    private Usuario user;
    private String verify; 
    private Localidad loc;
    
    @Inject
    ControlAutorizacion ctrl;
    
 /*   @PersistenceContext(unitName = "TareaScouts2PU")
    private EntityManager em;
  */
    public List<Grupo> groupList(){
        /*Query q;
        q = em.createQuery("SELECT g FROM Grupo g");
        List<Grupo> res;
        res = q.getResultList();
        return res;*/
        
        return null;
    }
    
 
    public void setVerify(String pass){
        this.verify = pass;
    }
    
    public String getVerify(){
        return this.verify;
    }
    
    public void setLocalidad(String s){
        this.loc.setNombre(s);
    }
    public String getLocalidad(){
        return this.loc.getNombre();
    }
    
    public void setProvincia(String s){
        this.loc.setProvincia(s);
    }
    public String getProvincia(){
        return this.loc.getProvincia();
    }
    
    public void setPostal(String s){
        this.loc.setCodigo_postal(new Integer(s));
    }
    public String getPostal(){
        return this.loc.getCodigo_postal().toString();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public String autenticar(){
    
     //   if(em.find(Usuario.class, this.user.getAlias()) != null){
          if(false){
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, 
                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                           "El alias ya esta en uso. Elija otro para continuar.", 
                           "El alias ya esta en uso. Elija otro para continuar.")
           );
           return null; 
        }
        
        if(!this.user.getContraseña().equals(this.verify)){
             FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, 
                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                           "Ambas contraseñas no coinciden.", 
                           "mbas contraseñas no coinciden.")
           );
           return null; 
        }
        
        this.user.setFecha_ingreso(new Date());
        this.user.setReside_en(loc);
        this.ctrl.setUsuario(this.user);
        return null;
    }
    
    /**
     * Creates a new instance of SignIn
     */
    public SignIn(){
        this.user = new Usuario();
        this.verify = "";
        this.loc = new Localidad();
        this.loc.setCodigo_postal(10000);
    }
    
}
