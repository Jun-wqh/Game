package team.shoot.entity;


import team.shoot.World;
import team.shoot.enums.FlyingObject;

import java.awt.image.BufferedImage;

public class BossPlane2 extends FlyingObject {
	private static BufferedImage images[];
	static {
		images = new BufferedImage[3];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("../image/boss_"+i+".png");
		}
	}
	private int speed;
	private int life; 
	private int xSpeed;
	/** 构造方法*/
	public BossPlane2(){
		super(300, 200,0,-250);
		speed = 3;
		life = 100;
		xSpeed = 2;
	}
	@Override
	public void step(){
		x+=xSpeed;
		y+=speed;
		if(y >= 0) {
			speed = 0;
		}
		if(x<0 || x> World.WIDTH - this.width) {
			xSpeed*=-1;
		}
	}
	
	
	int index = 1;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(life>20 && life<=100) {
				return images[0];
			}else if(life>0 && life<=20) {
				return images[1];
			}else{
				state = REMOVE;
				return images[2];
			}
		}
		return null;
	}
	/**发射子弹*/
	public BossBullet2[] Boss_shoot2() {
		int xStep = this.width/4;
		int yStep = 20+this.height;
		if(life>0) {
		BossBullet2 bos2[] = new BossBullet2[3];  
		bos2[0] = new BossBullet2(this.x+1*xStep, y+yStep,-1); 
		bos2[1] = new BossBullet2(this.x+3*xStep, y+yStep,0); 
		bos2[2] = new BossBullet2(this.x+2*xStep, y+yStep,1); 
		return bos2;
		}else {
			BossBullet2 bb[] = {};
			return bb;
		}
		
	}
	
	/** 获取命数*/
	public int getBossLife(){
		return life;
	}
	/** 撞死减命*/
	public void subtractBossLife() {
		life --;
	}
	/** 检测是否越界*/
	@Override
	public boolean outOfBounds() {
		return this.y>=World.HEIGTH;
	}
	public int getBossxSpeed(){
		xSpeed = 0;
		return xSpeed;
	}
}
