package org.gvaireth.goeuro.server;

import org.gvaireth.goeuro.model.BusRoute;
import org.gvaireth.goeuro.model.BusRoutes;
import org.gvaireth.goeuro.model.BusStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RouteFinderService")
public class RouteFinderServiceImpl implements RouteFinderService {

	@Autowired
	private RoutesDao dao;

	@Override
	public boolean directRouteExists(int departureId, int destinationId) {
		BusRoutes routes = dao.buildRoutes();
		boolean exists = false;
		for (BusRoute route : routes.getRoutes()) {
			BusStation departure = new BusStation(departureId);
			BusStation destination = new BusStation(destinationId);
			if (route.getStations().contains(departure) && route.getStations().contains(destination)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
}
