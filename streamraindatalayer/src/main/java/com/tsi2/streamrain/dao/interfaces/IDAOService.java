/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsi2.streamrain.dao.interfaces;
import java.util.List;


/**
 *
 * @author santiago
 */
public interface IDAOService<T> {
    
    public <T> T save(final T o);
    public <T> T get(final Class<T> type, final Long id);
    public <T> T merge(final T o);
    public <T> boolean saveOrUpdate(final T o);
    public <T> List<T> getAll(final Class<T> type);
}
