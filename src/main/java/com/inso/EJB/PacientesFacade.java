/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Pacientes;
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
public class PacientesFacade extends AbstractFacade<Pacientes> implements PacientesFacadeLocal {

    @PersistenceContext(unitName = "ViartualFarma_Persistence_Unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacientesFacade() {
        super(Pacientes.class);
    }

    @Override
    public Pacientes findByUsernameAndPass(String user, String pass) {
        String consulta;
        Pacientes paciente = null;
        try {
            consulta = "SELECT p FROM Pacientes p WHERE p.dni = ?1 AND p.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, user);
            query.setParameter(2, pass);
            List<Pacientes> listaPacientes = query.getResultList();
            
            if(!listaPacientes.isEmpty()){
                paciente = listaPacientes.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return paciente;
       
    }
    
}
