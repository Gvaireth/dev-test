package org.gvaireth.goeuro.rest;

import org.gvaireth.goeuro.model.BusStation;
import org.gvaireth.goeuro.server.RoutesFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoeuroBusController {

	@Autowired
	private RoutesFileService service;

	@RequestMapping("/greeting")
	public BusStation greeting() {
		System.out.println("controller");
		service.parseFile();
		return new BusStation(123);
	}

}
