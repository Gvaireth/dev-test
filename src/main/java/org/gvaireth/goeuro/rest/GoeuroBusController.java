package org.gvaireth.goeuro.rest;

import org.gvaireth.goeuro.model.BusStation;
import org.gvaireth.goeuro.model.RouteCheckResult;
import org.gvaireth.goeuro.server.RoutesFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoeuroBusController {

	@Autowired
	private RoutesFileService service;

	@RequestMapping(value = "/rest/provider/goeurobus/direct/{dep_sid}/{arr_sid}", method = RequestMethod.GET)
	public RouteCheckResult checkRoute(@PathVariable int dep_sid, @PathVariable int arr_sid) {
		System.out.println("controller");
		RouteCheckResult checkResult = new RouteCheckResult();
		checkResult.setDep_sid(dep_sid);
		checkResult.setArr_sid(arr_sid);
		return checkResult;
	}

}
