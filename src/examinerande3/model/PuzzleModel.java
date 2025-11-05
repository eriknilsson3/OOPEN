package examinerande3.model;

import java.util.*;

public class PuzzleModel {
    private final int size = 4;
    private String[][] grid;
    private int emptyRow, emptyCol;

    public PuzzleModel() {
        newGame();
    }

    public void newGame() {
        List<String> tiles = new ArrayList<>();
        for (int i = 1; i<= 15; i++) tiles.add(String.valueOf(i));
        tiles.add("");

        do{
            Collections.shuffle(tiles);
        } while (!isSolvable(tiles));

        grid = new String[size][size];
        int index = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = tiles.get(index++);
                if (grid[r][c].equals("")) {
                    emptyRow = r;
                    emptyCol = c;
                }
            }
        }
    }

    public String getValue(int r, int c) {
        return grid[r][c];
    }

    public int getSize() {
        return size;
    }
    public boolean move(int r, int c) {
        if ((Math.abs(r - emptyRow) == 1 && c == emptyCol) ||
            (Math.abs(c - emptyCol) == 1 && r == emptyRow)){

            String temp = grid[r][c];
            grid[r][c] = grid[emptyRow][emptyCol];
            grid[emptyRow][emptyCol] = temp;
            emptyRow = r;
            emptyCol = c;
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        int num = 1;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                String val = grid[r][c];
                if (r == size - 1 && c == size - 1) {
                    if (!val.equals("")) return false;
                } else if (!val.equals(String.valueOf(num++))) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isSolvable(List<String> values) {
        int inverse = 0;
        List<Integer> nums = new ArrayList<>();
        for (String v : values) {
            if (!v.equals("")) nums.add(Integer.parseInt(v));
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) > nums.get(j)) inverse++;
            }
        }
        int emptyPos = values.indexOf("");
        int emptyRowFromBottom = size - (emptyPos / size);
        if (size % 2 == 1) {
            return inverse % 2 == 0;
        } else  {
            return (emptyRowFromBottom % 2 == 0) != (inverse % 2 == 0);
        }
    }
}
