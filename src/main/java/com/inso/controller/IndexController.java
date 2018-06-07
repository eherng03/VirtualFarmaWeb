/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.EJB.FarmaciaFacade;
import com.inso.EJB.FarmaciaFacadeLocal;
import com.inso.EJB.MedicoFacade;
import com.inso.EJB.MedicoFacadeLocal;
import com.inso.EJB.PacientesFacade;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.model.Farmacia;
import com.inso.model.Medico;
import com.inso.model.Pacientes;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
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
    
    @EJB
    private MedicoFacadeLocal medicoEJB;       //Clase que me permite acceder al patron fachada
    private Medico  medico;
    
    private String username;
    private String password;
    private String usertype;

   
    
    @PostConstruct
    public void init(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);
        paciente = new Pacientes();
        farmacia = new Farmacia();
        medico = new Medico();
        pacienteEJB = new PacientesFacade();
        farmaciaEJB = new FarmaciaFacade();
        medicoEJB = new MedicoFacade();
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
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            //ADMIN SESION
            if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
                direction = "/private/admin/ventanaAdmin?faces-redirect=true";
                context.getExternalContext().getSessionMap().put("user", "admin");
                return direction;
            } else {
                //PACIENTE SESION
                if("paciente".equals(this.usertype)){
                    this.paciente = pacienteEJB.findByUsernameAndPass(username, password);

                    //Añado el paciente como usuario de esta sesion para los menus
                    context.getExternalContext().getSessionMap().put("user", paciente);
                    if(this.paciente == null){
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas."));
                    }else{
                         direction = "/private/paciente/ventanaPaciente?faces-redirect=true";
                         return direction;
                    }
                //FARMACIA SESION
                }else if("farmacia".equals(this.usertype)){

                    this.farmacia = farmaciaEJB.findByUsernameAndPass(username, password);

                    //Añado el paciente como usuario de esta sesion para los menus
                    context.getExternalContext().getSessionMap().put("user", farmacia);
                    if(this.farmacia == null){
                         context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas."));
                    }else{
                        direction = "/private/farmacia/ventanaFarmacia?faces-redirect=true";
                    }
                }else if("medico".equals(this.usertype)){
                    this.medico = medicoEJB.findByUsernameAndPass(username, password);

                    //Añado el paciente como usuario de esta sesion para los menus
                    context.getExternalContext().getSessionMap().put("user", medico);
                    if(this.farmacia == null){
                         context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas."));
                    }else{
                        direction = "/private/medico/ventanaMedico?faces-redirect=true";
                    }
                }
            } 
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas."));
        }
        
        return direction;
        
    }     
    
}
