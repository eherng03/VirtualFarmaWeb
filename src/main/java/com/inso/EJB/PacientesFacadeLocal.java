/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Pacientes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eva
 */
@Local
public interface PacientesFacadeLocal {

    void create(Pacientes pacientes);

    void edit(Pacientes pacientes);

    void remove(Pacientes pacientes);
    
    void removeByDNI(String dni);

    Pacientes find(Object id);
    
    Pacientes findByUsernameAndPass(String user, String pass);
    
    Pacientes findByDNI(String dni);

    List<Pacientes> findAll();

    List<Pacientes> findRange(int[] range);

    int count();
    
}
