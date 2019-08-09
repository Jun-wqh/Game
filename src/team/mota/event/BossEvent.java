package team.mota.event;

import team.mota.panel.MotaMap;
import team.mota.pos.Hero;

/**
 * @author: wuyu
 * @date: 2019/8/4
 */
public class BossEvent {

    public static void floor10(int monster, Hero hero) {
        int event = DialogueEvent.bossDialogue(monster, hero);
        if (event == 1) {
            Integer[][] map = hero.maps;
            for (int i = 0; i < 11; i++) {
                if (map[2][i] == MotaMap.e) {
                    map[2][i] = MotaMap.L;
                }
                if (map[3][i] == MotaMap.f) {
                    map[3][i] = MotaMap.L;
                }
            }
            for (int i = 3; i < 6; i++) {
                map[i][4] = MotaMap.e;
                map[i][6] = MotaMap.e;
            }
            map[3][5] = MotaMap.f;
            map[5][5] = MotaMap.f;
            map[0][5] = MotaMap.r;
            map[2][5] = MotaMap.Z;
            map[6][5] = MotaMap.Z;
            hero.bossEvent = 2;
        }
        if (event == 2) {
            hero.bossEvent = 3;
        }
    }

    public static void floor10Reward(Hero hero) {
        DialogueEvent.bossDialogue(MotaMap.r, hero);
        Integer[][] map = hero.maps;
        map[2][0] = MotaMap.J;
        map[2][1] = MotaMap.J;
        map[2][2] = MotaMap.J;
        map[2][8] = MotaMap.K;
        map[2][9] = MotaMap.K;
        map[2][10] = MotaMap.K;
        map[3][0] = MotaMap.V;
        map[3][1] = MotaMap.V;
        map[3][2] = MotaMap.V;
        map[3][8] = MotaMap.Y;
        map[3][9] = MotaMap.Y;
        map[3][10] = MotaMap.Y;
        map[10][5] = MotaMap.T;
        map[3][3] = MotaMap.L;
        map[3][7] = MotaMap.L;
        map[6][5] = MotaMap.L;
        hero.bossEvent = 4;
    }

    public static boolean floor3(Hero hero) {
        Integer[][] map = hero.maps;
        map[6][4] = MotaMap.c;
        map[7][4] = MotaMap.d;
        map[9][4] = MotaMap.d;
        map[8][3] = MotaMap.d;
        map[8][5] = MotaMap.d;
        return true;
    }
}
