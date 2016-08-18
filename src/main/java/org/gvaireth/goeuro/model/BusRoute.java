package org.gvaireth.goeuro.model;

import java.util.ArrayList;
import java.util.List;

public class BusRoute {
	private int routeId;
	private List<BusStation> stations = new ArrayList<>();

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public List<BusStation> getStations() {
		return stations;
	}

	public void add(BusStation station) {
		stations.add(station);
	}

	public int size() {
		return stations != null ? stations.size() : 0;
	}

	@Override
	public String toString() {
		return "BusRoute [routeId=" + routeId + ", stations=" + stations + "]";
	}

}
