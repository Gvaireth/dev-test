package org.gvaireth.goeuro.model;

import java.util.List;

public class BusRoute {
	private int routeId;
	private List<BusStation> stations;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public List<BusStation> getStations() {
		return stations;
	}

	public void setStations(List<BusStation> stations) {
		this.stations = stations;
	}

	public int size() {
		return stations != null ? stations.size() : 0;
	}

	@Override
	public String toString() {
		return "BusRoute [routeId=" + routeId + ", stations=" + stations + "]";
	}

}
