package team.shoot.entity;





import team.shoot.World;
import team.shoot.enums.FlyingObject;
import team.shoot.inter.Enemy;

import java.awt.image.BufferedImage;

/** 小敌机*/
public class Airplane extends FlyingObject implements Enemy {
	private static BufferedImage images[];   //图片
	static {
		images = new BufferedImage[3];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("../image/airplane"+i+".png");
		}
	}
	private int speed;
	private int xSpeed;
	/** 构造方法*/
	public Airplane(){
		super(60, 60);
		speed = 3;
		xSpeed = 2;
	}
	@Override
	public void step(){
		x+=xSpeed;
		y+=speed;
		if(x<0 || x> World.WIDTH - this.width) {
			xSpeed*=-1;
		}
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
		return this.y>=World.HEIGTH;
	}
	/** 重写getscore得分*/
	public int getscore() {
		return 1;
	}
}
