/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Pacientes;
import com.inso.model.Recetas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eva y Alba
 */
@Stateless
public class RecetasFacade extends AbstractFacade<Recetas> implements RecetasFacadeLocal {

    @PersistenceContext(unitName = "ViartualFarma_Persistence_Unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecetasFacade() {
        super(Recetas.class);
    }

    @Override
    public void removeIDs(String dniPaciente, String nombreMedicamento, String fecha) {
        String consulta;
        try {
            consulta = "DELETE r FROM Recetas r WHERE r.dNIPaciente = :dniPaciente AND r.nombreMedicamento = :nombreMedicamento AND r.fecha = :fecha";
            Query query = em.createQuery(consulta);
            query.setParameter("dniPaciente", dniPaciente);
            query.setParameter("nombreMedicamento", nombreMedicamento);
            query.setParameter("fecha", fecha);
        } catch (Exception e) {
            
        }
    }

    @Override
    public List<Recetas> findByDNI(String dni) {
        String consulta;
        List<Recetas> listaRecetas = null;
        try {
            consulta = "SELECT r FROM Recetas r WHERE r.dNIPaciente = :dni";
            Query query = em.createQuery(consulta);
            query.setParameter("dni", dni);
            listaRecetas = query.getResultList();      
        } catch (Exception e) {
            
        }
        return listaRecetas;
    }
    
}
