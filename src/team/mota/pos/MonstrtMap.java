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
        monsterMap.put(MotaMap.mC, new Monster("魔王", 5000, 1580, 190, 0));
        monsterMap.put(MotaMap.mD, new Monster("魔法警卫", 230, 450, 100, 100));
        monsterMap.put(MotaMap.mA, new Monster("绿史莱姆", 35, 18, 1, 1));
        monsterMap.put(MotaMap.mB, new Monster("红史莱姆", 45, 20, 2, 2));
        monsterMap.put(MotaMap.mG, new Monster("小蝙蝠", 35, 38, 3, 3));
        monsterMap.put(MotaMap.mI, new Monster("初级法师", 60, 32, 8, 5));
        monsterMap.put(MotaMap.mE, new Monster("骷髅人", 50, 42, 6, 6));
        monsterMap.put(MotaMap.mF, new Monster("骷髅士兵", 55, 52, 12, 8));
        monsterMap.put(MotaMap.mR, new Monster("骷髅队长", 100, 65, 15, 30));
        monsterMap.put(MotaMap.mJ, new Monster("中级卫兵", 100, 100, 110, 50));
        monsterMap.put(MotaMap.mQ, new Monster("初级卫兵", 50, 48, 22, 12));
        monsterMap.put(MotaMap.mS, new Monster("高级法师", 100, 95, 30, 18));
        monsterMap.put(MotaMap.mT, new Monster("黑球", 130, 60, 3, 8));
        monsterMap.put(MotaMap.mU, new Monster("兽人", 260, 85, 5, 22));
        monsterMap.put(MotaMap.mV, new Monster("石头人", 20, 100, 68, 28));
        monsterMap.put(MotaMap.mW, new Monster("吸血鬼", 444, 199, 66, 144));
        monsterMap.put(MotaMap.mX, new Monster("幽灵", 320, 140, 20, 30));
        monsterMap.put(MotaMap.mH, new Monster("大蝙蝠", 60, 100, 8, 12));
        monsterMap.put(MotaMap.mZ, new Monster("兽人武士", 320, 120, 15, 30));
    }

    public static Map<Integer, Article> articleMap = new HashMap<>();

    static {
        articleMap.put(MotaMap.pA, new Article("红钥匙", "redKey", 1, 1));
        articleMap.put(MotaMap.pB, new Article("蓝钥匙", "blueKey", 1, 1));
        articleMap.put(MotaMap.pC, new Article("黄钥匙", "yellowKey", 1, 1));
        articleMap.put(MotaMap.pD, new Article("红药水", "hp", 100, 1));
        articleMap.put(MotaMap.pE, new Article("蓝药水", "hp", 200, 1));
        articleMap.put(MotaMap.pF, new Article("绿药水", "hp", 400, 1));
        articleMap.put(MotaMap.pG, new Article("红结晶", "atk", 1, 1));
        articleMap.put(MotaMap.pH, new Article("蓝结晶", "def", 1, 1));
        articleMap.put(MotaMap.pI, new Article("铁剑", "atk", 10, 1));
        articleMap.put(MotaMap.pJ, new Article("铁盾", "def", 10, 1));
        articleMap.put(MotaMap.pN, new Article("银盾", "def", 20, 1));
        articleMap.put(MotaMap.pO, new Article("银剑", "atk", 20, 1));
        articleMap.put(MotaMap.pQ, new Article("神圣剑", "atk", 100, 1));
        articleMap.put(MotaMap.pR, new Article("神圣盾", "atk", 100, 1));
    }

    public static Map<Integer, Article> equipageMap = new HashMap<>();

    static {
        equipageMap.put(MotaMap.pK, new Article("飞行器", "", 1, -1));// 飞行器
        equipageMap.put(MotaMap.pL, new Article("记事本", "", 1, -1));// 记事本
        equipageMap.put(MotaMap.pM, new Article("幸运金币", "", 1, -1));// 幸运金币
//        equipageMap.put(MotaMap.pM,new Article("怪物图鉴",1,-1));// 怪物图鉴
    }

}
