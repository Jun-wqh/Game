package team.mota;

import team.mota.panel.MotaPanel;
import team.mota.panel.PropertyPanel;

import javax.swing.*;

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
        PropertyPanel propertyPanel = new PropertyPanel();
        propertyPanel.setBounds(0, 0, 120, 550);
        frame.setLayout(null);
        frame.add(propertyPanel);
        MotaPanel ml = new MotaPanel(propertyPanel);
        ml.setBounds(120,0,550,550);
        // 配置属性面板
        frame.setBounds(0, 0, 686, 589);
        frame.add(ml);
        // 居中，可见
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // 焦点
        ml.requestFocus();
    }

}
