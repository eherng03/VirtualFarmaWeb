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
import com.inso.Utils.DataChecks;
import com.inso.model.Farmacia;
import com.inso.model.Medico;
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
@ManagedBean(name = "registerController", eager = true)
@ViewScoped
public class RegisterController implements Serializable{
    
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
    
    private String dniPaciente;
    private String nombrePaciente;
    private String ssPaciente;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getSsPaciente() {
        return ssPaciente;
    }

    public void setSsPaciente(String ssPaciente) {
        this.ssPaciente = ssPaciente;
    }

   
    
    @PostConstruct
    public void init(){
        paciente = new Pacientes();
        farmacia = new Farmacia();
        medico = new Medico();
        pacienteEJB = new PacientesFacade();
        farmaciaEJB = new FarmaciaFacade();
        medicoEJB = new MedicoFacade();
        dniPaciente = "";
        nombrePaciente = "";
        ssPaciente = "";
        password = "";
    }
    

    
    public String registerPaciente() {
        String direccion = "";
        if(checkParametersPaciente()){
           
        }
        
        return direccion;
  

    }     

    private boolean checkParametersPaciente() {
        DataChecks ch = DataChecks.getInstance();
        if(!ch.checkDNI(dniPaciente)){
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El DNI introducido no es válido."));
            return false;
        }
        if(!ch.checkNumeroSS(ssPaciente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El número de la Seguridad Social introducido no es válido."));
            return false;
        }
        if(!ch.checkCadenaLetrasNumerosOEspacios(password)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "La contraseñasolo puede contener letras o números."));
            return false;
        }
        return true;
    }
}
