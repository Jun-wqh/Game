package team.mota.panel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun-wqh seeyul
 */
public class MotaMap {
    public static Map<Integer, Integer[][]> motemap = new HashMap<>();
    //路
    public final static int rA = 10;//路
    public final static int rB = 0;
    public final static int rC = 66;//岩浆
    public final static int hr = 100;//勇者
    /**
     * 结构
     */
    //墙
    public final static int wA = 50;//墙
    public final static int wB = 49;//特殊墙
    //门
    public final static int dA = 51;//黄门
    public final static int dB = 52;//蓝门
    public final static int dC = 53;//红门
    public final static int dE = 56;//铁门
    public final static int dF = 57;//特殊门
    //楼梯
    public final static int aT = 54;//上楼
    public final static int aS = 55;//下楼

    /**
     * 道具
     */
    // 钥匙
    public final static int pA = 1;//红钥匙
    public final static int pB = 2;//蓝钥匙
    public final static int pC = 3;//黄钥匙
    // 血
    public final static int pD = 4;//红药水
    public final static int pE = 5;//蓝药水
    public final static int pF = 6;//绿药水
    //结晶
    public final static int pG = 7;//红结晶
    public final static int pH = 8;//蓝结晶
    //武器
    public final static int pI = 60;//铁剑
    public final static int pJ = 61;//铁盾
    public final static int pK = 21;// 飞行器
    public final static int pL = 25;// 记事本
    public final static int pM = 29;// 幸运金币
    public final static int pN = 70;// 银盾
    public final static int pO = 71;// 银剑
    public final static int pP = 72;// 熔岩护符
    public final static int pQ = 73;// 神圣剑
    public final static int pR = 74;// 神圣盾

    //商店
    public final static int sA = 62;
    public final static int sB = 63;
    public final static int sC = 64;
    /**
     * 怪物
     */
    public final static int mA = 11;// 绿球
    public final static int mB = 12;// 红球
    public final static int mC = 13;// 魔王
    public final static int mD = 14;// 魔法警卫
    public final static int mE = 15;// 骷髅人
    public final static int mF = 16;// 骷髅士兵
    public final static int mR = 28;// 骷髅队长
    public final static int mG = 17;// 小蝙蝠
    public final static int mH = 18;// 大蝙蝠
    public final static int mI = 19;// 低级法师
    public final static int mJ = 20;// 中级卫兵
    public final static int mQ = 27;// 低级卫兵
    public final static int mS = 30;// 高级法师
    public final static int mT = 31;// 黑球
    public final static int mU = 32;// 兽人
    public final static int mV = 33;// 石头人
    public final static int mW = 34;// 吸血鬼
    public final static int mX = 35;// 幽灵
    public final static int mY = 36;// 低级卫兵
    public final static int mZ = 37;// 兽人武士
    //pK,nA,pL,nB,pM,nC

    /**
     * npc
     */
    public final static int nA = 22;// 小偷
    public final static int nB = 23;// 奸商
    public final static int nC = 24;// 老头

