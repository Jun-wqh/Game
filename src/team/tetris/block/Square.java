package team.tetris.block;

import java.util.HashMap;
import java.util.Map;

public class Square extends Block {

    private final Map<Integer, Integer[][]> blockMap = new HashMap<>();
    private final Map<Integer, Integer[]> blockStatusMap = new HashMap<>();

    @Override
    public void turn() {

    }

    public Square() {
        blocks = new Integer[4][1];
        final Integer[][] block1 = new Integer[][]{
                {1, 1},
                {1, 1}
        };
        blockMap.put(0, block1);
        blockStatusMap.put(0, new Integer[]{2, 2});
        //设置状态初始化
        status = 0;
        this.blocks = blockMap.get(status);
        this.width = blockStatusMap.get(status)[0];
        this.height = blockStatusMap.get(status)[1];
    }
}
