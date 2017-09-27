/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsi2.streamrain.dao.implementations;

import com.tsi2.streamrain.context.DBHibernateUtil;
import com.tsi2.streamrain.dao.interfaces.IDAOService;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author santiago
 */
public class StreamRainMySQLDAO implements IDAOService{
    

    public <T> T save(final T o){
      Session dbSession = DBHibernateUtil.getSessionFactory().openSession();
      return (T) dbSession.save(o);
    }

    public void delete(final Object object){
       Session dbSession = DBHibernateUtil.getSessionFactory().openSession();
       dbSession.delete(object);
    }

    public <T> T get(final Class<T> type, final Long id){
       Session dbSession = DBHibernateUtil.getSessionFactory().openSession();
       return (T) dbSession.get(type, id);
    }

    public <T> T merge(final T o)   {
      Session dbSession = DBHibernateUtil.getSessionFactory().openSession();
      return (T) dbSession.merge(o);
    }

    public <T> boolean saveOrUpdate(final T o){
      Session dbSession = DBHibernateUtil.getSessionFactory().openSession();
      dbSession.saveOrUpdate(o);
      return true;
    }

    public <T> List<T> getAll(final Class<T> type) {
      Session dbSession = DBHibernateUtil.getSessionFactory().openSession();
      final Criteria crit = dbSession.createCriteria(type);
      return crit.list();
    }
}
