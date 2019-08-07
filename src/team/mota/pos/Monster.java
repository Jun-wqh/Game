package team.mota.pos;


/**
 * @author Jun-wqh seeyul
 */
public class Monster extends Position {
    public String name;
    public Integer hp;
    public Integer atk;
    public Integer def;
    public Integer money;

    public Monster(String name, Integer hp, Integer atk, Integer def, Integer money) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.money = money;
    }
}
