package team.tetris;


import javax.swing.*;
import java.awt.*;

/**
 * @author Jun-wqh
 */
public class TetrisMain extends JPanel {


    public static void main(String[] args) {
        JFrame frame = new JFrame("俄罗斯方块bate");
        IntoPanel intoPanel = new IntoPanel();
        frame.add(intoPanel, BorderLayout.EAST);
        TetrisPanel tl = new TetrisPanel(intoPanel);
        // 配置属性面板
        frame.setBounds(0, 0, 660, 660);
        frame.add(tl, BorderLayout.CENTER);
        // 居中，可见
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // 焦点
        tl.requestFocus();
    }


}
