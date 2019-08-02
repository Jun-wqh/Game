package team.mota.panel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wuyu
 * @date: 2019/7/29
 */
public class DialogueMap {

    public static Map<String, String> dialogueMessageMap = new HashMap<>();
    public static Map<String, String> profiteerMessageMap = new HashMap<>();

    static {
        dialogueMessageMap.put(MotaMap.n + "3", "老者：年轻人，我看你骨骼惊奇，这本怪物图鉴就赠与你。");
        dialogueMessageMap.put(MotaMap.n + "4", "老者：有些门不能用钥匙打开，只有当你打败它的守卫后才会自动打开。");
        dialogueMessageMap.put(MotaMap.n + "6", "老者：你购买了礼物后再与商人对话，他会告诉你一些重要的消息。");
        dialogueMessageMap.put(MotaMap.m + "6", "奸商：魔塔一共50层，每10层为一个区域。如果不打败此区域的头目就不能到更高的地方。");
        dialogueMessageMap.put(MotaMap.m + "7", "奸商：在商店里你最好选择提升防御，只有在攻击力低于敌人的防御力时才提升攻击力。");
    }

    static {
        profiteerMessageMap.put(MotaMap.m + "6", "奸商：我有一把蓝钥匙，你出50金币就卖给你。");
        profiteerMessageMap.put(MotaMap.m + "7", "奸商：我有5把黄钥匙，你出50金币就卖给你。");
    }

}
