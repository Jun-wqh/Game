package team.tetris.block;

public class Square extends Block {

    public Square() {
        blocks = new Integer[4][1];
        final Integer[][] block1 = new Integer[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
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
