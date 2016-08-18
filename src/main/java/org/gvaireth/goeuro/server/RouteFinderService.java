package org.gvaireth.goeuro.server;

public interface RouteFinderService {
	boolean directRouteExists(int departureId, int destinationId);
}
