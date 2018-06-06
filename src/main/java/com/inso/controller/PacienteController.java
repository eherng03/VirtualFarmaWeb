/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.EJB.FarmaciaFacadeLocal;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.model.Farmacia;
import com.inso.model.Pacientes;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Eva y Alba
 */
@ManagedBean(name = "pacienteController", eager = true)
@ViewScoped
public class PacienteController implements Serializable{
    @EJB
    private PacientesFacadeLocal pacienteEJB;       //Clase que me permite acceder al patron fachada
    private Pacientes paciente;
    @EJB
    private FarmaciaFacadeLocal farmaciaEJB;
    private List<Farmacia> farmaciasList;
    private boolean showRecetas;
    private boolean showFarmacias;
    private boolean showPerfil;
    
    @PostConstruct
    public void init(){
        paciente = (Pacientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        
        if(paciente == null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/public/errorPermisos.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        showRecetas = true;
    }
    
    public String logOut(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);
        return "/index?faces-redirect=true";
    }

    public List<Farmacia> getFarmaciasList() {   
        farmaciasList = farmaciaEJB.findAll();
        return farmaciasList;
    }

    public void setFarmaciasList(List<Farmacia> farmaciasList) {
        this.farmaciasList = farmaciasList;
    }
    
    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
    
    public boolean isShowRecetas() {
        return showRecetas;
    }

    public void setShowRecetas(boolean showRecetas) {
        this.showRecetas = showRecetas;
    }
    
    public boolean isShowFarmacias() {
        return showFarmacias;
    }

    public void setShowFarmacias(boolean showFarmacias) {
        this.showFarmacias = showFarmacias;
    }
    
    public boolean isShowPerfil() {
        return showPerfil;
    }

    public void setShowPerfil(boolean showPerfil) {
        this.showPerfil = showPerfil;
    }
    
    public void renderRecetas(){
        showRecetas = true;
        showFarmacias = false;
        showPerfil = false;
    }
    
    public void renderFarmacias(){
        showRecetas = false;
        showFarmacias = true;
        showPerfil = false;
    }
    
    public void renderPerfil(){
        showRecetas = false;
        showFarmacias = false;
        showPerfil = true;
    }
    
    public void darBaja(){
        pacienteEJB.remove(paciente);
    }
}