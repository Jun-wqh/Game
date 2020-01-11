package team.mota.panel;

import team.mota.pos.Hero;
import team.mota.pos.Monster;
import team.mota.pos.MonstrtMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookPanel extends JPanel {


    public void book(Hero hero, JFrame frame) {
        this.removeAll();
        frame.setVisible(false);
        Integer[][] map = hero.maps;
        Map<Integer, Monster> monsterMap = MonstrtMap.monsterMap;
        Set<Integer> monsterSet = new HashSet<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (monsterMap.containsKey(map[i][j])) {
                    monsterSet.add(map[i][j]);
                }
            }
        }
        ArrayList<Integer> monsterList = new ArrayList<>(monsterSet);
        this.setLayout(new GridLayout(monsterList.size(), 6));
        JLabel[][] labels = new JLabel[10][6];
        for (int i = 0; i < monsterList.size(); i++) {
            labels[i][0] = new JLabel();
            labels[i][1] = new JLabel();
            labels[i][2] = new JLabel();
            labels[i][3] = new JLabel();
            labels[i][4] = new JLabel();
            labels[i][5] = new JLabel();
            Monster monster = monsterMap.get(monsterList.get(i));
            ImageIcon icon = new ImageIcon("src\\team\\mota\\res\\" + monsterList.get(i) + ".png");
            labels[i][0].setIcon(icon);
            labels[i][1].setText("生命:" + monster.hp);
            labels[i][2].setText("攻击力:" + monster.atk);
            labels[i][3].setText("防御力:" + monster.def);
            labels[i][4].setText("金币:" + monster.money);
            labels[i][5].setText("伤害:" + atk(hero, monster));
            this.add(labels[i][0]);
            this.add(labels[i][1]);
            this.add(labels[i][2]);
            this.add(labels[i][3]);
            this.add(labels[i][4]);
            this.add(labels[i][5]);

        }
    }

    public String atk(Hero hero, Monster monster) {
        int monsterHp = monster.hp;
        int heroAtk = hero.article.get("atk");
        int heroDef = hero.article.get("atk");
        int heroHp = hero.article.get("hp");
        int hp = 0;
        if (heroAtk <= monster.def) {
            return "打不过";
        }
        for (; ; ) {
            monsterHp -= heroAtk - monster.def;
            if (monsterHp <= 0 && heroHp > 0) {
                if (hp < 0) {
                    hp = 0;
                }
                return hp + "";
            }
            heroHp -= monster.atk - heroDef;
            hp += monster.atk - heroDef;
        }
    }
}
