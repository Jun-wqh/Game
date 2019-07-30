package team.mota.panel;


import team.mota.pos.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class FlyPanel extends JPanel {
    Font font = new Font("宋体", Font.BOLD, 15);

    Set<Integer> levelA = new HashSet<>();
    JButton[] jButtons;

    public FlyPanel() {
        this.removeAll();
        this.repaint();
        this.setLayout(new GridLayout(7, 8));
        jButtons = new JButton[55];
        for (int i = 0; i < 55; i++) {
            jButtons[i] = new JButton("第" + (i + 1) + "层");
            jButtons[i].setMargin(new java.awt.Insets(0, 0, 0, 0));
            jButtons[i].setVisible(false);
            this.add(jButtons[i]);
        }
        this.revalidate();
    }

    public void sync(Set<Integer> levelSet, Hero hero, JFrame frame, MotaPanel motaPanel) {
        for (int i = 0; i < 55; i++) {
            int level = i + 1;
            if (levelSet.contains(level) && !levelA.contains(i)) {
                levelA.add(i);
                jButtons[i].setVisible(true);
                jButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        // 楼层跳转
                    }
                });

            }
        }
    }


}
