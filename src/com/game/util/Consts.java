package com.game.util;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyCode;

public class Consts {
	
	public static final Map<KeyCode, Direction> keyToDirection =
		new HashMap<>() {
			private static final long serialVersionUID = 688766897487010503L;
			{
				put(KeyCode.W, Direction.UP);
				put(KeyCode.A, Direction.LEFT);
				put(KeyCode.S, Direction.DOWN);
				put(KeyCode.D, Direction.RIGHT);
			}
		};
}
