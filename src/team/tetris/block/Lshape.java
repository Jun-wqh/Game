package team.tetris.block;

public class Lshape extends Block {

    public Lshape() {
        blocks = new Integer[4][1];
        final Integer[][] block1 = new Integer[][]{
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        blockMap.put(0, block1);
        blockStatusMap.put(0, new Integer[]{3, 2});
        final Integer[][] block2 = new Integer[][]{
                {1, 1, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        blockMap.put(1, block2);
        blockStatusMap.put(1, new Integer[]{2, 3});
        final Integer[][] block3 = new Integer[][]{
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        };
        blockMap.put(2, block3);
        blockStatusMap.put(2, new Integer[]{3, 2});
        final Integer[][] block4 = new Integer[][]{
                {0, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        blockMap.put(3, block4);
        blockStatusMap.put(3, new Integer[]{2, 3});
        // 设置状态初始化
        status = 1;
        turn();
    }
}
