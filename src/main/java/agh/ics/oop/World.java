package agh.ics.oop;

import java.util.Map;

import static java.lang.System.out;

class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return '(' + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
    }

    public boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y) return true;
        else return false;
    }

    public boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) return true;
        else return false;
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d opposite() {
        return new Vector2d(this.x * -1, this.y * -1);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return Integer.compare(this.x, that.x) == 0 && Integer.compare(this.y, that.y) == 0;
    }

    public int hashCode() {
        int tmp = (this.y + ((this.x + 1) / 2));
        return this.x + (tmp * tmp);
    }
}
enum MoveDirections{
    FORWARD, BACKWARD, RIGHT, LEFT
}
enum MapDirections {
    NORTH, SOUTH, WEST, EAST;

    public String toString() {
        switch (this) {
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
        }
        return null;
    }

    public MapDirections next() {
        switch (this) {
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
        }
        return null;
    }
    public MapDirections previous(){
        switch (this){
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;

        }
        return null;
    }
    public Vector2d toUnitVector(){
        switch (this){
            case EAST:
                return new Vector2d(1,0);
            case WEST:
                return new Vector2d(-1,0);
            case NORTH:
                return new Vector2d(0,1);
            case SOUTH:
                return new Vector2d(0,-1);
        }
        return null;
    }
}

public class World {
    public static void main(String[] args) {

        out.println("Start");
        Directions[] Path = to_enum(args);
        run(Path);
        out.println("Stop");
    }

    public static void run(Directions[] dir) {
        for (Directions direction : dir) {
            switch (direction) {
                case f:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case b:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case r:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case l:
                    out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }

    public static Directions[] to_enum(String[] dir) {
        Directions[] enum_dir = new Directions[dir.length];
        for (int i = 0; i < dir.length; i++) {
            Directions x = switch (dir[i]) {
                case "f" -> Directions.f;
                case "b" -> Directions.b;
                case "l" -> Directions.l;
                case "r" -> Directions.r;
                default -> Directions.nan;
            };
            enum_dir[i] = x;
        }
        out.println(enum_dir);
        return enum_dir;
    }
}
