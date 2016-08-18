package org.gvaireth.goeuro.model;

import java.util.List;

public class BusRoutes {
	private List<BusRoute> routes;

	public List<BusRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<BusRoute> routes) {
		this.routes = routes;
	}

	public int size() {
		return routes != null ? routes.size() : 0;
	}

	@Override
	public String toString() {
		return "BusRoutes [routes=" + routes + "]";
	}

}
