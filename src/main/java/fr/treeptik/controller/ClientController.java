package fr.treeptik.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Client;
import fr.treeptik.shop.service.ClientService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public ModelAndView initFormulaire(Client client) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("client/client");
		
		//Solution 1 : Avec le actionName
//		String actionName ="";
		
//		Solution 2 : avec le boolean
		Boolean isUpdate = false;
		
		if(client.getId() == null){
			client = new Client();
//			actionName = "Création d'un nouveau client";
		} else {
			client = clientService.findById(client.getId());
//			actionName = "Mise à jour du client " + client.getNom();
			isUpdate = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("cl", client);
//		map.put("actionName", actionName);
		map.put("isUpdate", isUpdate);
		
		modelAndView.addAllObjects(map);
		
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView list() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("client/list-client", "clients",
				clientService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(Client client) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("redirect:client/list.do");
		clientService.remove(client);
		return modelAndView;
	}
	
}
