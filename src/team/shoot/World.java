package team.shoot;


import team.shoot.entity.*;
import team.shoot.enums.FlyingObject;
import team.shoot.inter.Award;
import team.shoot.inter.Enemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 整个世界
 */
public class World extends JPanel {
    public static final int WIDTH = 400;
    public static final int HEIGTH = 700;

    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAME_OVER = 3;
    private int state = START;

    private static BufferedImage start;
    private static BufferedImage pause;
    private static BufferedImage gameover;
    private static BufferedImage gameover0;


    static {
        start = FlyingObject.loadImage("../image/start2.png");
        pause = FlyingObject.loadImage("../image/pause1.png");
        gameover = FlyingObject.loadImage("../image/gameover1.png");
        gameover0 = FlyingObject.loadImage("../image/gameover0.png");
    }

    private Sky sky = new Sky();
    private Hero hero = new Hero();
    private BossPlane1 boss = new BossPlane1();
    private BossPlane2 boss2 = new BossPlane2();
    private FlyingObject enemies[] = {};
    private Bullet bullets[] = {};
    private BossBullet1 bossbullet[] = {};
    private BossBullet2 bossbullet2[] = {};

    public World() throws IOException {
    }


    /**
     * 随机产生敌人
     */
    public FlyingObject nextOne() {
        Random rand = new Random();
        int type = rand.nextInt(50);
        System.out.println("随机敌人-->" + type);
        if (type < 30) {
            return new Airplane();
        } else if (type < 40) {
            return new BigAirplane();
        } else if (type < 50) {
            return new Award_All();
        } else {
            System.out.println("糟糕是导弹，快跑！");
            return new EnemyBullet();
        }

    }


    /**
     * 敌人入场
     */
    int enterIndex = 0;   //定时器

    public void enterAction() { //默认10毫秒走一次
        enterIndex++;
        if (enterIndex % 40 == 0) {  //每400毫秒走一次
            FlyingObject obj = nextOne();
            enemies = Arrays.copyOf(enemies, enemies.length + 1);
            enemies[enemies.length - 1] = obj;
        }
    }


    /**
     * 子弹入场
     */
    int shootIndex = 0;

