/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Farmacia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eva
 */
@Stateless
public class FarmaciaFacade extends AbstractFacade<Farmacia> implements FarmaciaFacadeLocal {

    @PersistenceContext(unitName = "ViartualFarma_Persistence_Unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FarmaciaFacade() {
        super(Farmacia.class);
    }
    
}
