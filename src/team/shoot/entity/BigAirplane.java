package team.shoot.entity;


import team.shoot.World;
import team.shoot.enums.FlyingObject;
import team.shoot.inter.Enemy;

import java.awt.image.BufferedImage;

/** 大敌机*/
public class BigAirplane extends FlyingObject implements Enemy {
	private static BufferedImage images[];   //图片
	static {
		images = new BufferedImage[3];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("../image/bigplane"+i+".png");
		}
	}
	private int speed;
	private int life;
	
	/**构造方法*/
	public BigAirplane(){
		super(100, 80);
		speed = 3;
		life = 3;
	}
	@Override
	public void step(){
		y+=speed;
	}
	
	int index = 1;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return images[0];
		}else if(isDead()) {
			BufferedImage img = images[index++];
			if(index==images.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;     
	}

	@Override
	public boolean outOfBounds() {
		return this.y>= World.HEIGTH;
	}
	/** 重写个体score得分*/
	public int getscore() {
		return 1;
	}
	
	/** 获取命数*/
	public int getBigLife(){
		return life;
	}
	/** 撞死减命*/
	@Override
	public void goDead() {
		if(life<=0) {
			state = DEAD;
		}else{
			life -- ;
		}
	}
	

}
