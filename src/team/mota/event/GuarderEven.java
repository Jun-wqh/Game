package team.mota.event;

import team.mota.panel.MotaMap;
import team.mota.pos.Hero;

import javax.swing.*;
import java.util.Map;

/**
 * @author: wuyu
 * @date: 2019/8/4
 */
public class GuarderEven extends JPanel{

    private Map<Integer, Integer[][]> motemap = MotaMap.motemap;

    public void lowGuarder(Hero hero) {
        Integer[][] map = motemap.get(hero.article.get("level"));
        for (int i = 8; i < 11; i++) {
            if (map[4][8] != MotaMap.q || map[4][10] != MotaMap.q) {
                map[3][9] = MotaMap.L;
            }
        }
    }
    public void middleGuarder(Hero hero) {
    }
}
