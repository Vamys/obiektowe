package agh.ics.oop;
import java.util.List;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap{

    private final Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width,int height){
        this.upperRight = new Vector2d(width,height);
    }

    public String toString(){
        return new MapVisualizer(this).draw(this.lowerLeft,this.upperRight);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRight) && position.follows(lowerLeft) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.animalPosition())){
            return false;
        }
        this.animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a:this.animals){
            if (a.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal a:this.animals){
            if (a.isAt((position))){
                return a;
            }
        }
        return null;
    }
}
