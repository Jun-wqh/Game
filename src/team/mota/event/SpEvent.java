package team.mota.event;

import javax.swing.*;

public class SpEvent {
    public static int space = 20;
    public static int money = 20;

    public static Goods buy4(Integer level) {
        int hp = 100;
        int atk = 2;
        int def = 4;
        if (level == 12) {
            hp = 200;
            atk = 4;
            def = 8;
        }
        if (level == 32) {
            hp = 400;
            atk = 8;
            def = 16;
        }
        if (level == 46) {
            hp = 500;
            atk = 10;
            def = 20;
        }

        String[] options = {"增加" + hp + "点生命值", "增加" + atk + "点攻击力", "增加" + def + "点防御力", "离开"};
        int choice = JOptionPane.showOptionDialog(null, "花" + money + "金币你可以：",
                "商店", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            return new Goods("hp", hp, money);
        }
        if (choice == 1) {
            return new Goods("atk", atk, money);
        }
        if (choice == 2) {
            return new Goods("def", def, money);
        }
        return null;
    }


}
