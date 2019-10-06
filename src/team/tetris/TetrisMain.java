package team.tetris;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Jun-wqh
 */
public class TetrisMain extends JPanel {


    public static void main(String[] args) {
        JFrame frame = new JFrame("俄罗斯方块bate");
        frame.setLayout(null);
        frame.setBounds(0, 0, 456, 639);
        // 提示面板
        IntoPanel intoPanel = new IntoPanel();
        intoPanel.setBounds(300, 0, 150, 600);
        Border border = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY);
        intoPanel.setBorder(border);
        frame.add(intoPanel);
        // 游戏面板
        TetrisPanel tl = new TetrisPanel(intoPanel);
        tl.setBounds(0, 0, 300, 600);
        frame.add(tl);
        // 居中，可见
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // 焦点
        tl.setFocusable(true);
    }


}
