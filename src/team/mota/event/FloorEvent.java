package team.mota.event;

import team.mota.panel.MotaMap;

/**
 * @Description: 楼层切换事件
 * @author: wuyu
 * @date: 2020/1/3
 */

public class FloorEvent {

    public static void up(Integer[][] maps, Integer x, Integer y) {
        boolean flagt = false;
        //如果在楼梯口没找到英雄坐标，强制转移
        for (int i = 0; i < maps.length; i++) {
            if (flagt) {
                break;
            }
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == MotaMap.aS) {
                    if (maps[i - 1][j] == MotaMap.hr) {
                        x = i;
                        y = j;
                        flagt = true;
                        break;
                    }
                }
            }
        }
        if (!flagt) {
            for (int i = 0; i < maps.length; i++) {
                if (flagt) {
                    break;
                }
                for (int j = 0; j < maps[i].length; j++) {
                    if (maps[i][j] == MotaMap.hr) {
                        x = i;
                        y = j;
                        flagt = true;
                        break;
                    }
                }
            }
        }
    }
}
