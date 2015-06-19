package com.gacha.server.domain;

import lombok.Data;

/**
 * @author Namhoon
 */
@Data
public class Restaurant {
	private long id;
	private String name;
	private float latitude;
	private float langitude;
	private int score;
}
