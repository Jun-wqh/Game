package team.shoot.entity;


import team.shoot.World;
import team.shoot.enums.FlyingObject;

import java.awt.image.BufferedImage;

public class BossBullet1 extends FlyingObject {
	private static BufferedImage image;
	static {
		image = loadImage("../image/bossbullet.png");
	}
	private int speed;
	private int xSpeed;
	/** 构造方法*/
	public BossBullet1(int x,int y,int xSpeed){
		super(40, 50, x, y);
		this.xSpeed = xSpeed;
		speed = 3;
	}
	@Override
	public void step(){
		x+=xSpeed;
		y+=speed; 
		if(x<0 || x> World.WIDTH - this.width) {
			xSpeed*=-1;
		}
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
