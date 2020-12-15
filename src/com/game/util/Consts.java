package com.game.util;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyCode;

public class Consts {
	
	public static final Map<KeyCode, Direction> keyToDirectionFrog1 =
		new HashMap<>() {
			private static final long serialVersionUID = 688766897487010503L;
			{
				put(KeyCode.W, Direction.UP);
				put(KeyCode.A, Direction.LEFT);
				put(KeyCode.S, Direction.DOWN);
				put(KeyCode.D, Direction.RIGHT);
			}
		};
		
	public static final Map<KeyCode, Direction> keyToDirectionFrog2 =
		new HashMap<>() {
			private static final long serialVersionUID = 7576406274457906742L;
			{
				put(KeyCode.I, Direction.UP);
				put(KeyCode.J, Direction.LEFT);
				put(KeyCode.K, Direction.DOWN);
				put(KeyCode.L, Direction.RIGHT);
			}
		};
}
