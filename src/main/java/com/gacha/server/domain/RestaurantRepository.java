package com.gacha.server.domain;

import com.gacha.server.core.Database;
import io.vertx.core.Handler;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Namhoon
 */
public class RestaurantRepository {
	private Database database;

	public RestaurantRepository(Database database) {
		this.database = database;
	}

	public void findAll(Handler<Collection<Restaurant>> handler) {
		database.query("SELECT * from restaurants", rows -> {
			Collection<Restaurant> restaurants = rows.stream()
																							 .map(Restaurant::new)
																							 .collect(Collectors.toList());
			handler.handle(restaurants);
		});
	}
}
