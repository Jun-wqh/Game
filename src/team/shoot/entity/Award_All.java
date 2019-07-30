package team.shoot.entity;


import team.shoot.World;
import team.shoot.enums.FlyingObject;
import team.shoot.inter.Award;

import java.awt.image.BufferedImage;
import java.util.Random;

/** 小蜜蜂嗡嗡嗡*/
public class Award_All extends FlyingObject implements Award {
	private static BufferedImage image1;
	private static BufferedImage image2;
	private static BufferedImage image3;
	static {
		image1 = loadImage("../image/fire.png");   //fire
		image2 = loadImage("../image/boom.png");   //boom
		image3 = loadImage("../image/life.png");	//life
	}
	
	private int ySpeed;
	private int awardType;
	/** 构造方法*/
	public Award_All(){
		super(58, 58);
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(3);
	}
	@Override
	public void step(){
		y+=ySpeed;
		
//		if(x<=0 || x>World.WIDTH-this.width) {
//			xSpeed*=-1;
//		}
		
	}
	
	int index = 1;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(awardType == 0) {
				return image1;
			}else if (awardType == 1) {
				return image3;
			}else if (awardType == 2){
				return image2;
			}
		}else if(isDead()) {
			state = REMOVE;   
		}
		return null;
	}

	@Override
	public boolean outOfBounds() {
		return this.y>= World.HEIGTH;
	}
	/** 重写getType获取奖励类型*/
	public int getType(){
		return awardType;
	}
	
	
}
