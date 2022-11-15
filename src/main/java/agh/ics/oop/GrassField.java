package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap {

    public GrassField(int numOfGrassFields) {
        int Min = 0;
        double Max = Math.sqrt(numOfGrassFields * 10);
        for (int i = 0; i < numOfGrassFields; i++) {
            int x = Min + (int) (Math.random() * ((Max - Min) + 1));
            int y = Min + (int) (Math.random() * ((Max - Min) + 1));
            this.mapElements.add(new Grass(new Vector2d(x, y)));
        }
    }

    public String toString() {
        int x1 = Integer.MIN_VALUE;
        int y1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE;
        int y2 = Integer.MAX_VALUE;
        for (IMapElement mapElement : mapElements) {
            Vector2d v = mapElement.getPosition();
            x1 = Math.max(x1,v.x);
            y1 = Math.max(y1,v.y);
            x2 = Math.min(x2,v.x);
            y2 = Math.min(y2,v.y);
        }
        this.lowerLeft = new Vector2d(x2, y2);
        this.upperRight = new Vector2d(x1, y1);
        return super.toString();
    }
}
