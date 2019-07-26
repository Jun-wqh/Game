package team.mota.pos;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0.0
 * @ClassName: MonstrtMap
 * @Description:
 * @author: 厦门智强软件科技
 * @date: 2019/7/26
 * @Copyright:2019 All rights reserved.
 * 注意：本内容仅限于厦门智强软件科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MonstrtMap {
    static Map<String, Object> monstrtMap = new HashMap();

    static {
        monstrtMap.put("绿史莱姆", new Monster("绿史莱姆", 35, 18, 1, 1));
        monstrtMap.put("红史莱姆", new Monster("红史莱姆", 45, 20, 2, 2));
        monstrtMap.put("小蝙蝠", new Monster("小蝙蝠", 35, 38, 3, 3));
        monstrtMap.put("初级法师", new Monster("初级法师", 60, 32, 8, 5));
        monstrtMap.put("骷髅人", new Monster("骷髅人", 50, 42, 6, 6));
        monstrtMap.put("骷髅士兵", new Monster("骷髅士兵", 55, 52, 12, 8));
    }
}
