package team.mota.panel;

import team.mota.pos.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun-wqh seeyul
 */
public class PropertyPanel extends JPanel {

    JLabel[][] labels;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    Property[] property;

    Map<String, Property> propertyMap = new HashMap<>();
    Font font = new Font("宋体", Font.BOLD, 25);

    public PropertyPanel() {
        this.setLayout(new GridLayout(11, 11));
        property = new Property[11];
        property[0] = new Property("层数", 0, 0, MotaMap.H, 0);
        property[1] = new Property("生命", 1, 0, null, 0);
        property[2] = new Property("攻击", 2, 0, null, 0);
        property[3] = new Property("防御", 3, 0, null, 0);
        property[4] = new Property("金币", 4, 0, null, 0);
        property[5] = new Property("红钥匙", 5, 0, MotaMap.R, 0);
        property[6] = new Property("蓝钥匙", 6, 0, MotaMap.B, 0);
        property[7] = new Property("黄钥匙", 7, 0, MotaMap.Y, 0);
        propertyMap.put("level", property[0]);
        propertyMap.put("hp", property[1]);
        propertyMap.put("atk", property[2]);
        propertyMap.put("dct", property[3]);
        propertyMap.put("money", property[4]);
        propertyMap.put("redKey", property[5]);
        propertyMap.put("blueKey", property[6]);
        propertyMap.put("yellowKey", property[7]);
        labels = new JLabel[11][2];
        for (int i = 0; i < property.length; i++) {
            if (property[i] == null) {
                break;
            }
            labels[i][0] = new JLabel();
            labels[i][1] = new JLabel();
            if (property[i].icon != null) {
                ImageIcon icon = new ImageIcon("src\\team\\mota\\res\\" + property[i].icon + ".png");
                icon.setImage(icon.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
                labels[i][0].setIcon(icon);
            } else {
                labels[i][0].setText(property[i].name);
                labels[i][0].setFont(font);
            }
            labels[i][1].setText(property[i].value.toString());
            labels[i][1].setHorizontalAlignment(JLabel.RIGHT);
            labels[i][1].setFont(font);
            this.add(labels[i][0]);
            this.add(labels[i][1]);
        }
        ImageIcon icon1 = new ImageIcon("src\\team\\mota\\res\\"+MotaMap.k+".png");
        icon1.setImage(icon1.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        labels[8][0] = new JLabel();
        labels[8][0].setIcon(icon1);
        this.add(labels[8][0]);

        ImageIcon icon2 = new ImageIcon("src\\team\\mota\\res\\" + MotaMap.p + ".png");
        icon2.setImage(icon2.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
        labels[8][1] = new JLabel();
        labels[8][1].setIcon(icon2);
        this.add(labels[8][1]);
        listener();
        labels[9][0] = new JLabel();
        labels[9][0].setHorizontalAlignment(JLabel.RIGHT);
        this.add(labels[9][0]);
    }

    public void setHero(Hero hero) {
        hero.article.forEach((k, v) -> {
            if (!propertyMap.get(k).value.equals(v)) {
                propertyMap.get(k).value = v;
                labels[propertyMap.get(k).xx][1].setText(v.toString());
            }
        });
        if (hero.msg != null) {
            labels[9][0].setText(hero.msg);
            hero.msg = null;
        }
    }

    public void listener() {
        labels[8][0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("4444");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
