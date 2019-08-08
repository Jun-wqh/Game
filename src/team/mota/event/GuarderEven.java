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
        if (map[4][8] != MotaMap.q || map[4][10] != MotaMap.q) {
            hero.maps[3][9] = MotaMap.L;
            hero.change = true;
        }
    }

    //中级守卫事件
    public static void middleGuarder(Hero hero) {
        Integer[][] map = hero.maps;
        if (map[1][5] != MotaMap.j || map[1][7] != MotaMap.j) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    if (map[j][k] == MotaMap.G) {
                        map[j][k] = MotaMap.L;
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
                if (map[j][i] == MotaMap.L) {
                    num += 1;

                }
            }
        }
        if (num == 8) {
            map[2][5] = MotaMap.L;
            hero.change = true;
        }
    }
}
