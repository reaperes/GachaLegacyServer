package com.gacha.server.domain;

import com.gacha.server.AbstractIntegrationTest;
import com.gacha.server.core.Database;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Namhoon
 */
public class RestaurantRepositoryIntegrationTest extends AbstractIntegrationTest {
	private RestaurantRepository repository;

	@Before
	public void before() {
		repository = new RestaurantRepository(new Database(vertx));
	}

	@Test
	public void findAll__happy_test(TestContext ctx) {
		Async async = ctx.async();

		repository.findAll(restaurants -> {
			ctx.assertEquals(0, restaurants.size());
			async.complete();
		});
	}
}
