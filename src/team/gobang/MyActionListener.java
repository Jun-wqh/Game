package team.gobang;

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
            System.out.println("重新开始");
        }

    }
}

