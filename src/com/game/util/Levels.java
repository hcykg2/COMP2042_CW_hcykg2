package com.game.util;

import com.game.model.View;
import com.game.model.actor.End;
import com.game.model.actor.Frog;

public class Levels {
	
	public static void initLevel1(View view) {
		view.addRow("file:src/assets/tile_water.png", 0, false);
		view.addRow("file:src/assets/tile_end_top.png", 1, false);
		view.addRow("file:src/assets/tile_end_bottom.png", 2, false);
		view.addRow("file:src/assets/tile_water.png", 3, false);
		view.addRow("file:src/assets/tile_water.png", 4, false);
		view.addRow("file:src/assets/tile_water.png", 5, false);
		view.addRow("file:src/assets/tile_grass.png", 6, false);
		view.addRow("file:src/assets/tile_road.png", 7, false);
		view.addRow("file:src/assets/tile_road.png", 8, false);
		view.addRow("file:src/assets/tile_road.png", 9, false);
		view.addRow("file:src/assets/tile_road.png", 10, false);
		view.addRow("file:src/assets/tile_road.png", 11, false);
		view.addRow("file:src/assets/tile_road.png", 12, false);
		view.addRow("file:src/assets/tile_grass.png", 13, false);
		view.addTurtles(0, 3, -1, 3);
		view.addTurtles(6, 3, -1, 3);
		view.addLog(2, 4, 1.5, 5);
		view.addLog(9, 4, 1.5, 5);
		view.addLog(0, 5, 1, 3);
		view.addLog(5, 5, 1, 3);
		view.addLog(10, 5, 1, 3);
		view.add(new End(6, 1));
		
		Frog frog = new Frog(0);
		view.add(frog);
		
		view.frogList.add(frog);
	}
}
