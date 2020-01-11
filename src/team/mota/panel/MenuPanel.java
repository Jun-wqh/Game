package team.mota.panel;

import team.mota.pos.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * @version V1.0.0
 * @Description:
 * @author: seeyul
 * @date: 2020/1/10
 */
public class MenuPanel extends JPanel {

    MotaPanel motaPanel;
    JLabel[][] labels;
    Set<Integer> levelSet = new HashSet<>();

    public void setMotaPanel(MotaPanel motaPanel) {
        this.motaPanel = motaPanel;
    }

    public MenuPanel() {
        this.setLayout(new GridLayout(11, 12));
        labels = new JLabel[11][2];
        for (int i = 0; i < 11; i++) {
            labels[i][0] = new JLabel();
            labels[i][1] = new JLabel();
            this.add(labels[i][0]);
            this.add(labels[i][1]);
        }
    }

    public void setHero(Hero hero) {
        levelSet.add(hero.article.get("level"));
        if (hero.fly) {
            fly(hero);
            hero.fly = false;
        }
        if (hero.book) {
            book(hero);
            hero.book = false;
        }
        if (hero.gold) {
            gold();
            hero.gold = false;
        }
        if (hero.note) {
            note();
            hero.gold = true;
        }
        if (hero.magma) {
            magma(hero);
            hero.magma = false;
        }
    }

    public void fly(Hero hero) {
        JFrame frame = new JFrame("飞行器");
        FlyPanel flyPanel = new FlyPanel();
        frame.add(flyPanel);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screensize = tk.getScreenSize();
        int height = screensize.height;
        int width = screensize.width;
        frame.setBounds(width / 2 - 180, height / 2 - 100, 400, 400);
        frame.setLocationRelativeTo(null);
        ImageIcon icon1 = new ImageIcon("src\\team\\mota\\res\\21.png");
        icon1.setImage(icon1.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        labels[0][0].setIcon(icon1);
        labels[0][0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                flyPanel.sync(levelSet, hero, frame, motaPanel);
                frame.setVisible(true);
            }
        });
    }

    public void book(Hero hero) {
        ImageIcon icon2 = new ImageIcon("src\\team\\mota\\res\\26.png");
        icon2.setImage(icon2.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        labels[0][1].setIcon(icon2);
        JFrame frame = new JFrame("怪物图鉴");
        BookPanel bookPanel = new BookPanel();
        frame.add(bookPanel);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screensize = tk.getScreenSize();
        int height = screensize.height;
        int width = screensize.width;
        frame.setBounds(width / 2 - 180, height / 2 - 100, 500, 500);
        frame.setLocationRelativeTo(null);
        labels[0][1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookPanel.book(hero, frame);
                frame.setVisible(true);
            }
        });
    }

    public void gold() {
        ImageIcon icon2 = new ImageIcon("src\\team\\mota\\res\\" + MotaMap.pM + ".png");
        icon2.setImage(icon2.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        labels[1][0].setIcon(icon2);
    }

    private void note() {
        ImageIcon icon2 = new ImageIcon("src\\team\\mota\\res\\" + MotaMap.pL + ".png");
        icon2.setImage(icon2.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        labels[1][1].setIcon(icon2);
    }

    private void magma(Hero hero) {
        ImageIcon icon2 = new ImageIcon("src\\team\\mota\\res\\" + MotaMap.pP + ".png");
        icon2.setImage(icon2.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        labels[2][0].setIcon(icon2);
        labels[2][0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer[][] map = hero.maps;
                for (int x = 0; x < 11; x++) {
                    for (int y = 0; y < 11; y++) {
                        if (map[x][y] == MotaMap.rC) {
//                            motaPanel.labels[i][j];
                            map[x][y] = MotaMap.rA;
                        }
                        ImageIcon icon = new ImageIcon("src\\team\\mota\\res\\" + hero.maps[x][y] + ".png");
                        icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                        motaPanel.labels[x][y].setIcon(icon);
                    }
                }
            }
        });
    }
}
