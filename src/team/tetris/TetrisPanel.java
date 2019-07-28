package team.tetris;


import javax.swing.*;
import java.awt.*;

/**
 * @author Jun-wqh
 */
public class TetrisPanel extends JPanel {

    IntoPanel intoPanel;

    public TetrisPanel(IntoPanel intoPanel) {
        this.intoPanel = intoPanel;
        this.setLayout(new GridLayout(10, 20));
    }
}
