package Rover;

import lombok.Data;

@Data
public class Grid {
    private int width;
    private int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
