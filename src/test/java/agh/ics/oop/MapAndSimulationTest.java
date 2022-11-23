package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapAndSimulationTest {
    @Test
    public void Test1() {
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(2, 0)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3, 5)));
    }
    @Test
    public void Test2() {
        String[] args = new String[]{"f", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(1, 1), new Vector2d(2, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(1, 5)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(6, 2)));
    }
}
