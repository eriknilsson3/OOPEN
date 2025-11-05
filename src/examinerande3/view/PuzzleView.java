package examinerande3.view;

import javax.swing.*;
import java.awt.*;
import examinerande3.controller.PuzzleController;

public class PuzzleView extends JFrame {
    private JButton[][] buttons;
    private JButton newGameButton;

    public PuzzleView(PuzzleController controller, int size) {
        setTitle("15 Spelet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buttons = new JButton[size][size];
        JPanel boardPanel = new JPanel(new GridLayout(size, size));
        Font font = new Font("Arial", Font.BOLD, 32);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                JButton btn = new JButton();
                btn.setFont(font);
                int finalR = r;
                int finalC = c;
                btn.addActionListener(e -> controller.tileClicked(finalR, finalC));
                buttons[r][c] = btn;
                boardPanel.add(btn);
            }
        }

        JPanel controlPanel = new JPanel();
        newGameButton = new JButton("Nytt spel");
        newGameButton.addActionListener(e -> controller.newGame());
        controlPanel.add(newGameButton);

        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setSize(400, 400);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateBoard(String[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                String tileValue = grid[r][c];
                buttons[r][c].setText(grid[r][c]);
            }
        }
    }

    public void showWinMessage() {
        JOptionPane.showMessageDialog(this, "Grattis, du har vunnit!!");
    }
}
