package fr.treeptik.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.treeptik.shop.dao.GenericDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;

@Service
public abstract class GenericService <T extends GenericDAO<E, K>, E , K> {
    
    protected abstract T getDao() ;
    
    public E save(E entite) throws ServiceException{
        try{
            getDao().save(entite);
        }catch(DAOException e){
            throw new ServiceException(e.getMessage(), e);
        }
        return entite;
    }
    
    public E update(E entite) throws ServiceException{
        E updatedEntite = null;
        try{
            updatedEntite = getDao().update(entite);
        }catch(DAOException e){
            throw new ServiceException(e.getMessage(), e);
        }
        return updatedEntite;
    }
    
    public List<E> findAll() throws ServiceException{
        List<E> findAll = null;
        try{
            findAll = getDao().findAll();
            return findAll;
        }catch(DAOException e){
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public E findById(K id) throws ServiceException{
        try{
            return getDao().findById(id);
        }catch(DAOException e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void remove(E entity) throws ServiceException{
        try{
            getDao().remove(entity);
        }catch(DAOException e){
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
}
