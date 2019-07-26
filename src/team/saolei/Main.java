package team.saolei;

import javax.swing.*;
import java.awt.*;
/**
 * @author Jun-wqh seeyul
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("SAOLEI");
        Panel panel = new Panel();
        frame.add(panel, BorderLayout.NORTH);
//        Saolei sl = new Saolei(20, 20);
        Saolei sl = new Saolei(10, 10);
        frame.setBounds(0, 0, 900, 900);
        frame.setBounds(0, 0, 450, 450);
        frame.setLocationRelativeTo(null);
        sl.setLevel(1);
        frame.add(sl, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
