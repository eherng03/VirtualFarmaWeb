/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Pacientes;
import com.inso.model.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eva y Alba
 */
@Stateless
public class ProductosFacade extends OwnEntityManager<Productos> implements ProductosFacadeLocal {


    @Override
    public void removeByCIFNombre(String cif, String nombre) {
        try {
            TypedQuery<Productos> query = getEntityManager().createNamedQuery("Productos.removeByCIFNombre", Productos.class);
            query.setParameter("cif", cif);
            query.setParameter("nombre", nombre);
            query.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Productos findByCIFNombre(String cif, String nombre) {
        try {
            TypedQuery<Productos> query = getEntityManager().createNamedQuery("Productos.findByCIFNombre", Productos.class);
            query.setParameter("cif", cif);
            query.setParameter("nombre", nombre);
            
            return query.getSingleResult();
            
        } catch (Exception e) {
            throw e;
        }
    }
}
