package org.gvaireth.goeuro.server;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.gvaireth.goeuro.model.BusRoute;
import org.gvaireth.goeuro.model.BusRoutes;
import org.gvaireth.goeuro.model.BusStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("RoutesDao")
public class RoutesDaoImpl implements RoutesDao {

	@Autowired
	private RoutesStreamProvider routesStreamProvider;

	public BusRoutes buildRoutes() throws InvalidFileException {
		BusRoutes routes = null;
		try {
			List<String[]> numbers = readRawNumbers();

			routes = parseRawNumbers(numbers);
		} catch (NumberFormatException nfe) {
			throw new InvalidFileException(nfe.getMessage());
		}
		System.out.println("routes build");
		return routes;
	}

	BusRoutes parseRawNumbers(List<String[]> numbers) {
		trimAndCheckNumberOfRoutes(numbers);
		BusRoutes routes = new BusRoutes();
		for (String[] rawRoute : numbers) {
			BusRoute route = new BusRoute();
			route.setRouteId(Integer.parseInt(rawRoute[0]));
			for (int i = 1; i < rawRoute.length; i++) {
				BusStation station = new BusStation(Integer.parseInt(rawRoute[i]));
				route.add(station);
			}
			routes.add(route);
		}
		System.out.println("numbers parsed");
		return routes;
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
		try (Stream<String> stream = routesStreamProvider.getStream()) {
			stream.forEach((line) -> {
				numbers.add(line.split(" "));
			});
		}
		System.out.println("file stream consumed");
		return numbers;
	}

}
