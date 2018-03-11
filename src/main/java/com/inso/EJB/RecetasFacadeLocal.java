/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Recetas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eva
 */
@Local
public interface RecetasFacadeLocal {

    void create(Recetas recetas);

    void edit(Recetas recetas);

    void remove(Recetas recetas);

    Recetas find(Object id);

    List<Recetas> findAll();

    List<Recetas> findRange(int[] range);

    int count();
    
}
