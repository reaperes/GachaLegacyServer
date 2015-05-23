package com.gacha.server;

import org.vertx.java.platform.Verticle;

/**
 * @author Namhoon
 */
public class Starter extends Verticle {
	public static void main(String[] args) throws Exception {
		new Starter().start();
	}

	@Override
	public void start() {
		vertx.createHttpServer().requestHandler(req ->
			req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>")
		).listen(8080);
	}
}
