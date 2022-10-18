package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        Assertions.assertEquals(MapDirections.EAST.next(),MapDirections.SOUTH);
        Assertions.assertEquals(MapDirections.SOUTH.next(),MapDirections.WEST);
        Assertions.assertEquals(MapDirections.WEST.next(),MapDirections.NORTH);
        Assertions.assertEquals(MapDirections.NORTH.next(),MapDirections.EAST);
    }
    @Test
    public void previousTest(){
        Assertions.assertEquals(MapDirections.EAST,MapDirections.SOUTH.previous());
        Assertions.assertEquals(MapDirections.SOUTH,MapDirections.WEST.previous());
        Assertions.assertEquals(MapDirections.WEST,MapDirections.NORTH.previous());
        Assertions.assertEquals(MapDirections.NORTH,MapDirections.EAST.previous());
    }
}
