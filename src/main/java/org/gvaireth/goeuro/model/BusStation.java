package org.gvaireth.goeuro.model;

//note: this class is a bit over the top in current problem specification, it can be substituted by simple integer, however in normal system i would expect more fields to describe a bus station
//perhaps if performance is critical factor, it can be simplified, however parse and search algorithms are so simple that it shouldnt be a problem even for reasonably huge data sets
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
		return "\n  BusStation [stationId=" + stationId + "]";
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
