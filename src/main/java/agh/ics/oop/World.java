package agh.ics.oop;
import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.Arrays;
public class World {
    public static void main(String[] dir)  {
        out.println("Start");
        Scanner scanner = new Scanner(in);
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        Directions[] Path = to_enum(numbers);
        run(Path);
        out.println("Stop");
    }
    public static void run(Directions[] dir){
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
    public static Directions[] to_enum(String[] dir){
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
        return enum_dir;
    }
}
