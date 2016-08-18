package org.gvaireth.goeuro.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.gvaireth.goeuro.model.BusRoutes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("RoutesFileService")
public class RoutesFileServiceImpl implements RoutesFileService {

	@Value("${busRouteDataFile.location}")
	private String busRouteDataFileLocation;

	public BusRoutes parseFile() {
		List<String[]> numbers = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(busRouteDataFileLocation))) {
			stream.forEach((line) -> {
				numbers.add(line.split(" "));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String[] route : numbers) {
			System.out.println(route.length);
		}
		return null;
	}

}
