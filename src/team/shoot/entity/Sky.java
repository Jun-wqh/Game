package team.shoot.entity;


import team.shoot.World;
import team.shoot.enums.FlyingObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/** 天空*/
public class Sky extends FlyingObject {
	private static BufferedImage image; //图片
	static {
		image = loadImage("../image/background.png");
	}
	private int y1;
	private int speed;
	/** 构造方法*/
	public Sky(){
		super(World.WIDTH, World.HEIGTH, 0,0);
		y1 = -height;
		speed = 1;
	}
	@Override
	public void step(){
		y+=speed;
		y1+=speed;
		if(y>=World.HEIGTH) {
			y = -World.HEIGTH;
		}
		if(y1>=World.HEIGTH) {
			y1 = -World.HEIGTH;
		}
	}
	/** 重写getimage获取图片*/
	@Override
	public BufferedImage getImage() {
		return image;
	}
	@Override
	public void paintobject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x,y1,null);
	}
	
	@Override
	public boolean outOfBounds() {
		return false;   //永不越界
	}
}
