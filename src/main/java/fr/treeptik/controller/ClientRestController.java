package fr.treeptik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Client;
import fr.treeptik.shop.service.ClientService;


@Controller
@RequestMapping("/rest")
public class ClientRestController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public @ResponseBody List<Client> listAll() throws ServiceException{
		return clientService.findAll();
		
	}

}