    public void shootAction() {
        shootIndex++;   //10毫秒自增1
        if (shootIndex % 20 == 0) {
            Bullet bs[] = hero.shoot();
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length); //数组扩容
            System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);//数组的追加
        }
    }


    /**
     * boss1子弹入场
     */
    int boshootIndex = 0;

    public void boshootAction() {
        boshootIndex++;   //10毫秒自增1
        if (boshootIndex % 100 == 0) {
            BossBullet1 bos[] = boss.Boss_shoot();
            bossbullet = Arrays.copyOf(bossbullet, bossbullet.length + bos.length);
            System.arraycopy(bos, 0, bossbullet, bossbullet.length - bos.length, bos.length);
        }
    }

    /**
     * boss2子弹入场
     */
    int boshootIndex2 = 0;

    public void boshootAction2() {
        boshootIndex2++;   //10毫秒自增1
        if (boshootIndex2 % 70 == 0) {
            BossBullet2 bos2[] = boss2.Boss_shoot2();
            bossbullet2 = Arrays.copyOf(bossbullet2, bossbullet2.length + bos2.length);
            System.arraycopy(bos2, 0, bossbullet2, bossbullet2.length - bos2.length, bos2.length);

        }
    }

    /**
     * 飞行物移动
     */
    public void stepAction() {
        sky.step();
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].step();
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].step();
        }
        for (int i = 0; i < bossbullet.length; i++) {
            bossbullet[i].step();
        }
    }

    /**
     * 删除越界敌人
     */
    public void outOfBoundsAction() {
        int index = 0; //不越界敌人数组下标，表示不越界个数
        FlyingObject enemyLives[] = new FlyingObject[enemies.length]; //生成一个新数组，长度跟敌人数组一样
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];
            if (!f.outOfBounds() && !f.isRemove()) { //不越界并且不是删除状态
                enemyLives[index] = f;
                index++;
            }
        }
        enemies = Arrays.copyOf(enemyLives, index);
        /**删除越界子弹*/
        index = 0; //不越界数组下标归零，数量归零
        Bullet bulletLives[] = new Bullet[bullets.length];
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            if (!b.outOfBounds() && !b.isRemove()) {
                bulletLives[index] = b;
                index++;
            }
        }
        bullets = Arrays.copyOf(bulletLives, index);
    }

    /**
     * 子弹打死敌人得分或者获得奖励
     */
    int score = 0;

    public void bulletBangAction() {

        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];


            /** boss1子弹跟英雄机子弹碰撞*/
            for (int t = 0; t < bossbullet.length; t++) {
                BossBullet1 x = bossbullet[t];
                if (x.isLife() && b.isLife() && x.hit(b)) {
                    b.goDead();
                    x.goDead();

                }
            }


            /** boss2子弹跟英雄机子弹碰撞*/
            for (int m = 0; m < bossbullet2.length; m++) {
                BossBullet2 x = bossbullet2[m];
                if (x.isLife() && b.isLife() && x.hit(b)) {
                    b.goDead();
                    x.goDead();

                }
            }


            for (int j = 0; j < enemies.length; j++) {
                FlyingObject f = enemies[j];
                if (b.isLife() && f.isLife() && f.hit(b)) {

                    if (f instanceof Enemy) { //强制转换条件，为true就走下去，避免异常
                        b.goDead();
                        f.goDead();
                        Enemy en = (Enemy) f;
                        score += en.getscore();

                    }

                }


            }
            if (boss.isLife() && b.isLife() && boss.hit(b)) {
                b.goDead();
                boss.subtractBossLife();
            }
            if (boss2.isLife() && b.isLife() && boss2.hit(b)) {
                b.goDead();
                boss2.subtractBossLife();
            }
        }
    }


    /**
     * 英雄机撞上敌人
     */
    public void heroBangAction() {
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];
            if (hero.isLife() && f.isLife() && f.hit(hero)) {
                f.goDead();
                //大敌机小敌机撞击
                if (f instanceof Enemy) {
                    f.gosDead();
                    hero.subtractLife();
                    hero.clearDoubleFire();
                    Enemy en = (Enemy) f;   //加分
                    score += en.getscore();
                }

                //奖励无法被击中
                if (f instanceof Award) {
                    Award aw = (Award) f;
                    f.goDead();
                    int type = aw.getType();
                    switch (type) {
                        case Award.DOUBLE_FIRE:
                            hero.addDoubleFire();
                            break;
                        case Award.LIFE:
                            hero.addLife();
                            break;
                        case Award.BOOM:
                            getBoom();
                            break;
                        case Award.DEAD:
                            hero.overLife();
                            break;
                    }
                }
            }
        }
        /**英雄机跟boss碰撞*/
        if (hero.isLife() && boss.isLife() && hero.hit(boss)) {
            hero.subtractLife();
            boss.subtractBossLife();

        }
        /** 英雄机被boss1打中*/
        for (int i = 0; i < bossbullet.length; i++) {
            BossBullet1 bos = bossbullet[i];
            if (bos.isLife() && hero.isLife() && bos.hit(hero)) {
                bos.goDead();
                hero.subtractLife();
                hero.clearDoubleFire();
            }
        }

        /** 英雄机被boss2打中*/
        for (int i = 0; i < bossbullet2.length; i++) {
            BossBullet2 bos2 = bossbullet2[i];
            if (bos2.isLife() && hero.isLife() && bos2.hit(hero)) {
                bos2.goDead();
                hero.subtractLife();
                hero.clearDoubleFire();
            }
        }


    }

    /**
     * 全屏爆破
     */
    public void getBoom() {
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];
            if (f instanceof Enemy) {
                f.gosDead();
            }
        }
        for (int i = 0; i < bossbullet.length; i++) {
            BossBullet1 b = bossbullet[i];
            b.goDead();
        }
        for (int i = 0; i < bossbullet2.length; i++) {
            BossBullet2 b = bossbullet2[i];
            b.goDead();
        }
    }


    /**
     * 检测游戏结束
     */
    public void checkGameOverAction() {
        if (hero.getLife() <= 0 || boss2.getBossLife() <= 0) {
            state = GAME_OVER;
        }
    }

    /**
     * 启动程序
     */
    public void action() {
        /** 重写鼠标移动方法*/
        MouseAdapter l = new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                if (state == RUNNING) {
                    int x = e.getX();
                    int y = e.getY();
                    hero.moveTo(x, y);
                }
            }

            public void mouseClicked(MouseEvent e) {
                switch (state) {
                    case START:
                        state = RUNNING;
                        break;
                    case GAME_OVER:
                        score = 0;
                        sky = new Sky();
                        hero = new Hero();
                        bossbullet = new BossBullet1[0];
                        boss = new BossPlane1();
                        enemies = new FlyingObject[0];
                        bullets = new Bullet[0];
                        state = START;
                        break;
                }
            }

            public void mouseExited(MouseEvent e) { //鼠标移出
                if (state == RUNNING) {
                    state = PAUSE;
                }

            }

            public void mouseEntered(MouseEvent e) { //鼠标移入
                if (state == PAUSE) {
                    state = RUNNING;
                }
            }
        };
        this.addMouseListener(l);   //处理鼠标的操作时间
        this.addMouseMotionListener(l); //处理鼠标的滑动时间

        Timer timer = new Timer();
        int interval = 10;
        timer.schedule(new TimerTask() {
            @Override
            public void run() { //定时干的事，10个毫秒走一次
                if (state == RUNNING) {
                    enterAction();            //敌人入场
                    shootAction();            //子弹入场
                    boshootAction();        //boss子弹入场
                    boshootAction2();        //boss2子弹入场
                    stepAction();            //飞行物移动
                    outOfBoundsAction();     //删除越界
                    bulletBangAction();     //子弹和敌人的碰撞
                    heroBangAction();       //英雄机碰撞
                    checkGameOverAction();  //检测游戏结束
                }
                repaint();
            }
        }, interval, interval);
    }


    public void paint(Graphics g) {
        sky.paintobject(g);
        hero.paintobject(g);
        /** boss1*/
        if (score > 45 && score < 50) {
            g.drawImage(gameover0, 0, 0, null);
        }
        if (score > 50) {
            for (int i = 0; i < bossbullet.length; i++) {
                bossbullet[i].paintobject(g);
                if (state == RUNNING) {
                    bossbullet[i].step();
                }
            }
            boss.Boss_shoot();
            boss.paintobject(g);
            if (state == RUNNING) {
                boss.step();
            }
        }
        /** boss2*/
        if (score > 95 && score < 100) {
            g.drawImage(gameover0, 0, 0, null);
        }
        if (score > 120) {
            for (int i = 0; i < bossbullet2.length; i++) {
                bossbullet2[i].paintobject(g);
                if (state == RUNNING) {
                    bossbullet2[i].step();
                }
            }
            boss2.Boss_shoot2();
            boss2.paintobject(g);
            if (state == RUNNING) {
                boss2.step();
            }
        }

        for (int i = 0; i < enemies.length; i++) {
            enemies[i].paintobject(g);
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].paintobject(g);
        }


        g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 28));
        g.setColor(Color.WHITE);
        g.drawString("SCORE:" + score, 10, 25);
        g.drawString("LIFE:" + hero.getLife(), 10, 45);

        switch (state) {
            case START:
                g.drawImage(start, 0, 0, null);
                break;
            case PAUSE:
                g.drawImage(pause, 0, 0, null);
                break;
            case GAME_OVER:
                g.drawString("SCORE:" + score, 130, 300);
                g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 28));
                g.setColor(Color.WHITE);
                g.drawImage(gameover, 0, 0, null);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(WIDTH, HEIGTH);
        frame.setVisible(true);
        world.action();
    }

}
