package org.gvaireth.goeuro.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class BusRoute {
	private int routeId;
	private Set<BusStation> stations = new LinkedHashSet<>();

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Set<BusStation> getStations() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + routeId;
		result = prime * result + ((stations == null) ? 0 : stations.hashCode());
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
		BusRoute other = (BusRoute) obj;
		if (routeId != other.routeId)
			return false;
		if (stations == null) {
			if (other.stations != null)
				return false;
		} else if (!stations.equals(other.stations))
			return false;
		return true;
	}

}
