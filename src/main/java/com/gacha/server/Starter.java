package com.gacha.server;

import com.gacha.server.router.BaseRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class Starter extends AbstractVerticle {
	@Override
	public void start() throws Exception {
		Router router = new BaseRouter(vertx);

		HttpServer server = vertx.createHttpServer();
		server.requestHandler(router::accept)
					.listen(8080);
	}
}
