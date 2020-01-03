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
    public static void npcDialogue(int npc, Hero hero) {
        Object[] options = new Object[]{};
        String dialogue = "";
        String NPC = npc + "" + hero.article.get("level");
        boolean flag = true;
        if (npc == MotaMap.nC || npc == MotaMap.nA) {
            options = new Object[]{"好的"};
            dialogue = DialogueMap.dialogueMessageMap.get(NPC);
        }
        if (npc == MotaMap.nB) {
            options = new Object[]{"好的", "打扰了"};
            dialogue = DialogueMap.profiteerMessageMap.get(NPC);
            if ("".equals(dialogue)) {
                flag = false;
                options = new Object[]{"好的"};
                dialogue = DialogueMap.dialogueMessageMap.get(NPC);
                hero.change = true;
            }
        }
        int choice = JOptionPane.showOptionDialog(null, dialogue,
                "对话", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            switch (NPC) {
                case MotaMap.nC + "3":
                    hero.book = true;
                    break;
                case MotaMap.nB + "6":
                    if (flag) {
                        hero.buy("blueKey", 1, 50);
                    }
                    DialogueMap.profiteerMessageMap.put(MotaMap.nB + "6", "");
                    break;
                case MotaMap.nB + "7":
                    if (flag) {
                        hero.buy("yellowKey", 5, 50);
                    }
                    DialogueMap.profiteerMessageMap.put(MotaMap.nB + "7", "");
                    break;
                default:
            }
        }
    }

    public static Integer bossDialogue(Integer boss, Hero hero) {
        Object[] options = {"结束"};
        String dialogue = DialogueMap.dialogueMessageMap.get(boss + "" + hero.article.get("level"));
        if (boss == MotaMap.mR) {
            dialogue = DialogueMap.dialogueMessageMap.get(boss + "" + hero.article.get("level") + "-" + hero.bossEvent);
        }
        int choice = JOptionPane.showOptionDialog(null, dialogue,
                "对话", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            if (boss == MotaMap.mC) {
                Integer[][] map = hero.maps;
                map[6][4] = MotaMap.rA;
                map[7][4] = MotaMap.rA;
                map[9][4] = MotaMap.rA;
                map[8][3] = MotaMap.rA;
                map[8][4] = MotaMap.rA;
                map[8][5] = MotaMap.rA;
                map[10][1] = MotaMap.hr;
                Integer[][] map2 = MotaMap.motemap.get(2);
                map2[7][3] = MotaMap.hr;
                map2[9][0] = MotaMap.rA;
                hero.x = 7;
                hero.y = 3;
                hero.article.put("hp", 400);
                hero.article.put("atk", 10);
                hero.article.put("def", 10);
                hero.article.put("level", 2);
            }
            return hero.bossEvent;
        }
        return 0;
    }

    public static void thiefDialogue(Hero hero) {
        Object[] options = {"继续"};
        Object[] option1 = {"结束"};
        String dialogue = DialogueMap.dialogueMessageMap.get(MotaMap.nA + "" + hero.article.get("level") + "-1");
        String dialogue2 = DialogueMap.dialogueMessageMap.get(MotaMap.nA + "" + hero.article.get("level") + "-2");
        int choice = JOptionPane.showOptionDialog(null, dialogue,
                "对话", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            if (hero.article.get("level") == 2) {
                int choice2 = JOptionPane.showOptionDialog(null, dialogue2, "对话", JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, option1, option1[0]);
                if (choice2 == 0) {
                    Integer[][] map = hero.maps;
                    map[6][1] = MotaMap.rA;
                }
            }
        }
    }
}
