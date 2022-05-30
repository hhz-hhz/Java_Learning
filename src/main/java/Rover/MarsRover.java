package Rover;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarsRover {
    protected int x;
    protected int y;
    protected String orientation;

    public void move(Grid grid) {
        switch (orientation){
            case "N":
                y++;
                break;
            case "S":
                y--;
                break;
            case "W":
                x--;
                break;
            case "E":
                x++;
        }
        borderMove(grid);
    }

    public void borderMove(Grid grid){
        x = (x < 0 ? 0 : (Math.min(x, grid.getWidth())));
        y = (y < 0 ? 0 : (Math.min(y, grid.getHeight())));
    }

    public void turn(String direction) {
        List<String> rule = Arrays.asList("N", "E", "S", "W");
        int index = rule.indexOf(orientation);
        index = direction.equals("L") ? (index - 1 < 0 ? 3 : index - 1) : (index + 1 > 3 ? 0 : index + 1);
        orientation = rule.get(index);
    }
}
