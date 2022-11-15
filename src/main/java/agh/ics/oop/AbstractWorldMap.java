package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected Vector2d upperRight;
    protected Vector2d lowerLeft;
    protected List<IMapElement> mapElements = new ArrayList<>();

    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            return false;
        }
        this.mapElements.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(int i = mapElements.size() - 1; i >= 0; i--){
            if (mapElements.get(i).getPosition().equals(position)){
                return mapElements.get(i);
            }
        }
        return null;
    }
}
