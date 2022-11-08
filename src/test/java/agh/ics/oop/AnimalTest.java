package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void ATest1(){
        String[] moves = new String[]{"f","forward","g","l","right","f","right","f","f"};
        MoveDirection[] moves2 = OptionsParser.parse(moves);
        Assertions.assertArrayEquals(moves2,new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.DEFAULT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD});
        Animal turtle = new Animal();
        for(MoveDirection direction : moves2){
            turtle.move(direction);
        }
        Assertions.assertTrue(turtle.isAt(new Vector2d(4,4)));
        Assertions.assertEquals(turtle.toString(),"East (4,4)");
    }
    @Test
    public void ATest2(){
        String[] moves = new String[]{"q","tt","a","2","rifdt","gd","rds","xsd","g"};
        MoveDirection[] moves2 = OptionsParser.parse(moves);
        Animal turtle = new Animal();
        for(MoveDirection direction : moves2){
            turtle.move(direction);
        }
        Assertions.assertTrue(turtle.isAt(new Vector2d(2,2)));
        Assertions.assertEquals(turtle.toString(),"North (2,2)");
    }
    @Test
    public void ATest3(){
        String[] moves = new String[]{"f","l","f","f","f"};
        MoveDirection[] moves2 = OptionsParser.parse(moves);
        Animal turtle = new Animal();
        for(MoveDirection direction : moves2){
            turtle.move(direction);
        }
        Assertions.assertTrue(turtle.isAt(new Vector2d(0,3)));
        Assertions.assertEquals(turtle.toString(),"West (0,3)");
    }
}
