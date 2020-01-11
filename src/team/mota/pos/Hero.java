package team.mota.pos;

import team.mota.event.*;
import team.mota.panel.MotaMap;

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
    public Boolean magma = false;// 熔岩护符
    public Integer doubleGold = 1;
    public boolean change = false;
    public Integer bossEvent = 1;
    public Integer buyFrequency = 1;

    public Hero(Integer map) {
        maps = MotaMap.motemap.get(map);
        boolean flagt = false;
        for (int i = 0; i < maps.length; i++) {
            if (flagt) {
                break;
            }
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == MotaMap.hr) {
                    this.x = i;
                    this.y = j;
                    flagt = true;
                    break;
                }
            }
        }

    /*    article.put("level", map);
        article.put("atk", 120);
        article.put("def", 120);
        article.put("money", 100);
        article.put("hp", 1000);
        article.put("redKey", 10);
        article.put("blueKey", 10);
        article.put("yellowKey", 10);*/

        //初始属性
        article.put("level", map);
        article.put("atk", 100);
        article.put("def", 100);
        article.put("money", 0);
        article.put("hp", 1000);
        article.put("redKey", 0);
        article.put("blueKey", 0);
        article.put("yellowKey", 1);
    }

    public boolean add(String property, Integer count, int times) {
        if ("money".equals(property)) {
            count = doubleGold * count;
        }
        article.put(property, article.get(property) + count * times);
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
            msg = "购买采购，增加" + count + name;
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
                case MotaMap.pA:
                case MotaMap.pB:
                case MotaMap.pC:
                case MotaMap.pD:
                case MotaMap.pE:
                case MotaMap.pF:
                case MotaMap.pG:
                case MotaMap.pH:
                    Article articleA = MonstrtMap.articleMap.get(even);
                    int times = 1;
                    if ("hp".equals(articleA.property) || even == MotaMap.pG || even == MotaMap.pH) {
                        times = this.article.get("level") / 10 + 1;
                    }
                    result = this.add(articleA.property, articleA.value, times);
                    break;
                //装备
                case MotaMap.pI:
                case MotaMap.pJ:
                case MotaMap.pN:
                case MotaMap.pO:
                case MotaMap.pQ:
                case MotaMap.pR:
                    Article articleB = MonstrtMap.articleMap.get(even);
                    result = this.add(articleB.property, articleB.value, 1);
                    msg = "获得" + articleB.name + ",增加" + articleB.value + articleB.property;
                    break;
                //捡道具
                case MotaMap.pK:
                    fly = true;
                    result = true;
                    msg = "获得飞行器";
                    break;
                case MotaMap.pL:
                    note = true;
                    result = true;
                    msg = "获得笔记本";
                    break;
                case MotaMap.pM:
                    gold = true;
                    doubleGold = 2;
                    msg = "获得幸运金币";
                    result = true;
                    break;
                //boss事件
                case MotaMap.mR:
                    if (this.bossEvent < 3) {
                        BossEvent.floor10(MotaMap.mR, this);
                    } else {
                        Monster monster = MonstrtMap.monsterMap.get(even);
                        Boolean checkatk = this.checkatk(monster);
                        if (checkatk) {
                            result = this.atk(monster);
                            if (result) {
                                this.add("money", monster.money, 1);
                            }
                        }
                    }
                    change = true;
                    break;
                // 打怪
                case MotaMap.mA:
                case MotaMap.mB:
                case MotaMap.mC:
                case MotaMap.mD:
                case MotaMap.mE:
                case MotaMap.mF:
                case MotaMap.mG:
                case MotaMap.mH:
                case MotaMap.mI:
                case MotaMap.mJ:
                case MotaMap.mQ:
                case MotaMap.mS:
                case MotaMap.mT:
                case MotaMap.mU:
                case MotaMap.mV:
                case MotaMap.mW:
                case MotaMap.mX:
                case MotaMap.mY:
                case MotaMap.mZ:
                    Monster monster = MonstrtMap.monsterMap.get(even);
                    Boolean checkatk = this.checkatk(monster);
                    if (checkatk) {
                        result = this.atk(monster);
                        if (result) {
                            if (even == MotaMap.mQ) {
                                GuarderEven.guard(this, even, MotaMap.dF);
                            }
                            if (even == MotaMap.mJ) {
                                GuarderEven.guard(this, even, MotaMap.dE);
                            }
                            if (even == MotaMap.mS) {
                                GuarderEven.guard(this, even, MotaMap.dF);
                            }
                            if (this.article.get("level") == 10) {
                                GuarderEven.foolr10Guard(this);
                            }
                            if (this.article.get("level") == 11 && even == MotaMap.mS) {
                                GuarderEven.foolr11Guard(this);
                            }
                            this.add("money", monster.money, 1);
                            this.maps[rx][ry] = MotaMap.rA;
                            result = false;
                            change = true;
                        }
                    } else {
                        msg = "打不过";
                    }
                    break;
                //老头对话
                case MotaMap.nC:
                    DialogueEvent.npcDialogue(even, this);
                    this.maps[rx][ry] = MotaMap.rA;
                    change = true;
                    break;
                //奸商对话
                case MotaMap.nB:
                    DialogueEvent.npcDialogue(even, this);
                    if (change) {
                        this.maps[rx][ry] = MotaMap.rA;
                    }
                    break;
                //小偷对话
                case MotaMap.nA:
                    DialogueEvent.thiefDialogue(this);
                    this.maps[rx][ry] = MotaMap.rA;
                    change = true;
                    break;
                case MotaMap.wA:
                    break;
                //路
                case MotaMap.rA:
                    result = true;
                    break;
                case MotaMap.wB:
                    maps[rx][ry] = MotaMap.rA;
                    change = true;
                    break;
                case MotaMap.rB:
                    if (this.article.get("level") == 3) {
                        bossEvent = 0;
                        change = BossEvent.floor3(this);
                    }
                    if (this.article.get("level") == 10) {
                        this.maps[rx][ry] = MotaMap.nA;
                        change = true;
                    }
                    break;
                //开门
                case MotaMap.dA:
                    change = this.use("yellowKey", 1);
                    if (change) {
                        maps[rx][ry] = MotaMap.rA;
                    }
                    break;
                case MotaMap.dB:
                    change = this.use("blueKey", 1);
                    if (change) {
                        maps[rx][ry] = MotaMap.rA;
                    }
                    break;
                case MotaMap.dC:
                    change = this.use("redKey", 1);
                    if (change) {
                        maps[rx][ry] = MotaMap.rA;
                    }
                    break;
                //进商店
                case MotaMap.sB:
                    Goods goods = SpEvent.buy4(this.article.get("level"), buyFrequency);
                    if (goods != null) {
                        boolean buy = buy(goods);
                        if (buy) {
                            SpEvent.money += SpEvent.space;
                            SpEvent.space += 20;
                            buyFrequency += 1;
                        } else {
                            msg = "钱不够！";
                        }
                    }
                    break;
                //上楼
                case MotaMap.aT:
                    this.article.put("level", this.article.get("level") + 1);
                    // 位置
                    maps = MotaMap.motemap.get(this.article.get("level"));
                    FloorEvent.change(this, MotaMap.aS);
                    level = true;
                    result = true;
                    break;
                //下楼
                case MotaMap.aS:
                    this.article.put("level", this.article.get("level") - 1);
                    // 位置
                    maps = MotaMap.motemap.get(this.article.get("level"));
                    FloorEvent.change(this, MotaMap.aT);
                    level = true;
                    result = true;
                    break;
                default:
                    break;
            }
            if (result && !level) {
                maps[this.x][this.y] = MotaMap.rA;
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

}




