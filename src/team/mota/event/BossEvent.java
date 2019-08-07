package team.mota.event;

import team.mota.panel.MotaMap;
import team.mota.pos.Hero;

/**
 * @author: wuyu
 * @date: 2019/8/4
 */
public class BossEvent {

    public static void floor10(int r, Integer bossEvent, Hero hero) {
        int event = DialogueEvent.bossDialogue(MotaMap.n, bossEvent);
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
            map[1][5] = MotaMap.r;
            map[2][5] = MotaMap.Z;
            map[6][5] = MotaMap.Z;
        }
    }

}
