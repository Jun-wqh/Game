package team.mota.event;

import javax.swing.*;

public class SpEvent {
    public static int space = 20;
    public static int money = 20;

    public static Goods buy4() {
        String[] options = {"增加100点生命值", "增加2点攻击力", "增加4点防御力", "离开"};
        int choice = JOptionPane.showOptionDialog(null, "花" + money + "金币你可以：",
                "商店", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            return new Goods("hp", 100, money);
        }
        if (choice == 1) {
            return new Goods("atk", 2, money);
        }
        if (choice == 2) {
            return new Goods("dct", 4, money);
        }
        if (choice == 3) {
        }
        return null;
    }


}
