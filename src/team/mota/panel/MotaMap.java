package team.mota.panel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun-wqh seeyul
 */
public class MotaMap {
    public static Map<Integer, Integer[][]> motemap = new HashMap<>();
    //路
    public final static int L = 10;
    public final static int H = 100;
    // 钥匙
    public final static int R = 1;//黄钥匙
    public final static int B = 2;//蓝钥匙
    public final static int Y = 3;//红钥匙
    // 血
    public final static int U = 4;//红药水
    public final static int V = 5;//蓝药水
    public final static int W = 6;//绿药水
    //结晶
    public final static int J = 7;//红结晶
    public final static int K = 8;//蓝结晶
    //墙
    public final static int Q = 50;
    public final static int O = 49;
    //门
    public final static int D = 51;//黄门
    public final static int E = 52;//蓝门
    public final static int F = 53;//红门
    public final static int G = 56;//铁门

    //武器
    public final static int A = 60;//铁剑
    public final static int C = 61;//铁盾

    //楼梯
    public final static int T = 54;//上楼
    public final static int S = 55;//下楼
    // I M N  P X Z
    //怪物
    public final static int a = 11;// 绿球
    public final static int b = 12;// 红球
    public final static int c = 13;
    public final static int d = 14;
    public final static int e = 15;// 骷髅人
    public final static int f = 16;// 骷髅士兵
    public final static int g = 17;// 小蝙蝠
    public final static int h = 18;// 大蝙蝠
    public final static int i = 19;// 低级法师
    public final static int j = 20;// 中级卫兵

    public final static int k = 21;// 飞行器
    public final static int o = 25;// 记事本

    public final static int l = 22;// 小偷
    public final static int m = 23;// 奸商
    public final static int n = 24;// 老头


