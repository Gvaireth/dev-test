package org.gvaireth.goeuro.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("RoutesStreamProvider")
public class RoutesStreamProviderImpl implements RoutesStreamProvider {

	@Value("${busRouteDataFile.location}")
	private String busRouteDataFileLocation;

	public Stream<String> getStream() throws InvalidFileException {
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get(busRouteDataFileLocation));
		} catch (IOException e) {
			throw new InvalidFileException(" opening stream problem:" + e.getMessage());
		}
		System.out.println("file stream opened");
		return stream;
	}

}
