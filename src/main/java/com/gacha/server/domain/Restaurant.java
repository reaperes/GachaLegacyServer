package com.gacha.server.domain;

import io.vertx.core.json.JsonObject;
import lombok.*;

/**
 * @author Namhoon
 */
@Data
// Table(name = "restaurants")
public class Restaurant {
	// Column(name = "restaurantId")
	private long id;
	private String name;
	private float latitude;
	private float longitude;
	private int score;

	public Restaurant() {
	}

	public Restaurant(JsonObject obj) {
		setId(obj.getLong("id"));
		setName(obj.getString("name"));
		setLatitude(obj.getFloat("latitude"));
		setLongitude(obj.getFloat("longitude"));
		setScore(obj.getInteger("score"));
	}
}
