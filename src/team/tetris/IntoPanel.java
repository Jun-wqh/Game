package team.tetris;


import team.tetris.block.Block;
import team.tetris.block.BlockMap;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jun-wqh
 */
public class IntoPanel extends JPanel {

    Integer score;
    JPanel next;
    JLabel[][] into;
    Block block;

    public IntoPanel() {
        this.setLayout(new GridLayout(5, 1));
        next = new JPanel();
        next.setSize(120, 120);
        next.setLayout(new GridLayout(4, 4));
        into = new JLabel[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                into[i][j] = new JLabel();
                into[i][j].setOpaque(true);
                next.add(into[i][j]);
            }
        }
        this.add(next);
        next();
    }

    public void next() {
        block = BlockMap.getBlock();
        Integer[][] blocks = block.blocks;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (blocks[i][j] == 1) {
                    into[i][j].setBackground(Color.BLACK);
                } else {
                    into[i][j].setBackground(null);
                }
            }
        }
    }

    public Block getNext() {
        return block;
    }


}
