package team.gobang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MyActionListener implements ActionListener {
    GobangDemo gobang;
    Map<Integer, Integer> index = new HashMap<>();

    MyActionListener(GobangDemo gobang) {
        this.gobang = gobang;
    }

    MyActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("悔棋".equals(e.getActionCommand())) {
            int index = 0;
            int indexi = 0, indexj = 0;
            for (int i = 0; i < gobang.chessRecord.length; i++) {
                for (int j = 0; j < gobang.chessRecord[i].length; j++) {
                    if (index < gobang.chessRecord[i][j]) {
                        index = gobang.chessRecord[i][j];
                        indexi = i;
                        indexj = j;
                    }
                }
            }
            gobang.chessRecord[indexi][indexj] = 0;
            gobang.repaint();
            System.out.println("悔棋");
        }
        if ("开始".equals(e.getActionCommand())) {
            gobang.addMouseListener(new ChessListener(gobang));
            System.out.println("开始");
        }
        if ("认输".equals(e.getActionCommand())) {
            int num = 0;
            for (int i = 0; i < gobang.chessRecord.length; i++) {
                for (int j = 0; j < gobang.chessRecord[i].length; j++) {
                    num = num < gobang.chessRecord[i][j] ? gobang.chessRecord[i][j] : num;
                }
            }if(num== 0){
                JOptionPane.showMessageDialog(null, "小垃圾！", "congratulations", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if (num % 2 == 1) {
                JOptionPane.showMessageDialog(null, "黑棋赢！", "congratulations", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "白棋赢！", "congratulations", JOptionPane.WARNING_MESSAGE);
            }
            gobang.chessRecord = new int[18][18];
            gobang.repaint();
            System.out.println("重新开始");
        }

    }
}

