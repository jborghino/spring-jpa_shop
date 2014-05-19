package fr.treeptik.shop.service;

import java.util.List;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Role;

public interface RoleService {

	Role save(Role role) throws ServiceException;

	Role update(Role role) throws ServiceException;

	void remove(Role role) throws ServiceException;

	Role findById(Integer id) throws ServiceException;

	List<Role> findAll() throws ServiceException;
	
}
