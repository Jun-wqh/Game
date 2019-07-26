package team.mota.panel;

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
    //门
    public final static int D = 51;//黄门
    public final static int E = 52;//蓝门
    public final static int F = 53;//红门
    public final static int G = 53;//铁门

    //楼梯
    public final static int T = 54;//上楼
    public final static int S = 55;//下楼
    //怪物
    public final static int a = 11;// 绿球
    public final static int b = 12;// 红球
    public final static int c = 13;
    public final static int d = 14;
    public final static int e = 15;// 骷髅
    public final static int f = 16;// 骷髅队长
    public final static int g = 17;// 小蝙蝠
    public final static int h = 18;// 大蝙蝠
    public final static int i = 19;// 低级法师
    public final static int j = 20;// 中级守卫
    public final static int k = 21;// 飞行器
    public final static int l = 21;// 小偷
    public final static int m = 21;// 奸商
    public final static int n = 21;// 老头


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
                {L, L, Q, Q, L, j, L, j, L, Q, Q},
                {L, Q, Q, Q, Q, Q, L, Q, Q, Q, Q},
                {L, Q, R, R, Q, L, L, L, Q, L, n},
                {L, Q, R, L, G, L, L, L, G, L, L},
                {L, Q, Q, Q, Q, L, L, L, Q, Q, Q},
                {L, Q, l, L, Q, L, L, L, Q, L, m},
                {L, Q, L, L, G, L, L, L, G, L, L},
                {L, Q, Q, Q, Q, L, L, L, Q, Q, Q},
                {L, Q, V, V, Q, L, L, L, Q, L, L},
                {T, Q, V, L, G, L, L, L, G, L, L}
        };
        motemap.put(2, map2);
        Integer[][] map3 = new Integer[][]{
                {R, K, Q, R, V, R, Q, L, Q, L, U},
                {L, U, Q, V, R, V, Q, L, D, g, L},
                {i, L, Q, R, B, R, Q, L, Q, Q, Q},
                {D, Q, Q, Q, L, Q, Q, L, Q, L, n},
                {L, L, g, L, L, L, a, L, D, L, L},
                {D, Q, Q, L, L, L, Q, L, Q, Q, Q},
                {e, L, Q, Q, L, Q, Q, L, Q, L, U},
                {L, R, Q, L, L, L, Q, L, D, i, R},
                {U, J, Q, L, L, L, Q, L, Q, Q, Q},
                {Q, Q, Q, Q, L, Q, Q, b, Q, L, L},
                {T, L, L, L, L, L, Q, L, D, L, S}
        };
        motemap.put(3, map3);
        Integer[][] map4 = new Integer[][]{
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
        motemap.put(4, map4);

    }


}
