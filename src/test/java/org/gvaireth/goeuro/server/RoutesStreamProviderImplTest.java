package org.gvaireth.goeuro.server;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan({ "org.gvaireth.goeuro.server" })
public class RoutesStreamProviderImplTest {

	@Autowired
	private RoutesStreamProvider service;

	@Test
	public void smokeTest() {
		assertNotNull(service.getStream());
	}
}
