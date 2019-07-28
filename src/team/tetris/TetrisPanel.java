package team.tetris;


import team.tetris.block.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Jun-wqh
 */
public class TetrisPanel extends JPanel {

    IntoPanel intoPanel;
    JLabel[][] blocks;
    Integer turnx;
    Integer turny;
    Block block;

    public TetrisPanel(IntoPanel intoPanel) {
        this.intoPanel = intoPanel;
        this.setLayout(new GridLayout(20, 10));
        blocks = new JLabel[20][10];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                blocks[i][j] = new JLabel();
                blocks[i][j].setOpaque(true);
                this.add(blocks[i][j]);
            }
        }
        turnx = 1;
        turny = 5;
        block = intoPanel.getNext();
        draw();
        intoPanel.next();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                clear();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        block.turn();
                        draw();
                        break;
                    case KeyEvent.VK_DOWN:
                        turnx++;
                        draw();
                        break;
                    case KeyEvent.VK_RIGHT:
                        turny++;
                        draw();
                        break;
                    case KeyEvent.VK_LEFT:
                        turny--;
                        draw();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void clear() {
        for (int i = 0; i < block.width; i++) {
            for (int j = 0; j < block.height; j++) {
                if (block.blocks[i][j] == 1) {
                    blocks[i + turnx - 1][j + turny - 1].setBackground(null);
                }
            }
        }
    }

    public void draw() {
        for (int i = 0; i < block.width; i++) {
            for (int j = 0; j < block.height; j++) {
                if (block.blocks[i][j] == 1) {
                    blocks[i + turnx - 1][j + turny - 1].setBackground(Color.BLACK);
                }
            }
        }
    }

}
