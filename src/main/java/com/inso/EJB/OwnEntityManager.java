/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Eva
 */
public class OwnEntityManager<T> extends AbstractFacade<T> {

    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ViartualFarma_Persistence_Unit");
    private EntityManager em = emfactory.createEntityManager();

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
