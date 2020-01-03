package team.mota.event;

import team.mota.panel.MotaMap;
import team.mota.pos.Hero;

/**
 * @author: wuyu
 * @date: 2019/8/4
 */
public class GuarderEven {

    //低级守卫事件
    public static void lowGuarder(Hero hero) {
        Integer[][] map = hero.maps;
        if (map[4][8] != MotaMap.mQ || map[4][10] != MotaMap.mQ) {
            hero.maps[3][9] = MotaMap.rA;
            hero.change = true;
        }
    }

    //中级守卫事件
    public static void middleGuarder(Hero hero) {
        Integer[][] map = hero.maps;
        if (map[1][5] != MotaMap.mJ || map[1][7] != MotaMap.mJ) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    if (map[j][k] == MotaMap.dE) {
                        map[j][k] = MotaMap.rA;
                    }
                }
            }
            hero.change = true;
        }
    }

    //高级守卫事件
    public static void highGuarder(Hero hero) {

    }

    public static void foolr10Guarder(Hero hero) {
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
