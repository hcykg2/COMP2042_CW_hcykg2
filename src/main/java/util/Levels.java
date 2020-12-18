package main.java.util;

import main.java.model.Level;
import main.java.model.View;
import main.java.model.actor.End;
import main.java.model.actor.Frog;
import main.java.model.actor.Vehicle;

public class Levels {
	
	public static void initLevel1(Level view) {
		view.addRow("file:src/assets/tile_water.png", 0, false);
		view.addRow("file:src/assets/tile_end_top.png", 1, false);
		view.addRow("file:src/assets/tile_end_bottom.png", 2, false);
		view.addRow("file:src/assets/tile_water.png", 3, false);
		view.addRow("file:src/assets/tile_water.png", 4, false);
		view.addRow("file:src/assets/tile_water.png", 5, false);
		view.addRow("file:src/assets/tile_grass.png", 6, true);
		view.addRow("file:src/assets/tile_road.png", 7, true);
		view.addRow("file:src/assets/tile_road.png", 8, true);
		view.addRow("file:src/assets/tile_road.png", 9, true);
		view.addRow("file:src/assets/tile_road.png", 10, true);
		view.addRow("file:src/assets/tile_road.png", 11, true);
		view.addRow("file:src/assets/tile_road.png", 12, true);
		view.addRow("file:src/assets/tile_grass.png", 13, true);
		view.addTurtles(0, 3, -1, 3);
		view.addTurtles(6, 3, -1, 3);
		view.addLog(2, 4, 1.5, 5);
		view.addLog(9, 4, 1.5, 5);
		view.addLog(0, 5, 1, 3);
		view.addLog(5, 5, 1, 3);
		view.addLog(10, 5, 1, 3);
		view.add(new Vehicle("file:src/assets/car1.png", 10, 11, 0.5, 1));
		
		view.addText("\nlevel 1", TextColor.YELLOW, 5, 0);
		
		End end = new End(3, 1);
		view.add(end);
		End end2 = new End(9, 1);
		view.add(end2);
		
		Frog frog = new Frog(0);
		view.add(frog);
		view.setFrog(frog);
		
		view.endList.add(end);
		view.endList.add(end2);
	}
}
