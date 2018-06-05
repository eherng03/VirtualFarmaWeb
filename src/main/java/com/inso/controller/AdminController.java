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
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.model.Farmacia;
import com.inso.model.Medico;
import com.inso.model.Pacientes;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Eva
 */
@ManagedBean(name = "adminController", eager = true)
@ViewScoped
public class AdminController implements Serializable{
        
    @EJB
    private FarmaciaFacadeLocal farmaciaEJB;       //Clase que me permite acceder al patron fachada
    private Farmacia farmacia;
    
    @EJB
    private MedicoFacadeLocal medicoEJB;       //Clase que me permite acceder al patron fachada
    private Medico  medico;
    
    private List<Farmacia> farmaciasList;
    
    private boolean farmaciasVisible;
    private boolean medicosVisible;

    public boolean isFarmaciasVisible() {
        return farmaciasVisible;
    }

    public void setFarmaciasVisible(boolean farmaciasVisible) {
        this.farmaciasVisible = farmaciasVisible;
    }

    public boolean isMedicosVisible() {
        return medicosVisible;
    }

    public void setMedicosVisible(boolean medicosVisible) {
        this.medicosVisible = medicosVisible;
    }

    public List<Farmacia> getFarmaciasList() {
        return farmaciasList;
    }

    public void setFarmaciasList(List<Farmacia> farmaciasList) {
        this.farmaciasList = farmaciasList;
    }
    
    @PostConstruct
    public void init(){
        farmaciaEJB = new FarmaciaFacade();
        medicoEJB = new MedicoFacade();
        farmaciasList = farmaciaEJB.findAll();
        farmaciasVisible = true;
        medicosVisible = false;
    }
    
    
    
    public void verifySesion() throws IOException{
        String admin = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(admin == null || "".equals(admin)){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/public/errorPermisos.xhtml");
        }
    }
    
    public String logOut(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);
        return "/index?faces-redirect=true";
    }
    
    public void showMedicos(){
        medicosVisible = true;
        farmaciasVisible = false;
    }
    
    public void showFarmacias(){
        medicosVisible = true;
        farmaciasVisible = false;
    }
    
    public String delete(Farmacia farmacia){
        //TODO estas seguro?
        farmaciaEJB.remove(farmacia);
        return "/private/admin/ventanaAdmin?faces-redirect=true";
    }
}
