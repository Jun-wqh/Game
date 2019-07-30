package team.shoot.entity;

import team.shoot.World;
import team.shoot.enums.FlyingObject;
import team.shoot.inter.Award;

import java.awt.image.BufferedImage;

public class EnemyBullet extends FlyingObject implements Award {
	private static BufferedImage images[];   //图片
	static {
		images = new BufferedImage[2];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("../image/emm"+i+".png");
		}
	}
	private int speed;
	/** 构造方法*/
	public EnemyBullet(){
		super(50, 100);
		speed = 7;
	}
	@Override
	public void step(){
		y+=speed;
	}
	int index = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return images[index++%2];
		}else if(isDead()) {
				state = REMOVE;
		}
		return null;     
	}
	@Override
	public boolean outOfBounds() {
		return this.y>= World.HEIGTH;
	}
	
	@Override
	public int getType(){
		return 3;
		
	}

}
