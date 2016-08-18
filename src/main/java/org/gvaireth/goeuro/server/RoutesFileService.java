package org.gvaireth.goeuro.server;

import org.gvaireth.goeuro.model.BusRoutes;

public interface RoutesFileService {
	BusRoutes buildRoutes() throws InvalidFileException;
}
