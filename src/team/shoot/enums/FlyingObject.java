package team.shoot.enums;

import team.shoot.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 飞行类
 */
public abstract class FlyingObject {
    /**
     * 定义常量
     */
    public static final int LIFE = 0;
    public static final int DEAD = 1;
    public static final int REMOVE = 2;
    protected int state = LIFE;

    protected int width;
    protected int height;
    protected int x;
    protected int y;

    //空的构造方法
    public FlyingObject() {

    }

    /**
     * 英雄机、天空、子弹
     */
    public FlyingObject(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    /**
     * 小敌机、大敌机、蜜蜂
     */
    public FlyingObject(int width, int height) {
        this.width = width;
        this.height = height;
        Random random = new Random();
        x = random.nextInt(World.WIDTH - this.width);
        y = -this.height;
    }

    /**
     * 移动抽象方法
     */
    public abstract void step();

    /**
     * 获取图片 抽象方法
     */
    public abstract BufferedImage getImage();

    /**
     * 读取图片 ctrl+mC
     */
    public static BufferedImage loadImage(String fileName) {
        try {
            BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName)); //同包中读取
            return img;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 判断状态
     */
    public boolean isLife() {
        return state == LIFE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public boolean isRemove() {
        return state == REMOVE;
    }

    /**
     * 画对象
     */
    public void paintobject(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }

    /**
     * 检测飞行物是否越界
     */
    public abstract boolean outOfBounds();

    /**
     * 检测敌人(this)与子弹/英雄机(other)的碰撞
     */
    public boolean hit(FlyingObject other) {
        int x1 = this.x - other.width;
        int x2 = this.x + this.width;
        int y1 = this.y - other.height;
        int y2 = this.y + this.height;
        int x = other.x;
        int y = other.y;
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;

    }

    /**
     * 检测死亡
     */
    public void goDead() {
        state = DEAD;
    }

    public void gosDead() {
        state = DEAD;
    }
}

