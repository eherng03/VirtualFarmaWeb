/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Farmacia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eva y Alba
 */
@Stateless
public class FarmaciaFacade extends OwnEntityManager<Farmacia> implements FarmaciaFacadeLocal {

    @Override
    public void create(Farmacia f) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().persist(f);
        tx.commit();
    }
    
    @Override
    public void remove(Farmacia farm) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().remove(getEntityManager().merge(farm));
        tx.commit();
    }
    
    @Override
    public void edit(Farmacia farm) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().merge(farm);
        tx.commit();
    }
    
    @Override
    public Farmacia findByUsernameAndPass(String user, String pass) {
         Farmacia farmacia = null;
        try {
            TypedQuery<Farmacia> query = getEntityManager().createNamedQuery("Farmacia.findByUsernameAndPass", Farmacia.class);
            query.setParameter("user", user);
            query.setParameter("pass", pass);
            List<Farmacia> listaFarmacias = query.getResultList();
            
            if(!listaFarmacias.isEmpty()){
                farmacia = listaFarmacias.get(0);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return farmacia;
    }

    @Override
    public Farmacia findByCIF(String cif) {
        Farmacia farmacia = null;
        try {
            TypedQuery<Farmacia> query = getEntityManager().createNamedQuery("Farmacia.findByCIF", Farmacia.class);
            query.setParameter("cif", cif);
            List<Farmacia> listaFarmacias = query.getResultList();
            
            if(!listaFarmacias.isEmpty()){
                farmacia = listaFarmacias.get(0);
            }
            
        } catch (Exception e) {
             throw e;
        }
        return farmacia;
    }
    
}
