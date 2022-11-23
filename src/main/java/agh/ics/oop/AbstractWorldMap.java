package agh.ics.oop;

import java.util.HashMap;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected Vector2d upperRight;
    protected Vector2d lowerLeft;
    protected HashMap<Vector2d, IMapElement> mapElements = new HashMap<Vector2d, IMapElement>();

    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())){
            this.mapElements.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public IMapElement objectAt(Vector2d position) {
        return mapElements.get(position);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        mapElements.put(newPosition,mapElements.get(oldPosition));
        mapElements.remove(oldPosition);
    }
}
