package fr.treeptik.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.shop.dao.RoleDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Role;
import fr.treeptik.shop.service.RoleService;

//public class RoleServiceImpl extends GenericService<RoleDAO, Role, Integer>{
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDAO roleDAO;
	
//	@Override
//	protected RoleDAO getDao() {
//		return roleDAO;
//	}


	@Override
	@Transactional
	public Role save(Role role) throws ServiceException{
		try {
			return roleDAO.save(role);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save role", e);
		}
	}
	
	@Override
	@Transactional
	public Role update(Role role) throws ServiceException{
		try {
			return roleDAO.update(role);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update role", e);
		}
	}
	
	@Override
	@Transactional
	public void remove(Role role) throws ServiceException{
		try {
			role = this.findById(role.getId());
			roleDAO.remove(role);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove role", e);
		}
	}
	
	@Override
	public Role findById(Integer id) throws ServiceException{
		try {
			return roleDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById role", e);
		}
	}
	
	@Override
	public List<Role> findAll() throws ServiceException{
		try {
			return (List<Role>) roleDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll role", e);
		}
	}
	
	
	
}
