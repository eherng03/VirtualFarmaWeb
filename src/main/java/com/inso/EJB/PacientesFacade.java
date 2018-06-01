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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eva
 */
@Stateless
public class PacientesFacade extends AbstractFacade<Pacientes> implements PacientesFacadeLocal {

    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ViartualFarma_Persistence_Unit");
    private EntityManager em = emfactory.createEntityManager();

    @Override
    public void edit(Pacientes entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
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
            consulta = "SELECT p FROM Pacientes p WHERE p.dni = :user AND p.password = :pass";
            Query query = this.em.createQuery(consulta);
            query.setParameter("user", user);
            query.setParameter("pass", pass);
            query.executeUpdate();
            List<Pacientes> listaPacientes = query.getResultList();
            
            if(!listaPacientes.isEmpty()){
                paciente = listaPacientes.get(0);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return paciente;
       
    }

    @Override
    public void removeByDNI(String dni) {
        String consulta;
        try {
            consulta = "DELETE p FROM Pacientes p WHERE p.dni = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, dni);
                     
        } catch (Exception e) {
            
        }
    }

    @Override
    public Pacientes findByDNI(String dni) {
        String consulta;
        Pacientes paciente = null;
        try {
            consulta = "SELECT p FROM Pacientes p WHERE p.dni = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, dni);
            List<Pacientes> listaPacientes = query.getResultList();
            
            if(!listaPacientes.isEmpty()){
                paciente = listaPacientes.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return paciente;
    }
    
}
