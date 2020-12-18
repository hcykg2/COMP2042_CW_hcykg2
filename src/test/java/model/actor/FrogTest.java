package test.java.model.actor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.model.Level;
import main.java.model.World;
import main.java.model.actor.Frog;

class FrogTest {

	@Test
	void moveTest() {
		JFXPanel panel = new JFXPanel();
		
		
		Level level = new Level(1, 1);
		Scene scene = new Scene(level, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
		Stage stage = new Stage();
		stage.setScene(scene);
		Frog frog = new Frog();
		level.add(frog);
		
		assertEquals(1, frog.getGridX(), "test");
	}

}
