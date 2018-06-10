/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Farmacia;
import com.inso.model.Medico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eva y Alba
 */
@Stateless
public class MedicoFacade extends OwnEntityManager<Medico> implements MedicoFacadeLocal {


    @Override
    public void create(Medico m) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().persist(m);
        tx.commit();
    }
    
    @Override
    public void remove(Medico m) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().remove(getEntityManager().merge(m));
        tx.commit();
    }
    
    @Override
    public void edit(Medico m) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().merge(m);
        tx.commit();
    }
    
    @Override
    public void removeByDNI(String dni) {
        try {
            TypedQuery<Medico> query = getEntityManager().createNamedQuery("Medico.findByDNI", Medico.class);
            query.setParameter("dni", dni);
            Medico result = query.getSingleResult();
            remove(result);
        } catch (Exception e) {
            
        }
    }

    @Override
    public Medico findByUsernameAndPass(String user, String pass) {
        String consulta;
        Medico medico = null;
        try {
            TypedQuery<Medico> query = getEntityManager().createNamedQuery("Medico.findByUsernameAndPass", Medico.class);
            query.setParameter("dni", user);
            query.setParameter("pass", pass);
            List<Medico> listaMedicos = query.getResultList();
            
            if(!listaMedicos.isEmpty()){
                medico = listaMedicos.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return medico;
    }

    @Override
    public Medico findByDNI(String dni) {
        String consulta;
        Medico medico = null;
        try {
            TypedQuery<Medico> query = getEntityManager().createNamedQuery("Medico.findByDNI", Medico.class);
            query.setParameter("dni", dni);
            List<Medico> listaMedicos = query.getResultList();
            
            if(!listaMedicos.isEmpty()){
                medico = listaMedicos.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return medico;
    }
    
}
