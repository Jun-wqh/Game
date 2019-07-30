package team.shoot.entity;


import team.shoot.enums.FlyingObject;

import java.awt.image.BufferedImage;

/** 子弹你别飞*/
public class Bullet extends FlyingObject {
	private static BufferedImage image;
	static {
		image = loadImage("../image/bullet.png");
	}
	private int speed;
	private int xSpeed;
	/** 构造方法*/
	public Bullet(int x,int y,int xSpeed){
		super(40, 50, x, y);
		this.xSpeed = xSpeed;
		speed = 5;
	}
	@Override
	public void step(){
		x+=xSpeed;
		y-=speed; 
	}
	
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else if(isDead()) {
			state = REMOVE;
		}
		return null;     
	}

	@Override
	public boolean outOfBounds() {
		return this.y<=-this.height;
	}
}
