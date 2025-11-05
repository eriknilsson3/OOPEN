package examinerande3.controller;

import examinerande3.model.PuzzleModel;
import examinerande3.view.PuzzleView;

public class PuzzleController {
    private PuzzleModel model;
    private PuzzleView view;

    public PuzzleController() {
        model = new PuzzleModel();
        model.newGame();
        view = new PuzzleView(this, model.getSize());
        updateView();
    }

    public void tileClicked(int r, int c) {
        if (model.move(r, c)){
            updateView();
            if (model.isSolved()){
                view.showWinMessage();
            }
        }
    }

    public void newGame(){
        model.newGame();
        updateView();
    }

    private void updateView(){
        int size = model.getSize();
        String[][] grid = new String[size][size];
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                grid[r][c] = model.getValue(r, c);
            }
        }
        view.updateBoard(grid);
    }
}
