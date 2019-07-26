package team.mota;

/**
 * @version V1.0.0
 * @ClassName: Monster
 * @Description:
 * @author: 厦门智强软件科技
 * @date: 2019/7/26
 * @Copyright:2019 All rights reserved.
 * 注意：本内容仅限于厦门智强软件科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
class Monster extends Position {
    public Integer hp;
    public Integer atk;
    public Integer dct;
    public Integer money;

    public Monster(Integer hp, Integer atk, Integer dct, Integer money) {
        this.hp = hp;
        this.atk = atk;
        this.dct = dct;
        this.money = money;
    }
}
