package com.gacha.server.core;

import com.google.common.base.Preconditions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import lombok.Getter;

/**
 * @author Namhoon
 */
public class Database {
	@Getter
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
}
