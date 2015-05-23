package com.gacha.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.AsyncResultHandler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

public class Starter extends AbstractVerticle {
	@Override
	public void start() throws Exception {
		JsonObject config = new JsonObject()
			.put("driver_class", "com.mysql.jdbc.Driver")
			.put("url", "jdbc:mysql://localhost:3306/gacha")
			.put("user", "root")
			.put("password", "");

		vertx.createHttpServer().requestHandler(req -> {
			JDBCClient client = JDBCClient.createShared(vertx, config);
			client.getConnection(res -> {
				if (res.succeeded()) {

					SQLConnection connection = res.result();

					connection.query("SELECT * FROM Restaurant", res2 -> {
						if (res2.succeeded()) {

							ResultSet rs = res2.result();
							System.out.println(rs.getNumRows());
							// Do something with results
						}

						connection.close(new AsyncResultHandler<Void>() {
							@Override public void handle(AsyncResult<Void> event) {
							}
						});
					});
				} else {
					// Failed to get connection - deal with it
					System.out.println("?");
				}
			});
			req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
		}).listen(8080);
	}
}