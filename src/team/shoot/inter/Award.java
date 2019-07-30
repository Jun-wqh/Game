package team.shoot.inter;

public interface Award {
	public int DOUBLE_FIRE = 0;
	public int LIFE = 1;
	public int BOOM = 2;
	public int DEAD = 3;
	/** 获取奖励类型*/
	public int getType();
}
