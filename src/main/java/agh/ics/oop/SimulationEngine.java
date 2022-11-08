package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final IWorldMap map;
    private final List<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startingPositions) {
        this.moves = moves;
        this.map = map;
        for (Vector2d position : startingPositions) {
            Animal turtle = new Animal(this.map, position);
            this.animals.add(turtle);
            this.map.place(turtle);
        }
    }

    @Override
    public void run() {
        int i = 0;
        for (MoveDirection move : this.moves) {
            System.out.println(move.toString());
            animals.get(i).move(move);
            i = (i + 1) % animals.size();
            System.out.println(this.map.toString());
        }
    }

}
