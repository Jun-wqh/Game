package team.tetris;


import team.tetris.block.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun-wqh
 */
public class TetrisPanel extends JPanel {

    IntoPanel intoPanel;
    JLabel[][] blocks;
    Integer[][] status;
    Integer turnh;
    Integer turnw;
    Block block;

    public TetrisPanel(IntoPanel intoPanel) {
        this.intoPanel = intoPanel;
        this.setLayout(new GridLayout(20, 10));
        blocks = new JLabel[20][10];
        status = new Integer[20][10];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                status[i][j] = 0;
                blocks[i][j] = new JLabel();
                blocks[i][j].setOpaque(true);
                this.add(blocks[i][j]);
            }
        }
        turnh = 0;
        turnw = 4;
        block = intoPanel.getNext();
        draw(null);
        intoPanel.next();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        clear();
                        if (turnw + block.height > 10) {
                            turnw = 10 - block.height;
                        }
                        block.turn();
                        draw("u");
                        break;
                    case KeyEvent.VK_DOWN:
                        clear();
                        turnh++;
                        draw("d");
                        break;
                    case KeyEvent.VK_RIGHT:
                        clear();
                        if (turnw < 10 - block.width) {
                            turnw++;
                        }
                        draw("r");
                        break;
                    case KeyEvent.VK_LEFT:
                        clear();
                        if (turnw > 0) {
                            turnw--;
                        }
                        draw(null);
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
        for (int i = 0; i < block.height; i++) {
            for (int j = 0; j < block.width; j++) {
                if (block.blocks[i][j] == 1) {
                    blocks[i + turnh][j + turnw].setBackground(null);
                }
            }
        }
    }

    public void draw(String key) {
        boolean stop = false;
        if (turnh + block.height > 20) {
            turnh--;
            stop = true;
        } else {
            // 障碍物判断
            if ("d".equals(key)) {
                boolean[] bottoms = new boolean[block.width];
                for (int w = 0; w < block.width; w++) {
                    for (int h = block.height - 1; h >= 0; h--) {
                        if (block.blocks[h][w] == 1) {
                            if (turnh + h < 20 && status[turnh + h][turnw + w] == 1) {
                                bottoms[w] = true;
                                break;
                            }
                        }
                    }
                    if (bottoms[w]) {
                        stop = true;
                        turnh--;
                    }
                }
            }
            if ("l".equals(key)) {
                boolean[] lefts = new boolean[block.height];
                for (int h = 0; h < block.height; h++) {
                    for (int w = 0; w < block.width; w++) {
                        if (block.blocks[h][w] == 1) {
                            if (turnw + h >= 0 && status[turnh + h][turnw + w] == 1) {
                                lefts[h] = true;
                                break;
                            }
                        }
                    }
                    if (lefts[h]) {
                        turnw++;
                    }
                }
            }
            if ("r".equals(key)) {
                boolean[] rigths = new boolean[block.height];
                for (int h = 0; h < block.height; h++) {
                    for (int w = block.width - 1; w >= 0; w--) {
                        if (block.blocks[h][w] == 1) {
                            if (turnw + h <= 10 && status[turnh + h][turnw + w] == 1) {
                                rigths[h] = true;
                                break;
                            }
                        }
                    }
                    if (rigths[h]) {
                        turnw--;
                    }
                }
            }
        }
        // 旋转判断
        if ("u".equals(key)) {

        }
        for (int i = 0; i < block.height; i++) {
            for (int j = 0; j < block.width; j++) {
                if (block.blocks[i][j] == 1) {
                    blocks[i + turnh][j + turnw].setBackground(Color.BLACK);
                }
            }
        }
        if (stop) {
            for (int h = 0; h < block.height; h++) {
                for (int w = 0; w < block.width; w++) {
                    if (block.blocks[h][w] == 1) {
                        status[h + turnh][w + turnw] = 1;
                    }
                }
            }
            // 执行消除
            List<Integer> clearList = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                int count = 0;
                for (int j = 0; j < 10; j++) {
                    if (status[i][j] == 1) {
                        count++;
                    }
                }
                if (count == 10) {
                    clearList.add(i);
                }
            }
            if (clearList.size() > 0) {
                List<Integer[]> newList = new ArrayList<>();
                for (int i = 19; i >= 0; i--) {
                    if (!clearList.contains(i)) {
                        newList.add(status[i]);
                    }
                }
                for (int i = 19; i >= 0; i--) {
                    if (i > 19 - newList.size()) {
                        status[i] = newList.get(19 - i);
                    } else {
                        for (int j = 0; j < status[i].length; j++) {
                            status[i][j] = 0;
                        }
                    }
                }
                drawAll();
            }
            turnh = 0;
            turnw = 4;
            block = intoPanel.getNext();
            draw(null);
            intoPanel.next();
        }
    }

    public void drawAll() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (status[i][j] == 1) {
                    blocks[i][j].setBackground(Color.BLACK);
                } else {
                    blocks[i][j].setBackground(null);
                }
            }
        }

    }
}
