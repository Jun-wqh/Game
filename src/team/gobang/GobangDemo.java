package team.gobang;

import javax.swing.*;
import java.awt.*;

/**
 * @version V1.0.0
 * @ClassName: GobangDemo
 */
public class GobangDemo extends JPanel {
    public Graphics graphics;
    public int cell = 18;
    int size = 35;
    public int x = 10, y = 10;
    public int[][] chessRecord = new int[18][18];

    //主函数入口
    public static void main(String args[]) {
        GobangDemo gf = new GobangDemo();
        gf.initBobang();

    }

    private void initBobang() {

        JFrame frame = new JFrame();
        frame.setTitle("五子棋");
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);

        frame.setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(600, 0));
        this.setBackground(Color.decode("#f1c4cd"));
        frame.add(this, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 0));
        panel.setBackground(Color.white);
        JButton startBtn = new JButton("开始");
        JButton backBtn = new JButton("悔棋");
        JButton loseBtn = new JButton("认输");
        frame.add(panel, BorderLayout.EAST);

        //设置选项按钮
        String[] boxname = {"单机", "人机", "联机"};
        JComboBox box = new JComboBox(boxname);
        box.setBackground(Color.white);
        panel.add(box);
        panel.add(startBtn);
        panel.add(backBtn);
        panel.add(loseBtn);

        startBtn.addActionListener(new MyActionListener(this));
        backBtn.addActionListener(new MyActionListener(this));
        loseBtn.addActionListener(new MyActionListener(this));

        frame.setVisible(true);

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (int i = 0; i < cell; i++) {
            graphics.setColor(Color.black);
            graphics.drawLine(x + i * size, y, x + i * size, y + (cell - 1) * size);
            graphics.drawLine(x, y + i * size, x + (cell - 1) * size, y + i * size);
            for (int j = 0; j < cell; j++) {
                int chessx = size * i + x;
                int chessy = size * j + y;
                if (chessRecord[i][j] % 2 == 1) {
                    graphics.setColor(Color.black);
                    graphics.fillOval(chessx - size / 2, chessy - size / 2, size, size);
                    graphics.setColor(Color.white);
                } else if (chessRecord[i][j] % 2 == 0 && chessRecord[i][j] != 0) {
                    graphics.setColor(Color.white);
                    graphics.fillOval(chessx - size / 2, chessy - size / 2, size, size);
                    graphics.setColor(Color.black);
                }
            }
        }
    }

}
