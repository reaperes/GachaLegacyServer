package com.gacha.server.core;

import com.google.common.base.Preconditions;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;
import lombok.Getter;

/**
 * @author Namhoon
 */
public class Database {
	private JDBCClient jdbcClient;

	public Database(Vertx vertx) {
		Preconditions.checkNotNull(vertx);

		JsonObject config = new JsonObject();
		config.put("url", "jdbc:mysql://localhost/gacha");
		config.put("driver_class", "com.mysql.jdbc.Driver");
		config.put("user", "guest");
		config.put("password", "guest");

		jdbcClient = JDBCClient.createShared(vertx, config);
	}

	public JDBCClient getConnection(Handler<AsyncResult<SQLConnection>> handler) {
		return jdbcClient.getConnection(handler);
	}
}
