/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eva y Alba
 */
@Stateless
public class ProductosFacade extends OwnEntityManager<Productos> implements ProductosFacadeLocal {

    @Override
    public void removeByCIFNombre(String cif, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productos findByCIFNombre(String cif, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Productos> findByNombre(String nombre) {
         try {
            TypedQuery<Productos> query = getEntityManager().createNamedQuery("Productos.findByNombre", Productos.class);
            query.setParameter("nombre", nombre);
            List<Productos> productos = query.getResultList();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public void create(Productos p) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().persist(p);
        tx.commit();
    }
  
}
