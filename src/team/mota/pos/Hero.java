package team.mota.pos;

import team.mota.Door;
import team.mota.panel.MotaMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun-wqh seeyul
 */
public class Hero extends Position {

    public Map<String, Integer> article = new HashMap<>();
    Integer[][] maps;

    public Hero(Integer x, Integer y, Integer map) {
        this.x = x;
        this.y = y;
        maps = MotaMap.motemap.get(map);
        article.put("level", 1);
        article.put("atk", 10);
        article.put("dct", 10);
        article.put("money", 0);
        article.put("hp", 600);
        article.put("redKey", 1);
        article.put("blueKey", 1);
        article.put("yellowKey", 1);
    }

    public boolean add(String name, Integer count) {
        article.put(name, article.get(name) + count);
        return true;
    }


    public boolean use(String name, Integer count) {
        if (article.get(name) >= count) {
            article.put(name, article.get(name) - count);
            return true;
        }
        return false;
    }

    public boolean openDoor(Door door) {
        if (article.get(door.color + "Key") > 0) {
            add(door.color + "Key", 1);
            return true;
        }
        return false;
    }

    public boolean buy(String name, Integer count, Integer money) {
        if (article.get("money") >= money) {
            article.put(name, article.get(name) + count);
            return true;
        }
        return false;
    }


    public Boolean atk(Monster monster) {
        int hp = monster.hp;
        if (article.get("atk") <= monster.dct) {
            return false;
        }
        if (article.get("dct") > monster.atk) {
            return true;
        }
        for (; ; ) {
            hp -= article.get("atk") - monster.dct;
            if (hp <= 0) {
                return true;
            }
            article.put("hp", article.get("hp") + article.get("dct") - monster.atk);
            if (article.get("hp") <= 0) {
                return false;
            }
        }
    }

    public Boolean checkatk(Monster monster) {
        Integer ahp = article.get("hp");
        Integer bhp = monster.hp;
        for (; ; ) {
            bhp -= article.get("atk") - monster.dct;
            if (bhp <= 0) {
                return true;
            }
            ahp -= monster.atk - article.get("dct");
            if (ahp <= 0) {
                return false;
            }
        }
    }

    //加血
    public boolean addHp(String colorhp) {
        int hp = 0;
        if (colorhp.equals("red")) {
            hp = 100;
        }
        if (colorhp.equals("blue")) {
            hp = 200;
        }
        if (colorhp.equals("green")) {
            hp = 400;
        }
        article.put("hp", article.get("hp") + hp);
        return true;
    }

    //加属性
    public boolean addProperty(String crystal) {
        if (crystal.equals("red")) {
            use("atk", 1);
        }
        if (crystal.equals("blue")) {
            use("dct", 1);
        }
        return true;
    }

    public boolean move(int x, int y) {
        int rx = this.x + x;
        int ry = this.y + y;
        Boolean result = false;
        if (rx >= 0 && rx < 11 && ry >= 0 && ry < 11) {
            // 事件处理
            Integer even = maps[rx][ry];
            switch (even) {
                case MotaMap.R:
                case MotaMap.B:
                case MotaMap.Y:
                case MotaMap.U:
                case MotaMap.V:
                case MotaMap.W:
                case MotaMap.J:
                case MotaMap.K:
                    Article article = MonstrtMap.articleMap.get(even);
                    result = this.add(article.name, article.value);
                    break;
                case MotaMap.a:
                case MotaMap.b:
                case MotaMap.c:
                case MotaMap.d:
                case MotaMap.e:
                case MotaMap.f:
                case MotaMap.g:
                case MotaMap.h:
                case MotaMap.i:
                case MotaMap.j:
                    Monster monster = MonstrtMap.monsterMap.get(even);
                    Boolean checkatk = this.checkatk(monster);
                    if (checkatk) {
                        result = this.atk(monster);
                    } else {
                        System.out.println("打不过");
                    }
                    break;
                case MotaMap.Q:
                    break;
                case MotaMap.L:
                    result = true;
                    break;
                case MotaMap.D:
                    result = this.use("yellowKey", 1);
                default:
                    break;
            }
            if (result) {
                maps[this.x][this.y] = MotaMap.L;
                maps[rx][ry] = 100;
                this.x = rx;
                this.y = ry;
            }
        }
        return result;
    }

    public boolean up() {
        return move(-1, 0);
    }

    public boolean down() {
        return move(1, 0);
    }

    public boolean left() {
        return move(0, -1);
    }

    public boolean right() {
        return move(0, 1);
    }

    public void show() {
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println(article);
    }

    // private Integer exp;
    // private Integer level;

}




