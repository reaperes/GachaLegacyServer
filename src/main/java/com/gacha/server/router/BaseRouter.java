package com.gacha.server.router;

import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.impl.RouterImpl;

/**
 * @author Namhoon
 */
public class BaseRouter extends RouterImpl {
	private static final Logger log = LoggerFactory.getLogger(BaseRouter.class);

	public BaseRouter(Vertx vertx) {
		super(vertx);

		new HealthCheckHandler(this);
		new RestaurantsHandler(this);
	}
}
