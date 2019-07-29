package team.mota.event;

/**
 * @version V1.0.0
 * @ClassName: Goods
 * @Description:
 * @author: 厦门智强软件科技
 * @date: 2019/7/29
 * @Copyright:2019 All rights reserved.
 * 注意：本内容仅限于厦门智强软件科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Goods {
    public String name;
    public Integer value;
    public Integer money;

    public Goods(String name, Integer value, Integer money) {
        this.name = name;
        this.value = value;
        this.money = money;
    }
}
