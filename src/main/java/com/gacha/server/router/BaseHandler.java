package com.gacha.server.router;

import io.vertx.ext.web.RoutingContext;

/**
 * @author Namhoon
 */
public class BaseHandler {
	public double getDoubleParam(RoutingContext routingContext, String key) {
		return Double.parseDouble(routingContext.request().getParam(key));
	}
}
