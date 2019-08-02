package team.mota.event;

import team.mota.panel.DialogueMap;
import team.mota.panel.MotaMap;
import team.mota.pos.Hero;

import javax.swing.*;

/**
 * @author: wuyu
 * @date: 2019/8/2
 */
public class DialogueEvent {

    //npc对话事件
    public void dialogue(int npc, Hero hero) {
        Object[] options = new Object[]{};
        String dialogue = "";
        String NPC = npc + "" + hero.article.get("level");
        boolean flag = true;
        if (npc == MotaMap.n) {
            options = new Object[]{"好的"};
            dialogue = DialogueMap.dialogueMessageMap.get(NPC);
        }
        if (npc == MotaMap.m) {
            options = new Object[]{"好的", "打扰了"};
            dialogue = DialogueMap.profiteerMessageMap.get(NPC);
            if ("".equals(dialogue)) {
                flag = false;
                options = new Object[]{"好的"};
                dialogue = DialogueMap.dialogueMessageMap.get(NPC);
            }
        }
        int choice = JOptionPane.showOptionDialog(null, dialogue,
                "对话", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            switch (NPC) {
                case MotaMap.n + "3":
                    hero.book = true;
                    break;
                case MotaMap.m + "6":
                    if (flag) {
                        hero.buy("blueKey", 1, 50);
                    }
                    DialogueMap.profiteerMessageMap.put(MotaMap.m + "6", "");
                    break;
                case MotaMap.m + "7":
                    if (flag) {
                        hero.buy("yellowKey", 5, 50);
                    }
                    DialogueMap.profiteerMessageMap.put(MotaMap.m + "7", "");
                    break;
                default:
            }
        }
    }
}
