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
		return " BusRoutes [routes=" + routes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routes == null) ? 0 : routes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusRoutes other = (BusRoutes) obj;
		if (routes == null) {
			if (other.routes != null)
				return false;
		} else if (!routes.equals(other.routes))
			return false;
		return true;
	}

}
