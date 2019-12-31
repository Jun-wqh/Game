package team.gobang;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class ChessListener implements MouseListener {
    private GobangDemo gobang;
    public boolean borw;


//    void setGraphics(GobangDemo gobang) {
//
//    }

    ChessListener(GobangDemo gobang) {
        this.gobang = gobang;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (getIndex() % 2 == 0) {
            borw = false;
        } else {
            borw = true;
        }
        Graphics g = gobang.getGraphics();
        int chessx = (e.getX() / gobang.size) * gobang.size + gobang.cell - gobang.x / 2;
        int chessy = (e.getY() / gobang.size) * gobang.size + gobang.cell - gobang.y / 2;
        int col = (chessx - gobang.x) / gobang.size;
        int row = (chessy - gobang.y) / gobang.size;
        if (gobang.chessRecord[(chessx - gobang.x) / gobang.size][(chessy - gobang.y) / gobang.size] != 0) {
            System.out.println("别搞事情");
        } else {
            if (borw) {
                gobang.chessRecord[col][row] = getIndex();
                g.setColor(Color.black);
                g.fillOval(chessx - gobang.size / 2, chessy - gobang.size / 2, gobang.size, gobang.size);
                borw = false;
            } else {
                gobang.chessRecord[col][row] = getIndex();
                g.setColor(Color.white);
                g.fillOval(chessx - gobang.size / 2, chessy - gobang.size / 2, gobang.size, gobang.size);
                borw = true;
            }
        }
    }

    private int getIndex() {
        int index = 1;
        for (int[] ints : gobang.chessRecord) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    index++;
                }
            }
        }
        return index;
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
}
