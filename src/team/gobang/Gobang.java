package team.gobang;


import team.saolei.Saolei;

import javax.swing.*;
import java.awt.*;

/**
 * @author dongziyu
 */
public class Gobang {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Golang");
        Panel panel = new Panel();
        frame.add(panel, BorderLayout.NORTH);
        frame.setBounds(0, 0, 800, 800);
        //居中
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
