package team.mota.pos;

import team.mota.panel.MotaMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun-wqh seeyul
 */
public class MonstrtMap {
    public static Map<Integer, Monster> monsterMap = new HashMap<>();

    static {
        monsterMap.put(MotaMap.a, new Monster("绿史莱姆", 35, 18, 1, 1));
        monsterMap.put(MotaMap.b, new Monster("红史莱姆", 45, 20, 2, 2));
        monsterMap.put(MotaMap.g, new Monster("小蝙蝠", 35, 38, 3, 3));
        monsterMap.put(MotaMap.i, new Monster("初级法师", 60, 32, 8, 5));
        monsterMap.put(MotaMap.e, new Monster("骷髅人", 50, 42, 6, 6));
        monsterMap.put(MotaMap.f, new Monster("骷髅士兵", 55, 52, 12, 8));
        monsterMap.put(MotaMap.r, new Monster("骷髅队长", 100, 65, 15, 30));
        monsterMap.put(MotaMap.j, new Monster("中级卫兵", 100, 100, 110, 50));
        monsterMap.put(MotaMap.q, new Monster("初级卫兵", 50, 48, 22, 12));
        monsterMap.put(MotaMap.s, new Monster("高级法师", 100, 95, 30, 18));
        monsterMap.put(MotaMap.t, new Monster("黑球", 130,60, 3, 8));
        monsterMap.put(MotaMap.u, new Monster("兽人", 260, 85, 5, 22));
        monsterMap.put(MotaMap.v, new Monster("石头人", 20, 100, 68, 28));
        monsterMap.put(MotaMap.w, new Monster("吸血鬼", 444, 199, 66, 144));
        monsterMap.put(MotaMap.x, new Monster("幽灵", 320, 140, 20, 30));
        monsterMap.put(MotaMap.h, new Monster("大蝙蝠", 60, 100, 8, 12));
        monsterMap.put(MotaMap.z, new Monster("兽人武士", 320, 120, 15, 30));
    }

    public static Map<Integer, Article> articleMap = new HashMap<>();

    static {
        articleMap.put(MotaMap.R, new Article("redKey", 1,1));
        articleMap.put(MotaMap.B, new Article("blueKey", 1,1));
        articleMap.put(MotaMap.Y, new Article("yellowKey", 1,1));
        articleMap.put(MotaMap.U, new Article("hp", 100,1));
        articleMap.put(MotaMap.V, new Article("hp", 200,1));
        articleMap.put(MotaMap.W, new Article("hp", 400,1));
        articleMap.put(MotaMap.J, new Article("atk", 1,1));
        articleMap.put(MotaMap.K, new Article("def", 1,1));
        articleMap.put(MotaMap.A, new Article("atk", 10,1));
        articleMap.put(MotaMap.C, new Article("def", 10,1));
    }

    public static Map<Integer, Article> equipageMap = new HashMap<>();

    static{
        equipageMap.put(MotaMap.k,new Article("飞行器",1,-1));// 飞行器
        equipageMap.put(MotaMap.o,new Article("记事本",1,-1));// 记事本
        equipageMap.put(MotaMap.p,new Article("幸运金币",1,-1));// 幸运金币
//        equipageMap.put(MotaMap.p,new Article("怪物图鉴",1,-1));// 怪物图鉴
    }

}
