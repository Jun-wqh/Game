package team.gobang;

import javax.swing.*;
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
                boolean win = win(col, row, 1);
                if (win) {
                    JOptionPane.showMessageDialog(null, "黑棋赢！", "congratulations", JOptionPane.WARNING_MESSAGE);
                    gobang.chessRecord = new int[18][18];
                    gobang.repaint();
//                    JOptionPane.showConfirmDialog(null, "黑棋赢！", "congratulations", JOptionPane.OK_OPTION);
                }
                borw = false;
            } else {
                gobang.chessRecord[col][row] = getIndex();
                g.setColor(Color.white);
                g.fillOval(chessx - gobang.size / 2, chessy - gobang.size / 2, gobang.size, gobang.size);
                boolean win = win(col, row, 0);
                if (win) {
                    JOptionPane.showMessageDialog(null, "白棋赢！", "congratulations", JOptionPane.WARNING_MESSAGE);
                    gobang.chessRecord = new int[18][18];
                    gobang.repaint();
                }
                borw = true;
            }
        }
    }

    private boolean win(int col, int row, int num) {

        boolean chesses = row(col, row, num);
        if (chesses) {
            return chesses;
        }
        chesses = col(col, row, num);
        if (chesses) {
            return chesses;
        }
        chesses = leftSlant(col, row, num);
        if (chesses) {
            return chesses;
        }
        chesses = rightSlant(col, row, num);
        return chesses;

    }

    private boolean row(int col, int row, int num) {
        int[][] test = gobang.chessRecord;
        int ch = 1;
        for (int c = 1; c <= 5; c++) {
            if (test.length > col + c && test[col + c][row] % 2 == num && test[col + c][row] != 0) {
                ch++;
            } else {
                for (int cc = 1; cc <= 5 - c; cc++) {
                    if (test[col - cc][row] % 2 == num && test[col - cc][row] != 0) {
                        ch++;
                    } else {
                        break;
                    }
                }
                return ch == 5;
            }
        }
        return ch == 5;
    }

    private boolean col(int col, int row, int num) {
        int[][] test = gobang.chessRecord;
        int ch = 1;
        for (int r = 1; r <= 5; r++) {
            if (test.length > col + r && test[col][row + r] % 2 == num && test[col][row + r] != 0) {
                ch++;
            } else {
                for (int rr = 1; rr <= 5 - r; rr++) {
                    if (test[col][row - rr] % 2 == num && test[col][row - rr] != 0) {
                        ch++;
                    } else {
                        break;
                    }
                }
                return ch == 5;
            }
        }
        return ch == 5;
    }

    private boolean leftSlant(int col, int row, int num) {
        int[][] test = gobang.chessRecord;
        int ch = 1;
        for (int r = 1; r <= 5; r++) {
            if (test[0].length > row + r && test.length > col + r && test[col + r][row + r] % 2 == num && test[col + r][row + r] != 0) {
                ch++;
            } else {
                for (int rr = 1; rr <= 5 - r; rr++) {
                    if (test[col - rr][row - rr] % 2 == num && test[col - rr][row - rr] != 0) {
                        ch++;
                    } else {
                        break;
                    }
                }
                return ch == 5;
            }
        }
        return ch == 5;
    }

    private boolean rightSlant(int col, int row, int num) {
        int[][] test = gobang.chessRecord;
        int ch = 1;
        for (int r = 1; r <= 5; r++) {
            if (test[0].length > row + r && test[col - r][row + r] % 2 == num && test[col - r][row + r] != 0) {
                ch++;
            } else {
                for (int rr = 1; rr <= 5 - r; rr++) {
                    if (test[col + rr][row - rr] % 2 == num && test[col + rr][row - rr] != 0) {
                        ch++;
                    } else {
                        break;
                    }
                }
                return ch == 5;
            }
        }
        return ch == 5;
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
