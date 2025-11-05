package examinerande3;

import javax.swing.SwingUtilities;
import examinerande3.controller.PuzzleController;

public class Examinerande3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PuzzleController::new);
    }
}
