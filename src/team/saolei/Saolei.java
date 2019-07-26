package team.saolei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * @author Jun-wqh seeyul
 */
public class Saolei extends JPanel {
    // 雷
    Integer[][] LEI;
    // 是否被点击
    Integer[][][] LEIS;
    // 长得像雷区的按钮
    JButton[][] jButton;
    Integer xx;
    Integer yy;

    int sum = 0;
    int leishu = 0;
    Random random = new Random();
    int level = 1;
    int first = 0;
    int reload = 1;
    Font font = new Font("宋体", Font.BOLD, 16);
    ImageIcon shakalaka = new ImageIcon("src\\team\\saolei\\res\\shakalaka.jpg");
    int width = 60;
    int height = 60;


    public void setLevel(int level) {
        this.level = level;
    }

    public int getLeishu() {
        return leishu;
    }

    public void init() {
        sum = 0;
        first = 0;
        this.removeAll();
        this.repaint();
        if (reload == 1) {
            leishu = 0;
            LEI = new Integer[xx][yy];
            LEIS = new Integer[xx][yy][2];
            jButton = new JButton[xx][yy];
            for (int i = 0; i < xx; i++) {
                for (int j = 0; j < yy; j++) {
                    LEI[i][j] = random.nextInt(xx * yy) / level / 10 > 1 ? 0 : 1;
                    if (LEI[i][j] == 1) {
                        leishu++;
                    }
                    LEIS[i][j][0] = 0;
                    LEIS[i][j][1] = -1;
                }
            }
        }
        this.setLayout(new GridLayout(xx, yy));
        for (int i = 0; i < xx; i++) {
            for (int j = 0; j < yy; j++) {
                jButton[i][j] = new JButton();
                int finalI = i;
                int finalJ = j;
                jButton[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (jButton[finalI][finalJ].getIcon() != null) {
                            return;
                        }
                        if (first == 0 && reload == 1) {
                            if (LEI[finalI][finalJ] == 1) {
                                LEI[finalI][finalJ] = 0;
                                leishu--;
                            }
                            first = 1;
                        }
                        if (LEI[finalI][finalJ] == 0) {
                            jButton[finalI][finalJ].setBackground(Color.LIGHT_GRAY);
                            jButton[finalI][finalJ].setOpaque(true);
                            jButton[finalI][finalJ].setBorderPainted(false);
                            int lei = 附近一级雷区(finalI, finalJ);
                            if (lei > 0) {
                                jButton[finalI][finalJ].setText(lei + "");
                            }
                            if (sum + leishu == xx * yy) {
                                Object[] options = {"同难度开始", "新难度"};
                                int response = JOptionPane.showOptionDialog(null, "WIN", "通关！",
                                        JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                                // 难度增加
                                if (response == 1) {
                                    level++;
                                    reload = 1;
                                    init();
                                } else if (response == 0) {
                                    // level = 0;
                                    reload = 1;
                                    init();
                                }
                            }
                        } else {
                            // 踩雷
                            jButton[finalI][finalJ].setBackground(Color.RED);
                            jButton[finalI][finalJ].setOpaque(true);
                            jButton[finalI][finalJ].setBorderPainted(false);
                            for (int i = 0; i < xx; i++) {
                                for (int j = 0; j < yy; j++) {
                                    if (LEI[i][j] == 1) {
                                        jButton[i][j].setBackground(Color.RED);
                                        jButton[i][j].setOpaque(true);
                                        jButton[i][j].setBorderPainted(false);
                                    }
                                }
                            }
                            Object[] options = {"重新开始这一局", "结束", "新游戏"};
                            int response = JOptionPane.showOptionDialog(null, "GameOver", "游戏结束！",
                                    JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                            if (response == 1) {
                                System.exit(0);
                            } else if (response == 0) {
                                reload = 0;
                                for (int i = 0; i < xx; i++) {
                                    for (int j = 0; j < yy; j++) {
                                        LEIS[i][j][0] = 0;
                                        LEIS[i][j][1] = -1;
                                    }
                                }
                                init();
                            } else if (response == 2) {
                                reload = 1;
                                init();
                            }
                        }
                    }

                    private int 附近一级雷区(int x, int y) {
                        if (LEIS[x][y][0] == 1) {
                            return LEIS[x][y][1];
                        } else {
                            sum++;
                            LEIS[x][y][0] = 1;
                        }
                        int lei = 0;
                        if (x - 1 >= 0) {
                            if (y - 1 >= 0) {
                                if (LEI[x - 1][y - 1] == 1) {
                                    lei++;
                                }
                            }
                            if (LEI[x - 1][y] == 1) {
                                lei++;
                            }
                            if (y + 1 < yy) {
                                if (LEI[x - 1][y + 1] == 1) {
                                    lei++;
                                }
                            }
                        }
                        if (y - 1 >= 0) {
                            if (LEI[x][y - 1] == 1) {
                                lei++;
                            }
                        }
                        if (y + 1 < yy) {
                            if (LEI[x][y + 1] == 1) {
                                lei++;
                            }
                        }
                        if (x + 1 < xx) {
                            if (y - 1 >= 0) {
                                if (LEI[x + 1][y - 1] == 1) {
                                    lei++;
                                }
                            }
                            if (LEI[x + 1][y] == 1) {
                                lei++;
                            }
                            if (y + 1 < yy) {
                                if (LEI[x + 1][y + 1] == 1) {
                                    lei++;
                                }
                            }
                        }
                        LEIS[x][y][1] = lei;
                        if (lei == 0) {
                            if (x - 1 >= 0) {
                                if (y - 1 >= 0) {
                                    if (LEI[x - 1][y - 1] != 1) {
                                        附近一级雷区(x - 1, y - 1);
                                    }
                                }
                                if (LEI[x - 1][y] != 1) {
                                    附近一级雷区(x - 1, y);
                                }
                                if (y + 1 < yy) {
                                    if (LEI[x - 1][y + 1] != 1) {
                                        附近一级雷区(x - 1, y + 1);
                                    }
                                }
                            }
                            if (y - 1 >= 0) {
                                if (LEI[x][y - 1] != 1) {
                                    附近一级雷区(x, y - 1);
                                }
                            }
                            if (y + 1 < yy) {
                                if (LEI[x][y + 1] != 1) {
                                    附近一级雷区(x, y + 1);
                                }
                            }
                            if (x + 1 < xx) {
                                if (y - 1 >= 0) {
                                    if (LEI[x + 1][y - 1] != 1) {
                                        附近一级雷区(x + 1, y - 1);
                                    }
                                }
                                if (LEI[x + 1][y] != 1) {
                                    附近一级雷区(x + 1, y);
                                }
                                if (y + 1 < yy) {
                                    if (LEI[x + 1][y + 1] != 1) {
                                        附近一级雷区(x + 1, y + 1);
                                    }
                                }
                            }
                        }
                        jButton[x][y].setBackground(Color.LIGHT_GRAY);
                        jButton[x][y].setOpaque(true);
                        jButton[x][y].setBorderPainted(false);
                        if (lei > 0) {
                            jButton[x][y].setText(lei + "");
                        }
                        return lei;
                    }

                });
                jButton[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            if (LEIS[finalI][finalJ][0] != 1) {
                                if (jButton[finalI][finalJ].getIcon() != null) {
                                    jButton[finalI][finalJ].setIcon(null);
                                } else {
                                    shakalaka.setImage(shakalaka.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                                    jButton[finalI][finalJ].setIcon(shakalaka);
                                }
                            } else {
                                if (jButton[finalI][finalJ].getIcon() != null) {
                                    jButton[finalI][finalJ].setIcon(null);
                                }
                            }
                        }
                    }
                });

                jButton[i][j].setFont(font);
                this.add(jButton[i][j]);
            }
        }
        this.revalidate();
    }

    public Saolei(Integer x, Integer y) {
        xx = x;
        yy = y;
        init();
    }


}
