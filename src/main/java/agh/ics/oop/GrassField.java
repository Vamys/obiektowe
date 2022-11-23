package agh.ics.oop;



public class GrassField extends AbstractWorldMap {
    private final double Max;

    public GrassField(int numOfGrassFields) {
        int Min = 0;
        Vector2d v;
        int x;
        int y;
        this.Max = Math.sqrt(numOfGrassFields * 10);
        for (int i = 0; i < numOfGrassFields; i++) {

            do{
                x = Min + (int) (Math.random() * ((this.Max - Min) + 1));
                y = Min + (int) (Math.random() * ((this.Max - Min) + 1));
                v = new Vector2d(x,y);
            } while (objectAt(v) != null);
            this.mapElements.put(v,new Grass(v));
        }
    }


    public String toString() {
        for (Vector2d key : mapElements.keySet()) {
            if (lowerLeft == null && upperRight == null) {
                this.lowerLeft = key;
                this.upperRight = key;
            } else {
                this.upperRight = this.upperRight.upperRight(key);
                this.lowerLeft = this.lowerLeft.lowerLeft(key);
            }
        }
        return super.toString();
    }
    private void replaceGrass(Vector2d position){
        int Min = 0;
        int x;
        int y;
        Vector2d v;
        do{
            x = Min + (int) (Math.random() * ((this.Max - Min) + 1));
            y = Min + (int) (Math.random() * ((this.Max - Min) + 1));
            v = new Vector2d(x,y);
        } while (objectAt(v) != null);
        positionChanged(position,v);
    }
    public void addGrass(Vector2d position){
        Grass g = new Grass(position);
        this.mapElements.put(position,g);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (objectAt(newPosition) instanceof Grass){
            replaceGrass(newPosition);
        }
        super.positionChanged(oldPosition,newPosition);
    }
}
