package org.gvaireth.goeuro.model;

import java.util.ArrayList;
import java.util.List;

public class BusRoutes {
	private List<BusRoute> routes = new ArrayList<>();

	public List<BusRoute> getRoutes() {
		return routes;
	}

	public int size() {
		return routes != null ? routes.size() : 0;
	}

	public void add(BusRoute route) {
		routes.add(route);
	}

	@Override
	public String toString() {
		return "BusRoutes [routes=" + routes + "]";
	}

}
