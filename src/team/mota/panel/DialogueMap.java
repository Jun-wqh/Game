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
        dialogueMessageMap.put(MotaMap.nC + "2", "老者：。");
        dialogueMessageMap.put(MotaMap.nC + "3", "老者：年轻人，我看你骨骼惊奇，这本怪物图鉴就赠与你。");
        dialogueMessageMap.put(MotaMap.nC + "4", "老者：有些门不能用钥匙打开，只有当你打败它的守卫后才会自动打开。");
        dialogueMessageMap.put(MotaMap.nC + "6", "老者：你购买了礼物后再与商人对话，他会告诉你一些重要的消息。");
        dialogueMessageMap.put(MotaMap.nB + "2", "奸商：。");
        dialogueMessageMap.put(MotaMap.nB + "6", "奸商：魔塔一共50层，每10层为一个区域。如果不打败此区域的头目就不能到更高的地方。");
        dialogueMessageMap.put(MotaMap.nB + "7", "奸商：在商店里你最好选择提升防御，只有在攻击力低于敌人的防御力时才提升攻击力。");
        dialogueMessageMap.put(MotaMap.mR + "10-1", "骷髅队长：哈哈哈，你是如此的幸运能安全到达这里，但现在好运离你而去，你中埋伏了，弟兄们给我上。");
        dialogueMessageMap.put(MotaMap.mR + "10-2", "骷髅队长：你怎能杀出重围？我是绝不会让你通过的，来吧。我要与你决斗！。");
        dialogueMessageMap.put(MotaMap.mR + "10-3", "骷髅队长：不，这是不可能的，你怎会打败我！你别太得意，后面还有许多强大的对手和机关存在，你稍有疏忽就必死无疑。");
        dialogueMessageMap.put(MotaMap.mC + "3", "魔王：欢迎来到魔塔，你是第一百位挑战者。你若能打败我所有的手下，我就与你一对一的决斗，现在你必须接受我的安排。");
        dialogueMessageMap.put(MotaMap.nA + "2-1", "小偷：你醒了吗？你到监狱时还处于昏迷，魔法警卫把你扔到我这个房间，但你很幸运，我刚完成逃跑的暗道，我们一起越狱吧。");
        dialogueMessageMap.put(MotaMap.nA + "2-2", "小偷：你的剑和盾被警卫拿走了，你必须先找到武器，我知道铁剑在5楼，铁盾在9楼，你最好先取到它们。我现在有事要做没法帮你，再见。");
        dialogueMessageMap.put(MotaMap.nA + "10-1", "小偷：嘿！我们又见面了！非常看些你打败了此区域的头目。我正苦恼于如何到更高的楼层，现在我终于可以上去了，我听说银盾在11楼，银剑在17楼，这消息不知道对你是否有用。");
    }

    static {
        profiteerMessageMap.put(MotaMap.nB + "6", "奸商：我有一把蓝钥匙，你出50金币就卖给你。");
        profiteerMessageMap.put(MotaMap.nB + "7", "奸商：我有5把黄钥匙，你出50金币就卖给你。");
    }

}
