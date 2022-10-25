package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void bigTest(){
        String[] moves = new String[]{"f","forward","g","l","right","f","right","f","f"};
        MoveDirection[] moves2 = OptionsParaser.parse(moves);
        Assertions.assertArrayEquals(moves2,new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.DEFAULT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD});
        Animal turtle = new Animal();
        for(MoveDirection direction : moves2){
            turtle.move(direction);
        }
        Assertions.assertTrue(turtle.isAt(new Vector2d(4,4)));
        Assertions.assertEquals(turtle.toString(),"East (4,4)");
    }
}
//[FORWARD, FORWARD, DEFAULT, LEFT, RIGHT, FORWARD, RIGHT, FORWARD, FORWARD]>
