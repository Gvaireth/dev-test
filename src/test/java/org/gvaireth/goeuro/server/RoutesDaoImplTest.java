package org.gvaireth.goeuro.server;

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
@ComponentScan({ "org.gvaireth.goeuro.server" })
public class RoutesDaoImplTest {

	@Autowired
	private RoutesDao service;

	@Test
	public void test() {
		service.buildRoutes();
	}

}
