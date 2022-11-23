package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    public void Test1() {
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(3, 7)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(2, -1)));
        Assertions.assertTrue(map.objectAt(new Vector2d(2,-1)) instanceof Animal);
        Assertions.assertFalse(map.place(new Animal(map,new Vector2d(3,7))));
    }
}
