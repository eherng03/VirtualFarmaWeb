/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Medico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eva
 */
@Stateless
public class MedicoFacade extends AbstractFacade<Medico> implements MedicoFacadeLocal {

    @PersistenceContext(unitName = "ViartualFarma_Persistence_Unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicoFacade() {
        super(Medico.class);
    }

    @Override
    public void removeByDNI(String dni) {
        String consulta;
        try {
            consulta = "DELETE m FROM Medico m WHERE m.dni = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, dni);
            
        } catch (Exception e) {
            
        }
    }

    @Override
    public Medico findByUsernameAndPass(String user, String pass) {
        String consulta;
        Medico medico = null;
        try {
            consulta = "SELECT m FROM Medicos m WHERE m.dni = ?1 AND m.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, user);
            query.setParameter(2, pass);
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
            consulta = "SELECT m FROM Medico m WHERE m.dni = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, dni);
            List<Medico> listaMedicos = query.getResultList();
            
            if(!listaMedicos.isEmpty()){
                medico = listaMedicos.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return medico;
    }
    
}
