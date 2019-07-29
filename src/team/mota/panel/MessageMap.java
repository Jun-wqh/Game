package team.mota.panel;

import javax.swing.*;

/**
 * @author: wuyu
 * @date: 2019/7/29
 */
public class MessageMap {

    public void Message() {
        JFrame frame;

        Object[] options = {"好的"};
        int choice = JOptionPane.showOptionDialog(null, "年轻人，我看你骨骼惊奇，这本怪物图鉴就赠与你",
                "对话", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == 0) {

        }
    }
}
