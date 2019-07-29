package team.mota.pos;


/**
 * @author Jun-wqh seeyul
 */
public class Monster extends Position {
    public String name;
    public Integer hp;
    public Integer atk;
    public Integer dct;
    public Integer money;

    public Monster(String name, Integer hp, Integer atk, Integer dct, Integer money) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.dct = dct;
        this.money = money;
    }
}