    static {
        Integer[][] map1 = new Integer[][]{
                {T, L, a, b, a, L, L, L, L, L, L},
                {Q, Q, Q, Q, Q, Q, Q, Q, Q, Q, L},
                {U, L, L, D, L, Q, J, Y, L, Q, L},
                {L, e, L, Q, L, Q, K, U, L, Q, L},
                {Q, D, Q, Q, L, Q, Q, Q, D, Q, L},
                {Y, L, L, Q, L, D, g, i, g, Q, L},
                {L, f, L, Q, L, Q, Q, Q, Q, Q, L},
                {Q, D, Q, Q, L, L, L, L, L, L, L},
                {L, L, L, Q, Q, D, Q, Q, Q, D, Q},
                {U, L, Y, Q, Y, L, L, Q, L, g, L},
                {U, k, Y, Q, L, H, L, Q, a, V, a}
        };
        motemap.put(1, map1);

        Integer[][] map2 = new Integer[][]{
                {S, L, E, L, L, L, L, L, L, L, L},
                {H, L, Q, Q, L, j, L, j, L, Q, Q},
                {L, Q, Q, Q, Q, Q, L, Q, Q, Q, Q},
                {L, Q, Y, Y, Q, L, L, L, Q, L, n},
                {L, Q, Y, L, G, L, L, L, G, L, L},
                {L, Q, Q, Q, Q, L, L, L, Q, Q, Q},
                {L, Q, l, L, Q, L, L, L, Q, L, m},
                {L, Q, L, L, G, L, L, L, G, L, L},
                {L, Q, Q, Q, Q, L, L, L, Q, Q, Q},
                {L, Q, V, V, Q, L, L, L, Q, L, L},
                {T, Q, V, L, G, L, L, L, G, L, L}
        };
        motemap.put(2, map2);
        Integer[][] map3 = new Integer[][]{
                {Y, K, Q, Y, V, Y, Q, L, Q, L, U},
                {L, U, Q, V, Y, V, Q, L, D, g, L},
                {i, L, Q, Y, B, Y, Q, L, Q, Q, Q},
                {D, Q, Q, Q, L, Q, Q, L, Q, L, n},
                {L, L, g, L, L, L, a, L, L, L, L},
                {D, Q, Q, L, L, L, Q, L, Q, Q, Q},
                {e, L, Q, Q, L, Q, Q, L, Q, L, U},
                {L, Y, Q, L, L, L, Q, L, D, i, Y},
                {U, J, Q, L, L, L, Q, L, Q, Q, Q},
                {Q, Q, Q, Q, L, Q, Q, b, Q, L, L},
                {S, H, L, L, L, L, Q, L, D, L, T}
        };
        motemap.put(3, map3);
        Integer[][] map4 = new Integer[][]{
                {L, B, L, Q, 0, 0, 0, Q, L, n, L},
                {U, L, Y, Q, L, L, L, Q, Y, L, V},
                {L, L, L, Q, L, L, L, Q, L, f, L},
                {Q, D, Q, Q, Q, E, Q, Q, Q, D, Q},
                {L, L, L, D, L, b, L, L, e, L, L},
                {L, L, L, Q, Q, Q, Q, Q, Q, Q, Q},
                {b, L, a, L, L, L, L, L, L, L, L},
                {D, Q, Q, D, Q, Q, Q, D, Q, Q, D},
                {L, Q, L, g, L, Q, L, i, L, Q, L},
                {L, Q, a, L, Y, Q, J, L, U, Q, H},
                {T, Q, Y, a, Y, Q, L, a, L, Q, S}
        };
        motemap.put(4, map4);
        Integer[][] map5 = new Integer[][]{
                {T, Q, L, b, D, L, Q, L, L, D, L},
                {L, Q, L, L, Q, Y, Q, a, a, Q, b},
                {L, D, g, L, Q, L, Q, Y, Y, Q, L},
                {Q, Q, Q, D, Q, g, Q, Y, Y, Q, L},
                {Y, L, i, L, Q, L, Q, Q, Q, Q, L},
                {Y, L, L, g, Q, L, L, L, L, L, L},
                {Q, f, Q, Q, Q, L, Q, Q, Q, Q, b},
                {L, L, L, L, Q, a, Q, L, L, L, L},
                {K, Y, U, o, Q, L, Q, D, Q, Q, Q},
                {Q, Q, Q, Q, Q, L, Q, L, Q, L, L},
                {S, H, L, L, L, L, Q, L, O, L, A}
        };
        motemap.put(5, map5);
        Integer[][] map6 = new Integer[][]{
                {S, Q, Y, Y, Q, L, i, L, Y, a, L},
                {H, Q, Y, Y, Q, L, Q, Q, Q, Q, D},
                {L, Q, Q, b, Q, L, Q, U, L, e, L},
                {L, D, D, L, D, L, Q, m, L, L, g},
                {L, Q, Q, Q, Q, L, Q, Q, Q, Q, Q},
                {L, L, b, i, L, Y, L, e, f, L, L},
                {Q, Q, Q, Q, Q, L, Q, Q, Q, Q, L},
                {i, L, L, n, Q, L, D, D, L, D, L},
                {L, g, L, K, Q, L, Q, Q, b, Q, b},
                {D, Q, Q, Q, Q, L, Q, L, L, Q, L},
                {L, a, L, L, e, L, Q, U, U, Q, T}
        };
        motemap.put(6, map6);
        Integer[][] map7 = new Integer[][]{
                {T, Q, J, Q, L, m, L, Q, Y, Q, a},
                {L, Q, U, Q, L, L, L, Q, Y, Q, b},
                {L, Q, g, Q, b, Q, f, Q, U, Q, a},
                {L, Q, L, Q, L, Q, L, Q, L, Q, L},
                {D, Q, D, Q, B, Q, D, Q, e, Q, D},
                {L, f, L, i, L, L, L, L, L, L, L},
                {L, Q, L, Q, D, Q, D, Q, f, Q, D},
                {L, Q, L, Q, L, Q, L, Q, L, Q, L},
                {L, Q, L, Q, g, Q, b, Q, V, Q, L},
                {a, Q, a, Q, Y, Q, i, Q, Y, Q, H},
                {L, b, L, Q, Y, Q, V, Q, Y, Q, S}
        };
        motemap.put(7, map7);
        Integer[][] map8 = new Integer[][]{
                {S, 0, 0, 0, 0, T, 0, 0, 0, 0, 0},
                {H, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
        motemap.put(8, map8);
        Integer[][] map9 = new Integer[][]{
                {0, 0, 0, 0, 0, S, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, H, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        motemap.put(9, map9);
        Integer[][] map10 = new Integer[][]{
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
                {T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        motemap.put(10, map10);

    }


}
