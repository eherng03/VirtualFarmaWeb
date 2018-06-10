/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.model.Productos;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Eva y Alba
 */

@FacesConverter("productoConverter")

@Named
@RequestScoped
public class ProductoConverter implements Converter, Serializable{
    @Inject
    private FarmaciaController farmaciaController;
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            for(Productos producto : farmaciaController.getDualProductos().getSource()){
                if(producto.getProductosPK().getNombre().equals(value)){
                    return producto;
                }
            }
            for(Productos producto : farmaciaController.getDualProductos().getTarget()){
                if(producto.getProductosPK().getNombre().equals(value)){
                    return producto;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Productos) object).getProductosPK().getNombre());
        }
        else {
            return null;
        }
    }   
}
