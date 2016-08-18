package org.gvaireth.goeuro.model;

public class BusStation {

	private int stationId;

	public BusStation(int stationId) {
		this.stationId = stationId;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	@Override
	public String toString() {
		return "BusStation [stationId=" + stationId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stationId;
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
		BusStation other = (BusStation) obj;
		if (stationId != other.stationId)
			return false;
		return true;
	}

}
