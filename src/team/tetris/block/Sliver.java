package team.tetris.block;


public class Sliver extends Block {

    public Sliver() {
        blocks = new Integer[4][1];
        final Integer[][] block1 = new Integer[][]{
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        blockMap.put(0, block1);
        blockStatusMap.put(0, new Integer[]{4, 1});
        final Integer[][] block2 = new Integer[][]{
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        blockMap.put(1, block2);
        blockStatusMap.put(1, new Integer[]{1, 4});
        // 设置状态初始化
        status = 1;
        turn();
    }
}
