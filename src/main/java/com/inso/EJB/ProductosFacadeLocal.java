/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Productos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eva y Alba
 */
@Local
public interface ProductosFacadeLocal {

    void create(Productos productos);

    void edit(Productos productos);

    void remove(Productos productos);

    void removeByCIFNombre(String cif, String nombre);
    
    Productos find(Object id);
    
    Productos findByCIFNombre(String cif, String nombre);

    List<Productos> findAll();

    List<Productos> findRange(int[] range);

    int count();
    
}
