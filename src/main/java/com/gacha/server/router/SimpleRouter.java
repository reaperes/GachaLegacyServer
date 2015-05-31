package com.gacha.server.router;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.impl.RouterImpl;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;

/**
 * @author Namhoon
 */
public class SimpleRouter extends RouterImpl {
	public SimpleRouter(Vertx vertx) {
		super(vertx);

		this.get("/hello")
			.handler(routingContext -> {
				HttpServerResponse response = routingContext.response();
				response.putHeader(CONTENT_TYPE, "text/plain");
				response.end("Hello World!");
			});

		this.get("/restaurants")
			.handler(routingContext -> {
				JsonObject restaurant = new JsonObject();
				restaurant.put("name", "blah");
				restaurant.put("latitude", 10.1234);
				restaurant.put("longitude", 10.1234);
				restaurant.put("score", 5);

				JsonArray restaurants = new JsonArray();
				restaurants.add(restaurant);

				JsonObject responseJson = new JsonObject();
				responseJson.put("data", restaurants);

				HttpServerResponse response = routingContext.response();
				response.putHeader(CONTENT_TYPE, "application/json");
				response.end(responseJson.encode());
			});
	}

}
