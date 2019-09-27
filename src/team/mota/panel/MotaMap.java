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
    public final static int X = 0;
    public final static int H = 100;
    public final static int P = 66;
    // 钥匙
    public final static int R = 1;//红钥匙
    public final static int B = 2;//蓝钥匙
    public final static int Y = 3;//黄钥匙
    // 血
    public final static int U = 4;//红药水
    public final static int V = 5;//蓝药水
    public final static int W = 6;//绿药水
    //结晶
    public final static int J = 7;//红结晶
    public final static int K = 8;//蓝结晶
    //墙
    public final static int Q = 50;
    public final static int O = 49;//特殊墙
    //门
    public final static int D = 51;//黄门
    public final static int E = 52;//蓝门
    public final static int F = 53;//红门
    public final static int G = 56;//铁门
    public final static int Z = 57;//特殊门
    //武器
    public final static int A = 60;//铁剑
    public final static int C = 61;//铁盾
    //楼梯
    public final static int T = 54;//上楼
    public final static int S = 55;//下楼
    //商店
    public final static int I = 62;
    public final static int M = 63;
    public final static int N = 64;
    //    X
    //怪物
    public final static int a = 11;// 绿球
    public final static int b = 12;// 红球
    public final static int c = 13;// 魔王
    public final static int d = 14;// 魔法警卫
    public final static int e = 15;// 骷髅人
    public final static int f = 16;// 骷髅士兵
    public final static int r = 28;// 骷髅队长
    public final static int g = 17;// 小蝙蝠
    public final static int h = 18;// 大蝙蝠
    public final static int i = 19;// 低级法师
    public final static int j = 20;// 中级卫兵
    public final static int q = 27;// 低级卫兵
    public final static int s = 30;// 高级法师
    public final static int t = 31;// 黑球
    public final static int u = 32;// 兽人
    public final static int v = 33;// 石头人
    public final static int w = 34;// 吸血鬼
    public final static int x = 35;// 幽灵
    public final static int y = 36;// 低级卫兵
    public final static int z = 37;// 兽人武士


    public final static int k = 21;// 飞行器
    public final static int o = 25;// 记事本
    public final static int p = 29;// 幸运金币

    public final static int l = 22;// 小偷
    public final static int m = 23;// 奸商
    public final static int n = 24;// 老头

    static {
        Integer[][] map0 = new Integer[][]{
                {T, H, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, p, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L},
                {L, L, L, L, L, L, L, L, L, L, L}
        };
        motemap.put(0, map0);

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
                {L, Y, Q, L, X, L, Q, L, D, i, Y},
                {U, J, Q, L, L, L, Q, L, Q, Q, Q},
                {Q, Q, Q, Q, L, Q, Q, b, Q, L, L},
                {S, H, L, L, L, L, Q, L, D, L, T}
        };
        motemap.put(3, map3);
        Integer[][] map4 = new Integer[][]{
                {L, B, L, Q, I, M, N, Q, L, n, L},
                {U, L, Y, Q, L, L, L, Q, Y, L, V},
                {L, L, L, Q, L, L, L, Q, L, f, L},
                {Q, D, Q, Q, Q, E, Q, Q, Q, D, Q},
                {L, i, L, D, L, b, L, L, e, L, L},
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
                {D, Q, D, Q, E, Q, D, Q, e, Q, D},
                {L, f, L, i, L, L, L, L, L, L, L},
                {L, Q, L, Q, D, Q, D, Q, f, Q, D},
                {L, Q, L, Q, L, Q, L, Q, L, Q, L},
                {L, Q, L, Q, g, Q, b, Q, V, Q, L},
                {a, Q, a, Q, Y, Q, i, Q, Y, Q, H},
                {L, b, L, Q, Y, Q, V, Q, Y, Q, S}
        };
        motemap.put(7, map7);
        Integer[][] map8 = new Integer[][]{
                {S, L, D, D, L, T, L, Q, Y, L, Y},
                {H, L, Q, Q, L, L, a, Q, L, R, L},
                {D, Q, Q, Q, Q, D, Q, Q, V, L, U},
                {L, Q, Y, Y, Y, L, L, Q, Q, Z, Q},
                {U, Q, Q, Q, Q, Q, i, Q, q, L, q},
                {L, b, a, b, L, Q, L, Q, L, L, L},
                {Q, Q, Q, Q, D, Q, g, Q, Q, E, Q},
                {L, L, L, g, L, e, L, i, L, L, L},
                {D, Q, Q, Q, Q, Q, Q, Q, Q, Q, D},
                {a, L, Q, J, Y, Q, B, U, Q, L, e},
                {L, g, E, Y, K, Q, Y, L, D, f, L}
        };
        motemap.put(8, map8);
        Integer[][] map9 = new Integer[][]{
                {L, L, e, D, L, S, L, D, a, L, U},
                {L, Y, L, Q, L, H, L, Q, L, a, L},
                {f, Q, Q, Q, Q, E, Q, Q, Q, Q, L},
                {L, Y, L, Q, Y, L, Y, D, D, L, L},
                {K, L, g, D, L, J, L, Q, Q, O, Q},
                {Q, Q, Q, Q, Q, Q, b, Q, L, L, f},
                {Y, L, D, f, Y, Q, L, Q, C, Q, L},
                {f, L, Q, L, L, Q, L, Q, Q, Q, D},
                {D, Q, Q, Q, D, Q, L, Q, Y, L, i},
                {L, U, Q, L, e, Q, g, Q, L, e, L},
                {T, L, E, L, L, D, L, D, i, L, U}
        };
        motemap.put(9, map9);
        Integer[][] map10 = new Integer[][]{
                {L, L, L, L, L, L, L, L, L, L, L},
                {Q, Q, Q, Q, L, L, L, Q, Q, Q, Q},
                {e, e, e, Q, Q, L, Q, Q, e, e, e},
                {L, f, L, Z, L, r, L, Z, L, f, L},
                {Q, Q, Q, Q, L, L, L, Q, Q, Q, Q},
                {e, J, e, Q, Q, L, Q, Q, e, K, e},
                {L, f, L, Q, Q, L, Q, Q, L, f, L},
                {L, L, L, Q, Q, L, Q, Q, L, L, L},
                {D, Q, D, Q, Q, F, Q, Q, D, Q, D},
                {H, Q, L, Q, L, L, L, Q, L, Q, L},
                {S, Q, L, i, L, L, L, i, L, Q, V}
        };
        motemap.put(10, map10);
        Integer[][] map11 = new Integer[][]{
                {L, L, L, Q, J, L, D, L, Q, U, Y},
                {L, 0, L, Q, L, g, Q, u, Q, L, L},
                {L, L, L, Q, D, Q, Q, L, D, L, L},
                {Q, Z, Q, Q, L, h, Q, Q, Q, Q, t},
                {s, L, s, Q, u, L, D, s, L, Q, L},
                {L, L, L, Q, Q, Q, Q, L, U, Q, L},
                {V, L, L, h, L, L, D, t, L, Q, L},
                {Q, E, Q, Q, Q, Q, Q, Q, Q, Q, h},
                {L, h, L, t, D, L, L, L, L, g, L},
                {Y, L, L, L, Q, H, Q, Q, D, Q, L},
                {Y, Y, Y, Y, Q, S, Q, V, h, Q, T}
        };
        motemap.put(11, map11);
        Integer[][] map12 = new Integer[][]{
                {m, O, L, Q, Y, J, Y, Q, L, O, n},
                {Q, Q, t, Q, L, Q, L, Q, L, Q, Q},
                {L, L, L, Q, s, L, s, Q, L, u, L},
                {D, Q, Q, Q, Q, D, Q, Q, Q, Q, L},
                {L, s, L, D, L, u, L, Q, U, L, h},
                {Q, Q, Q, Q, L, L, s, D, L, K, L},
                {Y, Y, L, Q, L, V, L, Q, Y, L, u},
                {Y, B, L, Q, Q, Q, Q, Q, E, Q, D},
                {L, L, u, Q, I, M, N, Q, t, L, u},
                {Q, Q, D, Q, U, L, U, Q, Q, L, Q},
                {T, L, L, g, L, L, L, g, L, H, S}
        };
        motemap.put(12, map12);
        Integer[][] map13 = new Integer[][]{
                {P, P, P, P, P, P, P, P, P, P, P},
                {P, P, P, P, P, P, P, P, P, P, P},
                {P, P, P, P, Q, Q, Q, P, P, P, P},
                {P, P, P, Q, Q, Q, Q, Q, P, P, P},
                {P, P, P, Q, Q, 0, Q, Q, P, P, P},
                {P, P, P, Q, Q, P, Q, Q, P, P, P},
                {P, P, P, P, Q, P, Q, P, P, P, P},
                {P, P, P, P, P, P, P, P, P, P, P},
                {P, P, P, P, P, P, P, P, P, P, P},
                {Q, Q, Q, Q, Q, D, Q, Q, Q, Q, Q},
                {S, H, L, L, L, L, L, L, L, L, T}
        };
        motemap.put(13, map13);
        Integer[][] map14 = new Integer[][]{
                {z, L, z, Q, K, Y, U, Q, Y, Y, Y},
                {L, z, L, Q, t, Q, z, Q, L, L, Y},
                {Q, L, L, Q, L, Q, L, Q, Q, D, Q},
                {Q, E, Q, Q, E, Q, D, Q, L, z, L},
                {U, L, L, h, L, v, L, h, L, L, L},
                {L, t, L, Q, Q, D, Q, Q, U, L, u},
                {D, Q, D, Q, L, L, L, Q, Q, Q, D},
                {L, Q, L, u, L, D, L, t, L, t, L},
                {s, Q, s, Q, Q, O, Q, Q, E, Q, Q},
                {L, Q, L, Q, U, L, L, Q, L, L, H},
                {E, Q, L, D, L, T, L, Q, L, L, S}
        };
        motemap.put(14, map14);

        Integer[][] map15 = new Integer[][]{
                {K, z, L, D, L, T, L, Q, l, L, L},
                {u, L, L, Q, L, L, L, Q, L, L, t},
                {L, L, t, Q, Q, Z, Q, Q, Q, Q, D},
                {D, Q, Q, Q, 0, 0, 0, Q, h, L, L},
                {L, Q, Y, Q, 0, 0, 0, Q, L, h, L},
                {L, Q, B, Q, 0, 0, 0, Q, D, Q, s},
                {t, Q, Y, Q, L, L, L, Q, L, Q, L},
                {L, Q, L, Q, L, L, L, Q, L, Q, V},
                {L, D, L, Q, Q, L, Q, Q, D, Q, Q},
                {h, Q, h, Q, L, H, L, Q, L, g, L},
                {L, s, L, Q, L, S, L, D, g, L, m}
        };
        motemap.put(15, map15);
        Integer[][] map16 = new Integer[][]{
                {y, h, L, Q, L, S, L, Q, L, L, h},
                {y, s, L, D, L, H, L, D, t, L, L},
                {y, h, L, Q, u, L, Y, Q, L, L, V},
                {Q, Q, Q, Q, Q, E, Q, Q, Q, D, Q},
                {J, Y, L, Q, U, L, L, Q, L, u, L},
                {U, L, v, D, L, z, L, Q, L, L, L},
                {K, Y, L, Q, L, L, Y, Q, h, L, B},
                {Q, O, Q, Q, Q, D, Q, Q, Q, D, Q},
                {L, t, L, Q, h, L, h, Q, L, s, L},
                {L, L, L, D, L, L, L, D, L, Q, Q},
                {n, L, L, Q, L, T, L, Q, x, O, O}
        };
        motemap.put(16, map16);
        Integer[][] map17 = new Integer[][]{
                {L, L, L, Q, L, T, L, Q, J, L, K},
                {L, 0, L, Q, L, L, L, Q, L, V, L},
                {L, L, L, Q, z, Q, h, Q, Y, L, Y},
                {Q, Z, Q, Q, L, Q, L, Q, Q, Z, Q},
                {y, L, y, Q, D, Q, E, Q, z, L, z},
                {L, L, L, Q, L, Q, L, Q, L, L, L},
                {Q, Z, Q, Q, u, Q, t, Q, Q, Z, Q},
                {y, L, y, Q, L, L, L, Q, u, L, u},
                {L, L, L, Q, Q, S, Q, Q, L, L, L},
                {Q, D, Q, Q, L, L, L, Q, Q, D, Q},
                {U, L, L, h, H, S, L, h, L, L, U}
        };
        motemap.put(17, map17);
        Integer[][] map18 = new Integer[][]{
                {0, 0, 0, 0, L, S, L, 0, 0, 0, 0},
                {0, 0, 0, 0, L, H, L, 0, 0, 0, 0},
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
