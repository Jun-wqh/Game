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
                if (map[2][i] == MotaMap.mE) {
                    map[2][i] = MotaMap.rA;
                }
                if (map[3][i] == MotaMap.mF) {
                    map[3][i] = MotaMap.rA;
                }
            }
            for (int i = 3; i < 6; i++) {
                map[i][4] = MotaMap.mE;
                map[i][6] = MotaMap.mE;
            }
            map[3][5] = MotaMap.mF;
            map[5][5] = MotaMap.mF;
            map[0][5] = MotaMap.mR;
            map[2][5] = MotaMap.dF;
            map[6][5] = MotaMap.dF;
            hero.bossEvent = 2;
        }
        if (event == 2) {
            hero.bossEvent = 3;
        }
    }

    public static void floor10Reward(Hero hero) {
        DialogueEvent.bossDialogue(MotaMap.mR, hero);
        Integer[][] map = hero.maps;
        map[2][0] = MotaMap.pG;
        map[2][1] = MotaMap.pG;
        map[2][2] = MotaMap.pG;
        map[2][8] = MotaMap.pH;
        map[2][9] = MotaMap.pH;
        map[2][10] = MotaMap.pH;
        map[3][0] = MotaMap.pE;
        map[3][1] = MotaMap.pE;
        map[3][2] = MotaMap.pE;
        map[3][8] = MotaMap.pC;
        map[3][9] = MotaMap.pC;
        map[3][10] = MotaMap.pC;
        map[10][5] = MotaMap.aT;
        map[3][3] = MotaMap.rA;
        map[3][7] = MotaMap.rA;
        map[6][5] = MotaMap.rA;
        map[9][5] = MotaMap.rB;
        hero.bossEvent = 4;
    }

    public static boolean floor3(Hero hero) {
        Integer[][] map = hero.maps;
        map[6][4] = MotaMap.mC;
        map[7][4] = MotaMap.mD;
        map[9][4] = MotaMap.mD;
        map[8][3] = MotaMap.mD;
        map[8][5] = MotaMap.mD;
        return true;
    }
}
