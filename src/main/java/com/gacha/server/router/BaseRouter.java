package com.gacha.server.router;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.impl.RouterImpl;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;

/**
 * @author Namhoon
 */
public class BaseRouter extends RouterImpl {
	private static final double SAMPLE_LAT = 37.40208147037274d;
	private static final double SAMPLE_LNG = 127.10891090333462d;

	public BaseRouter(Vertx vertx) {
		super(vertx);

		this.get("/ping")
			.handler(healthCheckHandler);

		this.get("/restaurants")
			.handler(restaurantsRouter);
	}

	private final Handler<RoutingContext> restaurantsRouter = routingContext -> {
		double latitude = Double.parseDouble(routingContext.request()
														   .getParam("latitude"));
		double longitude = Double.parseDouble(routingContext.request()
															.getParam("longitude"));
		double radius = Double.parseDouble(routingContext.request()
														 .getParam("radius"));

		JsonObject restaurant = new JsonObject();
		restaurant.put("name", "blah");
		restaurant.put("latitude", SAMPLE_LAT);
		restaurant.put("longitude", SAMPLE_LNG);
		restaurant.put("score", 50);

		JsonArray restaurants = new JsonArray();
		restaurants.add(restaurant);

		JsonObject responseJson = new JsonObject();
		responseJson.put("data", restaurants);

		HttpServerResponse response = routingContext.response();
		response.putHeader(CONTENT_TYPE, "application/json");
		response.end(responseJson.encode());
	};

	private final Handler<RoutingContext> healthCheckHandler = routingContext -> {
		HttpServerResponse response = routingContext.response();
		response.putHeader(CONTENT_TYPE, "text/plain");
		response.end("pong");
	};
}
