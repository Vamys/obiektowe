package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        Assertions.assertEquals(new Vector2d(4, 3), new Vector2d(4, 3));
        Assertions.assertEquals(new Vector2d(1, 3), new Vector2d(1, 3));
        Assertions.assertEquals(new Vector2d(4, 2), new Vector2d(4, 2));
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals(new Vector2d(1, 2).toString(), "(1,2)");
        Assertions.assertEquals(new Vector2d(5, 3).toString(), "(5,3)");
        Assertions.assertEquals(new Vector2d(6, 2).toString(), "(6,2)");
    }

    @Test
    public void precedesTest() {
        Assertions.assertTrue(new Vector2d(2, 2).precedes(new Vector2d(3, 3)));
        Assertions.assertTrue(new Vector2d(-1, -1).precedes(new Vector2d(3, 3)));
        Assertions.assertFalse(new Vector2d(2, 2).precedes(new Vector2d(1, 2)));
    }

    @Test
    public void followsTest() {
        Assertions.assertTrue(new Vector2d(2, 2).follows(new Vector2d(1, 1)));
        Assertions.assertTrue(new Vector2d(3, 4).follows(new Vector2d(2, 1)));
        Assertions.assertFalse(new Vector2d(2, 2).follows(new Vector2d(4, 5)));

    }

    @Test
    public void upperRightTest() {
        Assertions.assertEquals(new Vector2d(5, 5), new Vector2d(5, 2).upperRight(new Vector2d(1, 5)));
        Assertions.assertEquals(new Vector2d(1, 5), new Vector2d(0, 2).upperRight(new Vector2d(1, 5)));
        Assertions.assertEquals(new Vector2d(3, 5), new Vector2d(0, 2).upperRight(new Vector2d(3, 5)));
    }

    @Test
    public void lowerLeftTest() {
        Assertions.assertEquals(new Vector2d(1, 1), new Vector2d(1, 3).lowerLeft(new Vector2d(4, 1)));
        Assertions.assertEquals(new Vector2d(4, 1), new Vector2d(6, 3).lowerLeft(new Vector2d(4, 1)));
        Assertions.assertEquals(new Vector2d(1, 0), new Vector2d(1, 0).lowerLeft(new Vector2d(4, 1)));
    }

    @Test
    public void addTest() {
        Assertions.assertEquals(new Vector2d(5,6),new Vector2d(2,3).add(new Vector2d(3,3)));
        Assertions.assertEquals(new Vector2d(9,10),new Vector2d(7,5).add(new Vector2d(2,5)));
        Assertions.assertEquals(new Vector2d(-1,4),new Vector2d(0,3).add(new Vector2d(-1,1)));
    }
    @Test
    public void subtractTest(){
        Assertions.assertEquals(new Vector2d(3,4),new Vector2d(5,7).subtract(new Vector2d(2,3)));
        Assertions.assertEquals(new Vector2d(3,-1),new Vector2d(5,2).subtract(new Vector2d(2,3)));
        Assertions.assertEquals(new Vector2d(-5,4),new Vector2d(3,7).subtract(new Vector2d(8,3)));
    }
    @Test
    public void oppositeTest(){
        Assertions.assertEquals(new Vector2d(2,-2),new Vector2d(-2,2).opposite());
        Assertions.assertEquals(new Vector2d(3,7),new Vector2d(-3,-7).opposite());
        Assertions.assertEquals(new Vector2d(-7,-5),new Vector2d(7,5).opposite());
    }
}
