package Rover;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class MarsRover {
    private int x;
    private int y;
    private String orientation;

    public MarsRover(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void move() {
        y++;
    }

    public void turn(String direction) {
        List<String> rule = Arrays.asList("N", "E", "S", "W");
        int index = rule.indexOf(orientation);
        index = direction.equals("L") ? (index - 1 < 0 ? 3 : index - 1) : (index + 1 > 3 ? 0 : index + 1);
        orientation = rule.get(index);
    }
}
