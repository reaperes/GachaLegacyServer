package com.gacha.server.core;

import com.gacha.server.AbstractIntegrationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Namhoon
 */
public class DatabaseIntegrationTest extends AbstractIntegrationTest {
	private Database database;

	@Before
	public void before() {
		database = new Database(vertx);
	}

	@Test
	public void test() {
		Assert.assertNotNull(database);
	}
}
