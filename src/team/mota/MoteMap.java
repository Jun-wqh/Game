package team.mota;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0.0
 * @ClassName: MoteMap
 * @Description:
 * @author: 厦门智强软件科技
 * @date: 2019/7/22
 * @Copyright:2019 All rights reserved.
 * 注意：本内容仅限于厦门智强软件科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MoteMap {
    public static Map<Integer, Integer[][]> motemap = new HashMap<>();
    //路
    final static int L = 10;
    final static int H = 100;
    // 钥匙
    final static int R = 1;
    final static int B = 2;
    final static int Y = 3;
    // 血
    final static int U = 4;
    final static int V = 5;
    final static int W = 6;
    //攻击
    final static int J = 7;
    final static int K = 8;
    //墙
    final static int Q = 50;
    //门
    final static int D = 51;
    final static int E = 52;
    final static int F = 53;

    //楼梯
    final static int T = 54;
    //怪物
    final static int a = 11;// 绿球
    final static int b = 12;// 红球
    final static int c = 13;
    final static int d = 14;
    final static int e = 15;// 骷髅
    final static int f = 16;// 骷髅队长
    final static int g = 17;// 小蝙蝠
    final static int h = 18;// 大蝙蝠
    final static int i = 19;// 低级法师
    final static int j = 20;
    final static int k = 21;// 飞行器


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
        motemap.put(2, map2);
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

    }


}
