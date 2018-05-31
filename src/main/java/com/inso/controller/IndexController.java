/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.EJB.FarmaciaFacadeLocal;
import com.inso.EJB.PacientesFacade;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.model.Farmacia;
import com.inso.model.Pacientes;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
/**
 *
 * @author Eva
 */
@ManagedBean(name = "indexController", eager = true)
@ViewScoped
public class IndexController implements Serializable{
    
    //Todo esto no va a ir aqui, va a ir en la pantalla que añada farmacias
    //TODO buscar como crear patron fachada
    @EJB
    private PacientesFacadeLocal pacienteEJB;       //Clase que me permite acceder al patron fachada
    private Pacientes paciente;
    
    @EJB
    private FarmaciaFacadeLocal farmaciaEJB;       //Clase que me permite acceder al patron fachada
    private Farmacia farmacia;
    
    private String username;
    private String password;
    private String usertype;

   
    
    @PostConstruct
    public void init(){
        paciente = new Pacientes();
        pacienteEJB = new PacientesFacade();
        username = "";
        password = "";
        usertype = "paciente";
    }
    
  
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password= password;
    }
    
     public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
    public String login() {
        String direction = null;
        try {
            if("paciente".equals(this.usertype)){
                this.paciente = pacienteEJB.findByUsernameAndPass(username, password);
              
                //Añado el paciente como usuario de esta sesion para los menus
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", paciente);
                if(this.paciente == null){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas."));
                }else{
                     direction = "/paciente/ventanaPaciente";
                     return direction;
                }
            }else if(this.usertype == "farmacia"){
                
                this.farmacia = farmaciaEJB.findByUsernameAndPass(username, password);
                
                //Añado el paciente como usuario de esta sesion para los menus
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", farmacia);
                if(this.paciente == null){
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas."));
                }else{
                    direction = "/farmacia/ventanaFarmacia?faces-redirect=true";
                }
            }else if(this.usertype == "medico"){
                //TODO medico
            }
            
        } catch (Exception e) {
            throw e;
        }
        
        return direction;
        
        
        
        /*FacesMessage message = null;
        boolean loggedIn = false;
         
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            //Buscar en la bbdd
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        //Metodo de buscar usuario
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
*/
    }     
    
}
