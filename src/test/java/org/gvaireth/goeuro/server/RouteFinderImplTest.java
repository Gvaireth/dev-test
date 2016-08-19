package org.gvaireth.goeuro.server;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@ComponentScan({ "org.gvaireth.goeuro.server", "org.gvaireth.goeuro.core" })
public class RouteFinderImplTest {

	@Autowired
	private RouteFinderService service;

	@Test
	public void routeFoundTest() {
		assertTrue(service.directRouteExists(153, 150));
		assertTrue(service.directRouteExists(153, 106));
		assertTrue(service.directRouteExists(17, 24));
		assertTrue(service.directRouteExists(24, 17));
		assertTrue(service.directRouteExists(5, 11));
		assertTrue(service.directRouteExists(142, 11));
		assertTrue(service.directRouteExists(148, 155));
	}

	@Test
	public void routeNotFoundTest() {
		assertFalse(service.directRouteExists(0, 0));
		assertFalse(service.directRouteExists(153, 0));
		assertFalse(service.directRouteExists(153, 155));
	}

}
