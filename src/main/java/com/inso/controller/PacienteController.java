/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.EJB.FarmaciaFacadeLocal;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.EJB.ProductosFacadeLocal;
import com.inso.model.Farmacia;
import com.inso.model.Pacientes;
import com.inso.model.Productos;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

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
    
    @EJB
    private ProductosFacadeLocal productosEJB;
    
    private List<Farmacia> farmaciasList;
    private List<Farmacia> farmaciasProductoList;
    
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
    
    public List<Farmacia> getFarmaciasProductoList() {
        return farmaciasProductoList;
    }

    public void setFarmaciasProductoList(List<Farmacia> farmaciasProductoList) {
        this.farmaciasProductoList = farmaciasProductoList;
    }
       
    public void renderDisponibilidad(String nombreMedicamento){
        List<Productos> productos = productosEJB.findByNombre(nombreMedicamento);
        farmaciasProductoList = new ArrayList<>();
        for(Productos producto : productos){
            farmaciasProductoList.add(producto.getFarmacia());
        }
        RequestContext.getCurrentInstance().execute("PF('farmaciasProductoDialog').show();");
    }

}