    static {
        Integer[][] map0 = new Integer[][]{
                {aT, hr, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, pM, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA}
        };
        motemap.put(0, map0);

        Integer[][] map1 = new Integer[][]{
                {aT, rA, mA, mB, mA, rA, rA, rA, rA, rA, rA},
                {wA, wA, wA, wA, wA, wA, wA, wA, wA, wA, rA},
                {pD, rA, rA, dA, rA, wA, pG, pC, rA, wA, rA},
                {rA, mE, rA, wA, rA, wA, pH, pD, rA, wA, rA},
                {wA, dA, wA, wA, rA, wA, wA, wA, dA, wA, rA},
                {pC, rA, rA, wA, rA, dA, mG, mI, mG, wA, rA},
                {rA, mF, rA, wA, rA, wA, wA, wA, wA, wA, rA},
                {wA, dA, wA, wA, rA, rA, rA, rA, rA, rA, rA},
                {rA, rA, rA, wA, wA, dA, wA, wA, wA, dA, wA},
                {pD, rA, pC, wA, pC, rA, rA, wA, rA, mG, rA},
                {pD, pK, pC, wA, rA, hr, rA, wA, mA, pE, mA}
        };
        motemap.put(1, map1);

        Integer[][] map2 = new Integer[][]{
                {aS, rA, dB, rA, rA, rA, rA, rA, rA, rA, rA},
                {hr, rA, wA, wA, rA, mJ, rA, mJ, rA, wA, wA},
                {rA, wA, wA, wA, wA, wA, rA, wA, wA, wA, wA},
                {rA, wA, pC, pC, wA, rA, rA, rA, wA, rA, nC},
                {rA, wA, pC, rA, dE, rA, rA, rA, dE, rA, rA},
                {rA, wA, wA, wA, wA, rA, rA, rA, wA, wA, wA},
                {rA, wA, nA, rA, wA, rA, rA, rA, wA, rA, nB},
                {rA, wA, rA, rA, dE, rA, rA, rA, dE, rA, rA},
                {rA, wA, wA, wA, wA, rA, rA, rA, wA, wA, wA},
                {rA, wA, pE, pE, wA, rA, rA, rA, wA, rA, rA},
                {aT, wA, pE, rA, dE, rA, rA, rA, dE, rA, rA}
        };
        motemap.put(2, map2);
        Integer[][] map3 = new Integer[][]{
                {pC, pH, wA, pC, pE, pC, wA, rA, wA, rA, pD},
                {rA, pD, wA, pE, pC, pE, wA, rA, dA, mG, rA},
                {mI, rA, wA, pC, pB, pC, wA, rA, wA, wA, wA},
                {dA, wA, wA, wA, rA, wA, wA, rA, wA, rA, nC},
                {rA, rA, mG, rA, rA, rA, mA, rA, rA, rA, rA},
                {dA, wA, wA, rA, rA, rA, wA, rA, wA, wA, wA},
                {mE, rA, wA, wA, rA, wA, wA, rA, wA, rA, pD},
                {rA, pC, wA, rA, rB, rA, wA, rA, dA, mI, pC},
                {pD, pG, wA, rA, rA, rA, wA, rA, wA, wA, wA},
                {wA, wA, wA, wA, rA, wA, wA, mB, wA, rA, rA},
                {aS, hr, rA, rA, rA, rA, wA, rA, dA, rA, aT}
        };
        motemap.put(3, map3);
        Integer[][] map4 = new Integer[][]{
                {rA, pB, rA, wA, sA, sB, sC, wA, rA, nC, rA},
                {pD, rA, pC, wA, rA, rA, rA, wA, pC, rA, pE},
                {rA, rA, rA, wA, rA, rA, rA, wA, rA, mF, rA},
                {wA, dA, wA, wA, wA, dB, wA, wA, wA, dA, wA},
                {rA, mI, rA, dA, rA, mB, rA, rA, mE, rA, rA},
                {rA, rA, rA, wA, wA, wA, wA, wA, wA, wA, wA},
                {mB, rA, mA, rA, rA, rA, rA, rA, rA, rA, rA},
                {dA, wA, wA, dA, wA, wA, wA, dA, wA, wA, dA},
                {rA, wA, rA, mG, rA, wA, rA, mI, rA, wA, rA},
                {rA, wA, mA, rA, pC, wA, pG, rA, pD, wA, hr},
                {aT, wA, pC, mA, pC, wA, rA, mA, rA, wA, aS}
        };
        motemap.put(4, map4);
        Integer[][] map5 = new Integer[][]{
                {aT, wA, rA, mB, dA, rA, wA, rA, rA, dA, rA},
                {rA, wA, rA, rA, wA, pC, wA, mA, mA, wA, mB},
                {rA, dA, mG, rA, wA, rA, wA, pC, pC, wA, rA},
                {wA, wA, wA, dA, wA, mG, wA, pC, pC, wA, rA},
                {pC, rA, mI, rA, wA, rA, wA, wA, wA, wA, rA},
                {pC, rA, rA, mG, wA, rA, rA, rA, rA, rA, rA},
                {wA, mF, wA, wA, wA, rA, wA, wA, wA, wA, mB},
                {rA, rA, rA, rA, wA, mA, wA, rA, rA, rA, rA},
                {pH, pC, pD, pL, wA, rA, wA, dA, wA, wA, wA},
                {wA, wA, wA, wA, wA, rA, wA, rA, wA, rA, rA},
                {aS, hr, rA, rA, rA, rA, wA, rA, wB, rA, pI}
        };
        motemap.put(5, map5);
        Integer[][] map6 = new Integer[][]{
                {aS, wA, pC, pC, wA, rA, mI, rA, pC, mA, rA},
                {hr, wA, pC, pC, wA, rA, wA, wA, wA, wA, dA},
                {rA, wA, wA, mB, wA, rA, wA, pD, rA, mE, rA},
                {rA, dA, dA, rA, dA, rA, wA, nB, rA, rA, mG},
                {rA, wA, wA, wA, wA, rA, wA, wA, wA, wA, wA},
                {rA, rA, mB, mI, rA, pC, rA, mE, mF, rA, rA},
                {wA, wA, wA, wA, wA, rA, wA, wA, wA, wA, rA},
                {mI, rA, rA, nC, wA, rA, dA, dA, rA, dA, rA},
                {rA, mG, rA, pH, wA, rA, wA, wA, mB, wA, mB},
                {dA, wA, wA, wA, wA, rA, wA, rA, rA, wA, rA},
                {rA, mA, rA, rA, mE, rA, wA, pD, pD, wA, aT}
        };
        motemap.put(6, map6);
        Integer[][] map7 = new Integer[][]{
                {aT, wA, pG, wA, rA, nB, rA, wA, pC, wA, mA},
                {rA, wA, pD, wA, rA, rA, rA, wA, pC, wA, mB},
                {rA, wA, mG, wA, mB, wA, mF, wA, pD, wA, mA},
                {rA, wA, rA, wA, rA, wA, rA, wA, rA, wA, rA},
                {dA, wA, dA, wA, dB, wA, dA, wA, mE, wA, dA},
                {rA, mF, rA, mI, rA, rA, rA, rA, rA, rA, rA},
                {rA, wA, rA, wA, dA, wA, dA, wA, mF, wA, dA},
                {rA, wA, rA, wA, rA, wA, rA, wA, rA, wA, rA},
                {rA, wA, rA, wA, mG, wA, mB, wA, pE, wA, rA},
                {mA, wA, mA, wA, pC, wA, mI, wA, pC, wA, hr},
                {rA, mB, rA, wA, pC, wA, pE, wA, pC, wA, aS}
        };
        motemap.put(7, map7);
        Integer[][] map8 = new Integer[][]{
                {aS, rA, dA, dA, rA, aT, rA, wA, pC, rA, pC},
                {hr, rA, wA, wA, rA, rA, mA, wA, rA, pA, rA},
                {dA, wA, wA, wA, wA, dA, wA, wA, pE, rA, pD},
                {rA, wA, pC, pC, pC, rA, rA, wA, wA, dF, wA},
                {pD, wA, wA, wA, wA, wA, mI, wA, mQ, rA, mQ},
                {rA, mB, mA, mB, rA, wA, rA, wA, rA, rA, rA},
                {wA, wA, wA, wA, dA, wA, mG, wA, wA, dB, wA},
                {rA, rA, rA, mG, rA, mE, rA, mI, rA, rA, rA},
                {dA, wA, wA, wA, wA, wA, wA, wA, wA, wA, dA},
                {mA, rA, wA, pG, pC, wA, pB, pD, wA, rA, mE},
                {rA, mG, dB, pC, pH, wA, pC, rA, dA, mF, rA}
        };
        motemap.put(8, map8);
        Integer[][] map9 = new Integer[][]{
                {rA, rA, mE, dA, rA, aS, rA, dA, mA, rA, pD},
                {rA, pC, rA, wA, rA, hr, rA, wA, rA, mA, rA},
                {mF, wA, wA, wA, wA, dB, wA, wA, wA, wA, rA},
                {rA, pC, rA, wA, pC, rA, pC, dA, dA, rA, rA},
                {pH, rA, mG, dA, rA, pG, rA, wA, wA, wB, wA},
                {wA, wA, wA, wA, wA, wA, mB, wA, rA, rA, mF},
                {pC, rA, dA, mF, pC, wA, rA, wA, pJ, wA, rA},
                {mF, rA, wA, rA, rA, wA, rA, wA, wA, wA, dA},
                {dA, wA, wA, wA, dA, wA, rA, wA, pC, rA, mI},
                {rA, pD, wA, rA, mE, wA, mG, wA, rA, mE, rA},
                {aT, rA, dB, rA, rA, dA, rA, dA, mI, rA, pD}
        };
        motemap.put(9, map9);
        Integer[][] map10 = new Integer[][]{
                {rA, rA, rA, rA, rA, rA, rA, rA, rA, rA, rA},
                {wA, wA, wA, wA, rA, rA, rA, wA, wA, wA, wA},
                {mE, mE, mE, wA, wA, rA, wA, wA, mE, mE, mE},
                {rA, mF, rA, dF, rA, mR, rA, dF, rA, mF, rA},
                {wA, wA, wA, wA, rA, rA, rA, wA, wA, wA, wA},
                {mE, pG, mE, wA, wA, rA, wA, wA, mE, pH, mE},
                {rA, mF, rA, wA, wA, rA, wA, wA, rA, mF, rA},
                {rA, rA, rA, wA, wA, rA, wA, wA, rA, rA, rA},
                {dA, wA, dA, wA, wA, dC, wA, wA, dA, wA, dA},
                {hr, wA, rA, wA, rA, rA, rA, wA, rA, wA, rA},
                {aS, wA, rA, mI, rA, rA, rA, mI, rA, wA, pE}
        };
        motemap.put(10, map10);
        Integer[][] map11 = new Integer[][]{
                {rA, rA, rA, wA, pG, rA, dA, rA, wA, pD, pC},
                {rA, pN, rA, wA, rA, mG, wA, mU, wA, rA, rA},
                {rA, rA, rA, wA, dA, wA, wA, rA, dA, rA, rA},
                {wA, dF, wA, wA, rA, mH, wA, wA, wA, wA, mT},
                {mS, rA, mS, wA, mU, rA, dA, mS, rA, wA, rA},
                {rA, rA, rA, wA, wA, wA, wA, rA, pD, wA, rA},
                {pE, rA, rA, mH, rA, rA, dA, mT, rA, wA, rA},
                {wA, dB, wA, wA, wA, wA, wA, wA, wA, wA, mH},
                {rA, mH, rA, mT, dA, rA, rA, rA, rA, mG, rA},
                {pC, rA, rA, rA, wA, hr, wA, wA, dA, wA, rA},
                {pC, pC, pC, pC, wA, aS, wA, pE, mH, wA, aT}
        };
        motemap.put(11, map11);
        Integer[][] map12 = new Integer[][]{
                {nB, wB, rA, wA, pC, pG, pC, wA, rA, wB, nC},
                {wA, wA, mT, wA, rA, wA, rA, wA, rA, wA, wA},
                {rA, rA, rA, wA, mS, rA, mS, wA, rA, mU, rA},
                {dA, wA, wA, wA, wA, dA, wA, wA, wA, wA, rA},
                {rA, mS, rA, dA, rA, mU, rA, wA, pD, rA, mH},
                {wA, wA, wA, wA, rA, rA, mS, dA, rA, pH, rA},
                {pC, pC, rA, wA, rA, pE, rA, wA, pC, rA, mU},
                {pC, pB, rA, wA, wA, wA, wA, wA, dB, wA, dA},
                {rA, rA, mU, wA, sA, sB, sC, wA, mT, rA, mU},
                {wA, wA, dA, wA, pD, rA, pD, wA, wA, rA, wA},
                {aT, rA, rA, mG, rA, rA, rA, mG, rA, hr, aS}
        };
        motemap.put(12, map12);
        Integer[][] map13 = new Integer[][]{
                {rC, rC, rC, rC, rC, rC, rC, rC, rC, rC, rC},
                {rC, rC, rC, rC, rC, rC, rC, rC, rC, rC, rC},
                {rC, rC, rC, rC, wA, wA, wA, rC, rC, rC, rC},
                {rC, rC, rC, wA, wA, wA, wA, wA, rC, rC, rC},
                {rC, rC, rC, wA, wA, pQ, wA, wA, rC, rC, rC},
                {rC, rC, rC, wA, wA, rC, wA, wA, rC, rC, rC},
                {rC, rC, rC, rC, wA, rC, wA, rC, rC, rC, rC},
                {rC, rC, rC, rC, rC, rC, rC, rC, rC, rC, rC},
                {rC, rC, rC, rC, rC, rC, rC, rC, rC, rC, rC},
                {wA, wA, wA, wA, wA, dA, wA, wA, wA, wA, wA},
                {aS, hr, rA, rA, rA, rA, rA, rA, rA, rA, aT}
        };
        motemap.put(13, map13);
        Integer[][] map14 = new Integer[][]{
                {mZ, rA, mZ, wA, pH, pC, pD, wA, pC, pC, pC},
                {rA, mZ, rA, wA, mT, wA, mZ, wA, rA, rA, pC},
                {wA, rA, rA, wA, rA, wA, rA, wA, wA, dA, wA},
                {wA, dB, wA, wA, dB, wA, dA, wA, rA, mZ, rA},
                {pD, rA, rA, mH, rA, mV, rA, mH, rA, rA, rA},
                {rA, mT, rA, wA, wA, dA, wA, wA, pD, rA, mU},
                {dA, wA, dA, wA, rA, rA, rA, wA, wA, wA, dA},
                {rA, wA, rA, mU, rA, dA, rA, mT, rA, mT, rA},
                {mS, wA, mS, wA, wA, wB, wA, wA, dB, wA, wA},
                {rA, wA, rA, wA, pD, rA, rA, wA, rA, rA, hr},
                {dB, wA, rA, dA, rA, aT, rA, wA, rA, rA, aS}
        };
        motemap.put(14, map14);

        Integer[][] map15 = new Integer[][]{
                {pH, mZ, rA, dA, rA, aT, rA, wA, nA, rA, rA},
                {mU, rA, rA, wA, rA, rA, rA, wA, rA, rA, mT},
                {rA, rA, mT, wA, wA, dF, wA, wA, wA, wA, dA},
                {dA, wA, wA, wA, 0, 0, 0, wA, mH, rA, rA},
                {rA, wA, pC, wA, 0, 0, 0, wA, rA, mH, rA},
                {rA, wA, pB, wA, 0, 0, 0, wA, dA, wA, mS},
                {mT, wA, pC, wA, rA, rA, rA, wA, rA, wA, rA},
                {rA, wA, rA, wA, rA, rA, rA, wA, rA, wA, pE},
                {rA, dA, rA, wA, wA, rA, wA, wA, dA, wA, wA},
                {mH, wA, mH, wA, rA, hr, rA, wA, rA, mG, rA},
                {rA, mS, rA, wA, rA, aS, rA, dA, mG, rA, nB}
        };
        motemap.put(15, map15);
        Integer[][] map16 = new Integer[][]{
                {mY, mH, rA, wA, rA, aS, rA, wA, rA, rA, mH},
                {mY, mS, rA, dA, rA, hr, rA, dA, mT, rA, rA},
                {mY, mH, rA, wA, mU, rA, pC, wA, rA, rA, pE},
                {wA, wA, wA, wA, wA, dB, wA, wA, wA, dA, wA},
                {pG, pC, rA, wA, pD, rA, rA, wA, rA, mU, rA},
                {pD, rA, mV, dA, rA, mZ, rA, wA, rA, rA, rA},
                {pH, pC, rA, wA, rA, rA, pC, wA, mH, rA, pB},
                {wA, wB, wA, wA, wA, dA, wA, wA, wA, dA, wA},
                {rA, mT, rA, wA, mH, rA, mH, wA, rA, mS, rA},
                {rA, rA, rA, dA, rA, rA, rA, dA, rA, wA, wA},
                {nC, rA, rA, wA, rA, aT, rA, wA, mX, wB, wB}
        };
        motemap.put(16, map16);
        Integer[][] map17 = new Integer[][]{
                {rA, rA, rA, wA, rA, aT, rA, wA, pG, rA, pH},
                {rA, 0, rA, wA, rA, rA, rA, wA, rA, pE, rA},
                {rA, rA, rA, wA, mZ, wA, mH, wA, pC, rA, pC},
                {wA, dF, wA, wA, rA, wA, rA, wA, wA, dF, wA},
                {mY, rA, mY, wA, dA, wA, dB, wA, mZ, rA, mZ},
                {rA, rA, rA, wA, rA, wA, rA, wA, rA, rA, rA},
                {wA, dF, wA, wA, mU, wA, mT, wA, wA, dF, wA},
                {mY, rA, mY, wA, rA, rA, rA, wA, mU, rA, mU},
                {rA, rA, rA, wA, wA, aS, wA, wA, rA, rA, rA},
                {wA, dA, wA, wA, rA, rA, rA, wA, wA, dA, wA},
                {pD, rA, rA, mH, hr, aS, rA, mH, rA, rA, pD}
        };
        motemap.put(17, map17);
        Integer[][] map18 = new Integer[][]{
                {0, 0, 0, 0, rA, aS, rA, 0, 0, 0, 0},
                {0, 0, 0, 0, rA, hr, rA, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        motemap.put(18, map18);
        Integer[][] map19 = new Integer[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        motemap.put(19, map19);
        Integer[][] map20 = new Integer[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        motemap.put(20, map20);
        /*
         * 地图模版
         Integer[][] map3 = new Integer[][]{
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
         };
         motemap.put(3, map3);
         */

    }
}
