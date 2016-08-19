package org.gvaireth.goeuro.server;

import java.util.stream.Stream;

public interface RoutesStreamProvider {
	Stream<String> getStream() throws InvalidFileException;
}
