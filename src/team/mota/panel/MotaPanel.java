package team.mota.panel;

import team.mota.pos.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Jun-wqh seeyul
 */
public class MotaPanel extends JPanel {

    JLabel[][] labels;
    Font f = new Font("宋体", Font.BOLD, 40);
    Hero hero;

    PropertyPanel propertyPanel;
    int level = 1;
    Integer[][] maps;

    public MotaPanel(PropertyPanel propertyPanel) {
        this.propertyPanel = propertyPanel;
        hero = new Hero(10, 5, level);
        propertyPanel.setHero(hero);
        this.setLayout(new GridLayout(11, 11));
        this.setBackground(Color.lightGray);
        maps = MotaMap.motemap.get(level);
        labels = new JLabel[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                labels[i][j] = new JLabel();
                ImageIcon icon = new ImageIcon("src\\team\\mota\\res\\" + maps[i][j] + ".png");
                icon.setImage(icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                labels[i][j].setIcon(icon);
                this.add(labels[i][j]);
            }
        }

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int xx = hero.x;
                int yy = hero.y;
                Boolean result = false;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        result = hero.up();
                        break;
                    case KeyEvent.VK_DOWN:
                        result = hero.down();
                        break;
                    case KeyEvent.VK_RIGHT:
                        result = hero.right();
                        break;
                    case KeyEvent.VK_LEFT:
                        result = hero.left();
                        break;
                    default:
                        break;
                }
                if (result) {
                    if (hero.article.get("level") == level) {
                        int rx = hero.x;
                        int ry = hero.y;
                        ImageIcon icon = new ImageIcon("src\\team\\mota\\res\\10.png");
                        icon.setImage(icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                        labels[xx][yy].setIcon(icon);
                        icon = new ImageIcon("src\\team\\mota\\res\\100.png");
                        icon.setImage(icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                        labels[rx][ry].setIcon(icon);
                        propertyPanel.setHero(hero);
                    } else {
                        level = hero.article.get("level");
                        //换楼层
                        maps = MotaMap.motemap.get(level);
                        for (int i = 0; i < 11; i++) {
                            for (int j = 0; j < 11; j++) {
                                ImageIcon icon = new ImageIcon("src\\team\\mota\\res\\" + maps[i][j] + ".png");
                                icon.setImage(icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                                labels[i][j].setIcon(icon);
                            }
                        }
                    }
                } else {
                    propertyPanel.setHero(hero);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}
