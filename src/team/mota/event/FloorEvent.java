package team.mota.event;

import team.mota.panel.MotaMap;
import team.mota.pos.Hero;

/**
 * @Description: 楼层切换事件
 * @author: wuyu
 * @date: 2020/1/3
 */

public class FloorEvent {

    public static void change(Hero hero, Integer stairs) {
        boolean flagt = false;
        Integer[][] maps = hero.maps;
        //如果在楼梯口没找到英雄坐标，强制转移
        for (int i = 0; i < maps.length; i++) {
            if (flagt) {
                break;
            }
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == MotaMap.hr) {
                    maps[i][j] = MotaMap.rA;
                    break;
                }
            }
        }
        for (int i = 0; i < maps.length; i++) {
            if (flagt) {
                break;
            }
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j].equals(stairs)) {
                    //上
                    if (i - 1 != -1) {
                        if (maps[i - 1][j] == MotaMap.rA) {
                            maps[i - 1][j] = MotaMap.hr;
                            hero.x = i - 1;
                            hero.y = j;
                            flagt = true;
                            break;
                        }
                    }
                    //左
                    if (j - 1 != -1) {
                        if (maps[i][j - 1] == MotaMap.rA) {
                            maps[i][j - 1] = MotaMap.hr;
                            hero.x = i;
                            hero.y = j - 1;
                            flagt = true;
                            break;
                        }
                    }
                    //下
                    if (i + 1 != 11) {
                        if (maps[i + 1][j] == MotaMap.rA) {
                            maps[i + 1][j] = MotaMap.hr;
                            hero.x = (i + 1);
                            hero.y = j;
                            flagt = true;
                            break;
                        }
                    }
                    //右
                    if (j + 1 != 11) {
                        if (maps[i][j + 1] == MotaMap.rA) {
                            maps[i][j + 1] = MotaMap.hr;
                            hero.x = i;
                            hero.y = j + 1;
                            flagt = true;
                            break;
                        }
                    }
                } else {
                    if (hero.article.get("level") == 1) {
                        maps[10][5] = MotaMap.hr;
                        hero.x = 10;
                        hero.y = 5;
                    }
                }
            }
        }
    }

}
