package com.gacha.server.core;

import com.gacha.server.AbstractIntegrationTest;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Namhoon
 */
public class DatabaseIntegrationTest extends AbstractIntegrationTest {
	private Database database;

	@Before
	public void before() {
		database = new Database(vertx);
	}

	@Test
	public void database_can_be_connected(TestContext context) {
		Async async = context.async();
		database.getConnection(resConnection -> {
			if (resConnection.succeeded()) {
				SQLConnection connection = resConnection.result();

				connection.query("SELECT 1", res -> {
					if (res.succeeded()) {
						ResultSet rs = res.result();
						List<JsonArray> arr = rs.getResults();
						context.assertNotNull(arr);
					} else {
						context.fail();
					}
					connection.close();
					async.complete();
				});
			}
		});
	}

	@Test
	public void query__happy_test(TestContext context) {
		Async async = context.async();
		database.query("SELECT 1", resResultSet -> {
			if (resResultSet.succeeded()) {
				ResultSet resultSet = resResultSet.result();
				context.assertEquals(1, resultSet.getNumRows());
				async.complete();
			}
		});
	}
}
