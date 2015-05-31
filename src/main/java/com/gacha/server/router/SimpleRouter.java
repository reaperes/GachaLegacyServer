package com.gacha.server.router;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.impl.RouterImpl;

/**
 * @author Namhoon
 */
public class SimpleRouter extends RouterImpl {
	public SimpleRouter(Vertx vertx) {
		super(vertx);

		init();
	}

	private void init() {
		this.route()
			.handler(routingContext -> {
				// This handler will be called for every request
				HttpServerResponse response = routingContext.response();
				response.putHeader("content-type", "text/plain");

				// Write to the response and end it
				response.end("Hello World from Vert.x-Web!");
			});
	}
}
