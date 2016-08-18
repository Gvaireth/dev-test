package org.gvaireth.goeuro.model;

public class BusStation {

	private int stationId;

	public BusStation(int stationId) {
		super();
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

}
