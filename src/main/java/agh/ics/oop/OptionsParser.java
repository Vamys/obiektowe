package agh.ics.oop;

public class OptionsParser {
        public static MoveDirection[] parse(String[] tab) {
            MoveDirection[] directionsTab = new MoveDirection[tab.length];
            MoveDirection x;
            for (int i = 0; i < tab.length; i++) {
                x = switch (tab[i]) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> MoveDirection.DEFAULT;
                };
                directionsTab[i] = x;
            }
            return directionsTab;
        }
}
