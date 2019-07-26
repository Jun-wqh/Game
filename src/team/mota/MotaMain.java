package team.mota;

import team.mota.panel.MotaPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @version V1.0.0
 * @ClassName: main
 * @Description:
 * @author: wuyu
 * @date: 2019/7/22
 */
public class MotaMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame("魔塔bate");
        Panel panel = new Panel();
        frame.add(panel, BorderLayout.NORTH);
//        Saolei sl = new Saolei(20, 20);
        MotaPanel ml = new MotaPanel();
        frame.setBounds(0, 0, 660, 660);
        frame.setLocationRelativeTo(null);
        frame.add(ml, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ml.requestFocus();
    }

}
