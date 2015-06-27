package com.gacha.server;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author Namhoon
 */
@RunWith(VertxUnitRunner.class)
abstract public class AbstractIntegrationTest {
	protected Vertx vertx;

	@Before
	public void before(TestContext context) {
		vertx = Vertx.vertx();
	}

	@After
	public void after(TestContext context) {
		vertx.close(context.asyncAssertSuccess());
	}
}
