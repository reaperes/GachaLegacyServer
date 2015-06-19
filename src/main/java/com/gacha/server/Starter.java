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

//JsonObject config = new JsonObject()
//	.put("driver_class", "com.mysql.jdbc.Driver")
//	.put("url", "jdbc:mysql://localhost:3306/gacha")
//	.put("user", "root")
//	.put("password", "");

//			JDBCClient client = JDBCClient.createShared(vertx, config);
//			client.getConnection(res -> {
//				if (res.succeeded()) {
//
//					SQLConnection connection = res.result();
//
//					connection.query("SELECT * FROM Restaurant", res2 -> {
//						if (res2.succeeded()) {
//
//							ResultSet rs = res2.result();
//							System.out.println(rs.getNumRows());
//						}
//
//						connection.close(new AsyncResultHandler<Void>() {
//							@Override public void handle(AsyncResult<Void> event) {
//							}
//						});
//					});
//				} else {
//					System.out.println("?");
//				}
//			});
//			req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
