package org.gvaireth.goeuro.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.gvaireth.goeuro.model.BusRoute;
import org.gvaireth.goeuro.model.BusRoutes;
import org.gvaireth.goeuro.model.BusStation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("RoutesFileService")
public class RoutesDaoImpl implements RoutesDao {

	@Value("${busRouteDataFile.location}")
	private String busRouteDataFileLocation;

	public BusRoutes buildRoutes() throws InvalidFileException {
		BusRoutes routes = new BusRoutes();
		try {
			List<String[]> numbers = readRawNumbers();
			trimAndCheckNumberOfRoutes(numbers);
			parseRawNumbers(routes, numbers);
		} catch (NumberFormatException nfe) {
			throw new InvalidFileException(nfe.getMessage());
		}
		return routes;
	}

	private void parseRawNumbers(BusRoutes routes, List<String[]> numbers) {
		for (String[] rawRoute : numbers) {
			BusRoute route = new BusRoute();
			route.setRouteId(Integer.parseInt(rawRoute[0]));
			for (int i = 1; i < rawRoute.length; i++) {
				BusStation station = new BusStation(Integer.parseInt(rawRoute[i]));
				route.add(station);
			}
			routes.add(route);
		}
	}

	private void trimAndCheckNumberOfRoutes(List<String[]> numbers) {
		int routesNumber = Integer.parseInt(numbers.get(0)[0]);
		numbers.remove(0);
		if (routesNumber != numbers.size()) {
			throw new InvalidFileException(" declared number of routes does not match actual number");
		}
	}

	protected List<String[]> readRawNumbers() throws InvalidFileException {
		List<String[]> numbers = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(busRouteDataFileLocation))) {
			stream.forEach((line) -> {
				numbers.add(line.split(" "));
			});
		} catch (IOException e) {
			throw new InvalidFileException(e.getMessage());
		}

		return numbers;
	}

}
