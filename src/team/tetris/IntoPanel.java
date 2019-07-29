package team.tetris;


import team.tetris.block.Block;
import team.tetris.block.BlockMap;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jun-wqh
 */
public class IntoPanel extends JPanel {

    private Integer score = 0;
    private Integer level = 1;
    private JLabel[][] into;
    private Block block;
    private JLabel scoretext;
    private JLabel leveltext;
    private Font font = new Font("宋体", Font.BOLD, 30);

    public IntoPanel() {
        this.setLayout(new GridLayout(5, 1));
        JPanel next = new JPanel();
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
        scoretext = new JLabel();
        scoretext.setText("分数:" + score);
        scoretext.setFont(font);
        this.add(scoretext);
        leveltext = new JLabel();
        leveltext.setText("级别:" + level);
        leveltext.setFont(font);
        this.add(leveltext);
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

    public void setScore(Integer score, Integer level) {
        this.score = score;
        this.level = level;
        scoretext.setText("分数:" + score);
        leveltext.setText("级别:" + level);

    }
}
