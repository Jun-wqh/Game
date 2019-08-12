package team.mota.pos;

import team.mota.event.*;
import team.mota.panel.MotaMap;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun-wqh seeyul
 */
public class Hero extends Position {

    public Map<String, Integer> article = new HashMap<>();
    public Integer[][] maps;
    public String msg = null;
    public Boolean fly = false;// 飞行器
    public Boolean book = false;// 图鉴
    public Boolean note = false;// 记事本
    public Boolean gold = false;// 金币
    public Integer doubleGold = 1;
    public boolean change = false;
    public Integer bossEvent = 1;

    public Hero(Integer map) {
        maps = MotaMap.motemap.get(map);
        boolean flagt = false;
        for (int i = 0; i < maps.length; i++) {
            if (flagt) {
                break;
            }
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == MotaMap.H) {
                    this.x = i;
                    this.y = j;
                    flagt = true;
                    break;
                }
            }
        }
        article.put("level", map);
        article.put("atk", 100);
        article.put("def", 100);
        article.put("money", 0);
        article.put("hp", 1000);
        article.put("redKey", 10);
        article.put("blueKey", 0);
        article.put("yellowKey", 10);
    }

    public boolean add(String name, Integer count) {
        if (name.equals("money")) {
            count = doubleGold * count;
        }
        article.put(name, article.get(name) + count);
        return true;
    }

    public boolean use(String name, Integer count) {
        if (article.get(name) >= count) {
            article.put(name, article.get(name) - count);
            return true;
        } else {
            msg = "道具不足";
        }
        return false;
    }

    public boolean buy(String name, Integer count, Integer money) {
        if (article.get("money") >= money) {
            article.put(name, article.get(name) + count);
            article.put("money", article.get("money") - money);
            return true;
        }
        return false;
    }

    public boolean buy(Goods goods) {
        return buy(goods.name, goods.value, goods.money);
    }

    public Boolean atk(Monster monster) {
        int hp = monster.hp;
        if (article.get("atk") <= monster.def) {
            return false;
        }
        if (article.get("def") > monster.atk) {
            return true;
        }
        for (; ; ) {
            hp -= article.get("atk") - monster.def;
            if (hp <= 0) {
                return true;
            }
            article.put("hp", article.get("hp") + article.get("def") - monster.atk);
            if (article.get("hp") <= 0) {
                return false;
            }
        }
    }

    public Boolean checkatk(Monster monster) {
        Integer ahp = article.get("hp");
        Integer bhp = monster.hp;
        for (; ; ) {
            bhp -= article.get("atk") - monster.def;
            if (bhp <= 0) {
                return true;
            }
            ahp -= monster.atk - article.get("def");
            if (ahp <= 0) {
                return false;
            }
        }
    }

    public boolean move(int x, int y) {
        int rx = this.x + x;
        int ry = this.y + y;
        Boolean result = false;
        boolean level = false;
        if (rx >= 0 && rx < 11 && ry >= 0 && ry < 11) {
            // 事件处理
            Integer even = maps[rx][ry];
            switch (even) {
                // 道具
                case MotaMap.R:
                case MotaMap.B:
                case MotaMap.Y:
                case MotaMap.U:
                case MotaMap.V:
                case MotaMap.W:
                case MotaMap.J:
                case MotaMap.K:
                case MotaMap.A:
                case MotaMap.C:
                    Article article = MonstrtMap.articleMap.get(even);
                    result = this.add(article.name, article.value);
                    break;
                //捡道具
                case MotaMap.k:
                    fly = true;
                    result = true;
                    break;
                case MotaMap.p:
                    gold = true;
                    doubleGold = 2;
                    result = true;
                    break;
                //boss事件
                case MotaMap.r:
                    if (this.bossEvent < 3) {
                        BossEvent.floor10(MotaMap.r, this);
                    } else {
                        Monster monster = MonstrtMap.monsterMap.get(even);
                        Boolean checkatk = this.checkatk(monster);
                        if (checkatk) {
                            result = this.atk(monster);
                            if (result) {
                                this.add("money", monster.money);
                            }
                        }
                    }
                    change = true;
                    break;
                // 打怪
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
                case MotaMap.q:
                case MotaMap.s:
                case MotaMap.t:
                case MotaMap.u:
                case MotaMap.v:
                case MotaMap.w:
                case MotaMap.x:
                case MotaMap.y:
                case MotaMap.z:
                    Monster monster = MonstrtMap.monsterMap.get(even);
                    Boolean checkatk = this.checkatk(monster);
                    if (checkatk) {
                        result = this.atk(monster);
                        if (result) {
                            if (even == MotaMap.q) {
                                GuarderEven.lowGuarder(this);
                            }
                            if (even == MotaMap.j) {
                                GuarderEven.middleGuarder(this);
                            }
                            if (this.article.get("level") == 10) {
                                GuarderEven.foolr10Guarder(this);
                            }
                            this.add("money", monster.money);
                            this.maps[rx][ry] = MotaMap.L;
                            result = false;
                            change = true;
                        }
                    } else {
                        msg = "打不过";
                    }
                    break;
                //老头对话
                case MotaMap.n:
                    DialogueEvent.npcDialogue(even, this);
                    this.maps[rx][ry] = MotaMap.L;
                    change = true;
                    break;
                //奸商对话
                case MotaMap.m:
                    DialogueEvent.npcDialogue(even, this);
                    if (change) {
                        this.maps[rx][ry] = MotaMap.L;
                    }
                    break;
                //小偷对话
                case MotaMap.l:
                    DialogueEvent.thiefDialogue(this);
                    this.maps[rx][ry] = MotaMap.L;
                    change = true;
                    break;
                case MotaMap.Q:
                    break;
                //路
                case MotaMap.L:
                    result = true;
                    break;
                case MotaMap.O:
                    maps[rx][ry] = MotaMap.L;
                    change = true;
                    break;
                case MotaMap.X:
                    if (this.article.get("level") == 3) {
                        bossEvent = 0;
                        change = BossEvent.floor3(this);
                    }
                    if (this.article.get("level") == 10) {
                        this.maps[rx][ry] = MotaMap.l;
                        change = true;
                    }
                    break;
                //开门
                case MotaMap.D:
                    change = this.use("yellowKey", 1);
                    maps[rx][ry] = MotaMap.L;
                    break;
                case MotaMap.E:
                    change = this.use("blueKey", 1);
                    maps[rx][ry] = MotaMap.L;
                    break;
                case MotaMap.F:
                    change = this.use("redKey", 1);
                    maps[rx][ry] = MotaMap.L;
                    break;
                //进商店
                case MotaMap.M:
                    Goods goods = SpEvent.buy4();
                    if (goods != null) {
                        boolean buy = buy(goods);
                        if (buy) {
                            SpEvent.money += SpEvent.space;
                            SpEvent.space += 20;
                        } else {
                            msg = "钱不够！";
                        }
                    }
                    break;
                //上楼
                case MotaMap.T:
                    this.article.put("level", this.article.get("level") + 1);
                    // 位置
                    maps = MotaMap.motemap.get(this.article.get("level"));
                    boolean flagt = false;
                    for (int i = 0; i < maps.length; i++) {
                        if (flagt) {
                            break;
                        }
                        for (int j = 0; j < maps[i].length; j++) {
                            if (maps[i][j] == MotaMap.H) {
                                this.x = i;
                                this.y = j;
                                flagt = true;
                                break;
                            }
                        }
                    }
                    level = true;
                    result = true;
                    break;
                //下楼
                case MotaMap.S:
                    this.article.put("level", this.article.get("level") - 1);
                    // 位置
                    maps = MotaMap.motemap.get(this.article.get("level"));
                    boolean flags = false;
                    for (int i = 0; i < maps.length; i++) {
                        if (flags) {
                            break;
                        }
                        for (int j = 0; j < maps[i].length; j++) {
                            if (maps[i][j] == MotaMap.H) {
                                this.x = i;
                                this.y = j;
                                flags = true;
                                break;
                            }
                        }
                    }
                    level = true;
                    result = true;
                    break;
                default:
                    break;
            }
            if (result && !level) {
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

    // private Integer exp;
    // private Integer level;

    public void inStore() {
        int money = 20;
        String[] options = {"增加100点生命值", "增加2点攻击力", "增加4点防御力", "离开"};
        int choice = JOptionPane.showOptionDialog(null, "花" + money + "金币你可以：",
                "商店", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            buy("hp", 100, money);
        }
        if (choice == 1) {
            buy("atk", 2, money);
        }
        if (choice == 2) {
            buy("def", 4, money);
        }
        if (choice == 3) {

        }
    }

}




