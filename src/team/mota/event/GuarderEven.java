package team.mota.event;

import team.mota.panel.MotaMap;
import team.mota.pos.Hero;

/**
 * @author: wuyu
 * @date: 2019/8/4
 */
public class GuarderEven {

    //守卫事件
    public static void guard(Hero hero, Integer monter, Integer door) {
        Integer[][] map = hero.maps;
        int number = 0;
        for (int j = 0; j < 11; j++) {
            for (int k = 0; k < 11; k++) {
                if (map[j][k].equals(monter)) {
                    number += 1;
                }
            }
        }
        if (number == 1) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    if (map[j][k].equals(door)) {
                        map[j][k] = MotaMap.rA;
                    }
                }
            }
            hero.change = true;
        }
    }

    public static void foolr11Guard(Hero hero) {
        Integer[][] map = hero.maps;
        if (map[4][0] != MotaMap.mS && map[4][1] != MotaMap.mS) {
            hero.maps[3][1] = MotaMap.rA;
            hero.change = true;
        }
    }

    //第十层小怪围困事件
    public static void foolr10Guard(Hero hero) {
        Integer[][] map = hero.maps;
        int num = 1;
        for (int i = 4; i <= 6; i++) {
            for (int j = 3; j <= 5; j++) {
                if (map[j][i] == MotaMap.rA) {
                    num += 1;
                }
            }
        }
        if (num == 8) {
            map[2][5] = MotaMap.rA;
            hero.change = true;
        }
    }


}
