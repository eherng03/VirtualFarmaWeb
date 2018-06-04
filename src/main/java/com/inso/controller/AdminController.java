/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import java.io.IOException;
import java.io.Serializable;
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
    
    
    public void verifySesion() throws IOException{
        String admin = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(admin == null || "".equals(admin)){
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../public/errorPermisos.xhtml");
        }
    }
    
    
}
