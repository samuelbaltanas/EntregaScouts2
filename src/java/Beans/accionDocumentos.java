/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


/**
 *
 * @author sam
 */
@Named(value = "accionDocumentos")
@RequestScoped
public class accionDocumentos implements Serializable {
    
    @Inject
    ControlAutorizacion ctr;  

    /**
     * Creates a new instance of accionDocumentos
     */
    public accionDocumentos() {
        
    }

    
    public String documentos(){
        if (!ctr.esEducando()) {
            return "documentacion.xhtml";
        } else {
            return "user_docs.xhtml";
        }
    }
    
}
