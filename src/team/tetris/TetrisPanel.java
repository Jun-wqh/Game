package team.tetris;


import team.tetris.block.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    int score = 0;
    Timer timer;

    public TetrisPanel(IntoPanel intoPanel) {
        timer = new Timer(1000, new ActionListener() {

            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
                turnh++;
                draw("mD");
            }
        });
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
                        draw("mU");
                        break;
                    case KeyEvent.VK_DOWN:
                        clear();
                        turnh++;
                        draw("mD");
                        break;
                    case KeyEvent.VK_RIGHT:
                        clear();
                        if (turnw < 10 - block.width) {
                            turnw++;
                        }
                        draw("mR");
                        break;
                    case KeyEvent.VK_LEFT:
                        clear();
                        if (turnw > 0) {
                            turnw--;
                        }
                        draw("nA");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        timer.start();
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
            if ("mD".equals(key)) {
                boolean bottoms = false;
                for (int w = 0; w < block.width; w++) {
                    for (int h = block.height - 1; h >= 0; h--) {
                        if (block.blocks[h][w] == 1) {
                            if (turnh + h < 20 && status[turnh + h][turnw + w] == 1) {
                                bottoms = true;
                                break;
                            }
                        }
                    }
                    if (bottoms) {
                        stop = true;
                        turnh--;
                        break;
                    }
                }
            }
            if ("nA".equals(key)) {
                boolean lefts = false;
                for (int h = 0; h < block.height; h++) {
                    for (int w = 0; w < block.width; w++) {
                        if (block.blocks[h][w] == 1) {
                            if (turnw + h >= 0 && status[turnh + h][turnw + w] == 1) {
                                lefts = true;
                                break;
                            }
                        }
                    }
                    if (lefts) {
                        turnw++;
                        break;
                    }
                }
            }
            if ("mR".equals(key)) {
                boolean rigths = false;
                for (int h = 0; h < block.height; h++) {
                    for (int w = block.width - 1; w >= 0; w--) {
                        if (block.blocks[h][w] == 1) {
                            if (turnw + h <= 10 && status[turnh + h][turnw + w] == 1) {
                                rigths = true;
                                break;
                            }
                        }
                    }
                    if (rigths) {
                        turnw--;
                        break;
                    }
                }
            }
            // 旋转判断
            if ("mU".equals(key)) {
                boolean turns = false;
                for (int h = 0; h < block.height; h++) {
                    for (int w = 0; w < block.width; w++) {
                        if (block.blocks[h][w] == 1) {
                            if (turnw + h >= 0 && turnw + h <= 10 && status[turnh + h][turnw + w] == 1) {
                                turns = true;
                                break;
                            }
                        }
                    }
                    if (turns) {
                        block.turni();
                        break;
                    }
                }
            }
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
            Set<Integer> clearList = new HashSet<>();
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
                score += clearList.size();
                List<Integer[]> newList = new ArrayList<>();
                for (int i = 19; i >= 0; i--) {
                    if (!clearList.contains(i)) {
                        newList.add(status[i]);
                    }
                }
                status = new Integer[20][10];
                System.out.println(newList.size());
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
            // 检测死亡
            for (int i = 0; i < 10; i++) {
                if (status[0][i] == 1) {
                    JOptionPane.showMessageDialog(null, "到顶层，游戏结束", "GAME OVER!", JOptionPane.ERROR_MESSAGE);
                    timer.stop();
                    return;
                }
            }
            turnh = 0;
            turnw = 4;
            block = intoPanel.getNext();
            draw(null);
            intoPanel.next();
        }
    }

    int space = 10;
    int level = 1;

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
        if (score > space && level < 8) {
            for (int i = 0; i < level; i++) {
                space += 10;
            }
            level++;
            // 调速度
            timer.setDelay(1000 - 120 * level);
        }
        intoPanel.setScore(score, level);

    }
}
