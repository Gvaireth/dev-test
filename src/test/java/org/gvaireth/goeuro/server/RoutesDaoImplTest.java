package org.gvaireth.goeuro.server;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

import org.gvaireth.goeuro.model.BusRoute;
import org.gvaireth.goeuro.model.BusRoutes;
import org.gvaireth.goeuro.model.BusStation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan({ "org.gvaireth.goeuro.server" })
public class RoutesDaoImplTest {

	@Autowired
	private RoutesDaoImpl service;

	private List<String[]> rawNumbers;

	@Before
	public void setup() {
		rawNumbers = buildRawNumbers();
	}

	@Test
	public void smokeTest() {
		assertNotNull(service.buildRoutes());
	}

	@Test
	public void numberOfRoutesParsingTest() {
		BusRoutes routes = service.parseRawNumbers(rawNumbers);
		System.out.println(routes);
		assertEquals(3, routes.size());
		assertEquals(3, routes.getRoutes().size());
	}

	@Test
	public void routesIdsParsingTest() {
		BusRoutes routes = service.parseRawNumbers(rawNumbers);
		assertEquals(11, routes.getRoutes().get(0).getRouteId());
		assertEquals(12, routes.getRoutes().get(1).getRouteId());
		assertEquals(13, routes.getRoutes().get(2).getRouteId());
	}

	@Test
	public void routeLengthParsingTest() {
		BusRoutes routes = service.parseRawNumbers(rawNumbers);

		BusRoute firstRoute = routes.getRoutes().get(0);
		assertEquals(2, firstRoute.size());

		BusRoute secondRoute = routes.getRoutes().get(1);
		assertEquals(4, secondRoute.size());

		BusRoute thirdRoute = routes.getRoutes().get(2);
		assertEquals(3, thirdRoute.size());
	}

	@Test
	public void stationIdParsingTest() {
		BusRoutes routes = service.parseRawNumbers(rawNumbers);

		BusRoute firstRoute = routes.getRoutes().get(0);
		Iterator<BusStation> stationIterator = firstRoute.getStations().iterator();
		assertEquals(1, stationIterator.next().getStationId());
		assertEquals(2, stationIterator.next().getStationId());

	}

	private List<String[]> buildRawNumbers() {
		List<String[]> rawNumbers = new ArrayList<>();
		rawNumbers.add(new String[] { "3" });
		rawNumbers.add(new String[] { "11", "1", "2" });
		rawNumbers.add(new String[] { "12", "2", "3", "4", "0" });
		rawNumbers.add(new String[] { "13", "4", "7", "2" });
		return rawNumbers;
	}

}
