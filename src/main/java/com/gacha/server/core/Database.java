package com.gacha.server.core;

import com.google.common.base.Preconditions;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import lombok.Getter;

import java.util.List;

/**
 * @author Namhoon
 */
public class Database {
	private final Logger log = LoggerFactory.getLogger(Database.class);

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

	public void query(String sql, Handler<List<JsonObject>> handler) {
		jdbcClient.getConnection(resSQLConnection -> {
			if (resSQLConnection.succeeded()) {
				SQLConnection connection = resSQLConnection.result();
				connection.query(sql, res -> {
					if (res.succeeded()) {
						handler.handle(res.result().getRows());
					} else {
						throw new RuntimeException("Fail", res.cause());
					}
				});
				connection.close();
			}	else {
				throw new RuntimeException("Failed to connect Database.", resSQLConnection.cause());
			}
		});
	}
}
