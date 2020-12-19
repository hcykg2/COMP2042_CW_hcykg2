package main.java.util;

import main.java.model.Level;
import main.java.model.View;
import main.java.model.actor.End;
import main.java.model.actor.Frog;
import main.java.model.actor.Vehicle;

public class Levels {
	public static final int numOfLevels = 2;
	Level level;
	
	public static void initLevel(Level level, int levelNum) {
		switch (levelNum) {
			case 0:
				level1(level);
				break;
			case 1:
				level2(level);
				break;
		}
		
	}
	
	public static void level1(Level level) {
		level.addRow("file:src/main/resources/assets/tile_water.png", 0, false);
		level.addRow("file:src/main/resources/assets/tile_end_top.png", 1, false);
		level.addRow("file:src/main/resources/assets/tile_end_bottom.png", 2, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 3, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 4, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 5, false);
		level.addRow("file:src/main/resources/assets/tile_grass.png", 6, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 7, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 8, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 9, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 10, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 11, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 12, true);
		level.addRow("file:src/main/resources/assets/tile_grass.png", 13, true);
		level.addTurtles(0, 3, -1, 3);
		level.addTurtles(6, 3, -1, 3);
		level.addLog(2, 4, 1.5, 5);
		level.addLog(9, 4, 1.5, 5);
		level.addLog(0, 5, 1, 3);
		level.addLog(5, 5, 1, 3);
		level.addLog(10, 5, 1, 3);
		level.add(new Vehicle("file:src/main/resources/assets/car1.png", 10, 11, -1, 1));
		level.add(new Vehicle("file:src/main/resources/assets/car1.png", 10, 11, -1, 1));
		
		level.addText("\nlevel 1", TextColor.YELLOW, 5, 0);
		
		End end = new End(3, 1);
		level.add(end);
		End end2 = new End(9, 1);
		level.add(end2);
		
		Frog frog = new Frog();
		level.add(frog);
		level.setFrog(frog);
		
		level.endList.add(end);
		level.endList.add(end2);
	}
	
	public static void level2(Level level) {
		level.addRow("file:src/main/resources/assets/tile_water.png", 0, false);
		level.addRow("file:src/main/resources/assets/tile_end_top.png", 1, false);
		level.addRow("file:src/main/resources/assets/tile_end_bottom.png", 2, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 3, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 4, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 5, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 6, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 7, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 8, false);
		level.addRow("file:src/main/resources/assets/tile_water.png", 9, false);
		level.addRow("file:src/main/resources/assets/tile_grass.png", 10, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 11, true);
		level.addRow("file:src/main/resources/assets/tile_road.png", 12, true);
		level.addRow("file:src/main/resources/assets/tile_grass.png", 13, true);
		level.addWetTurtles(0, 3, -1, 3);
		level.addTurtles(6, 3, -1, 3);
		level.addLog(2, 4, 1.5, 3);
		level.addLog(0, 5, 1, 3);
		level.addLog(5, 5, 1, 3);
		level.addLog(10, 5, 1, 3);
		level.addWetTurtles(0, 6, 1.3, 5);
		level.addLog(10, 6, 1.3, 3);
		level.addLog(5, 7, -1.5, 2);
		level.addWetTurtles(5, 8, 2, 7);
		level.addLog(1, 9, -3, 3);
		
		level.addText("\nlevel 2", TextColor.YELLOW, 5, 0);
		
		End end = new End(0, 1);
		level.add(end);
		End end2 = new End(6, 1);
		level.add(end2);
		End end3 = new End(12, 1);
		level.add(end3);
		
		Frog frog = new Frog();
		level.add(frog);
		level.setFrog(frog);
		
		level.endList.add(end);
		level.endList.add(end2);
		level.endList.add(end3);
	}
}
