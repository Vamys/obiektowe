package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    public void Test1() {
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(3, 7)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(2, -1)));
        Assertions.assertTrue(map.objectAt(new Vector2d(2,-1)) instanceof Animal);
        Assertions.assertFalse(map.place(new Animal(map,new Vector2d(3,7))));
    }
    @Test
    public void isOccupiedTest(){
        AbstractWorldMap map = new GrassField(10);
        map.place(new Animal(map,new Vector2d(1,1)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(1,1)));
    }
    @Test
    public void placeTest(){
        AbstractWorldMap map = new GrassField(10);
        Assertions.assertTrue(map.place(new Animal(map,new Vector2d(3,7))));
        Assertions.assertFalse(map.place(new Animal(map,new Vector2d(3,7))));
    }
    @Test
    public void objectAtTest(){
        AbstractWorldMap map = new GrassField(10);
        map.place(new Animal(map,new Vector2d(1,1)));
        Assertions.assertTrue(map.objectAt(new Vector2d(1,1)) instanceof Animal);
    }
    @Test
    public void canMoveToTest(){
        AbstractWorldMap map = new GrassField(10);
        map.place(new Animal(map,new Vector2d(1,1)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(1,1)));
    }
    @Test
    public void GrassEatingTest(){
        String[] args = new String[]{"f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(0,0)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        map.addGrass(new Vector2d(0,3));
        engine.run();
        Assertions.assertNull(map.objectAt(new Vector2d(0, 3)));

    }
}
