package team.mota;

import team.mota.panel.MenuPanel;
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
        frame.setLayout(null);
        frame.setBounds(0, 0, 820, 589);
        // 属性面板
        PropertyPanel propertyPanel = new PropertyPanel();
        propertyPanel.setBounds(0, 0, 120, 550);
        frame.add(propertyPanel);
        //菜单面板
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setBounds(680, 0, 120, 550);
        frame.add(menuPanel);
        // 游戏面板
        MotaPanel ml = new MotaPanel(propertyPanel,menuPanel);
        ml.setBounds(120, 0, 550, 550);
        frame.add(ml);
        // 居中，可见
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // 焦点
        ml.setFocusable(true);
    }

}