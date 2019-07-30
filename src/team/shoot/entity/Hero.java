package team.shoot.entity;


import team.shoot.enums.FlyingObject;

import java.awt.image.BufferedImage;

/**英雄机 */
public class Hero extends FlyingObject {
	private static BufferedImage images[];   //图片
	static {
		images = new BufferedImage[4];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("../image/hero"+i+".png");
		}
	}
	private int life; 
	private int doublefire;
	/** 构造方法*/
	public Hero() {
		super(150, 150, 100, 400);
		life = 30;
		doublefire = 80;
	}
	public void moveTo(int x,int y){
		this.x = x - this.width/2;
		this.y = y - this.height/2;
	}
	@Override
	public void step(){
	}
	int index = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return images[index++%4];
		}
		return images[0];     
	}
	/**发射子弹*/
	public Bullet[] shoot() {
		int xStep = this.width/4;
		int yStep = 20;
		if(doublefire>0 && doublefire<100) {
			Bullet bs[] = new Bullet[2];  
			bs[0] = new Bullet(this.x+1*xStep, y-yStep,0);
			bs[1] = new Bullet(this.x+3*xStep, y-yStep,0);
			doublefire-=2;
			return bs;
		}else if(doublefire>100){
			Bullet bs[] = new Bullet[3];  
			bs[0] = new Bullet(this.x+1*xStep, y-yStep,-1); 
			bs[1] = new Bullet(this.x+3*xStep, y-yStep,1); 
			bs[2] = new Bullet(this.x+2*xStep, y-yStep,0); 
			doublefire-=2;
			return bs;
		}else{
			Bullet bs[] = new Bullet[1];
			bs[0] = new Bullet(this.x+2*xStep, y-yStep,0);
			return bs;
		}
	}

	@Override
	public boolean outOfBounds() {
		return false;   //永不越界
	}
	/** 获取命数*/
	public int getLife(){
		return life;
	}
	/** 撞死减命*/
	public void subtractLife() {
		life --;
	
	}
	/** 撞导弹直接死亡*/
	public void overLife() {
		life-=1000;
	
	}
	/** 火力值清空*/
	public void clearDoubleFire() {
		doublefire = 60;
	}
	/**奖励*/
	public void addLife() {
		life++;
	}
	public void addDoubleFire() {
		doublefire+=50;
	}

}
