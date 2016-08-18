package org.gvaireth.goeuro.server;

import org.gvaireth.goeuro.model.BusRoutes;

public interface RoutesDao {
	BusRoutes buildRoutes() throws InvalidFileException;
}
