package com.gacha.server.router;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.impl.LoggerFactory;
import io.vertx.ext.web.Router;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;

/**
 * @author Namhoon
 */
public class HealthCheckHandler {
	private static final Logger log = LoggerFactory.getLogger(HealthCheckHandler.class);

	public HealthCheckHandler(Router router) {
		router.get("/ping")
			  .handler(routingContext -> {
				  HttpServerResponse response = routingContext.response();
				  response.putHeader(CONTENT_TYPE, "text/plain");
				  response.end("pong");
			  });
	}
}
