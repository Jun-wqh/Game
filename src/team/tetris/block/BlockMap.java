package team.tetris.block;

import java.util.HashMap;
import java.util.Map;

public class BlockMap {

    Map<String, Integer> blockMap = new HashMap<>();

    static {
        Integer[][] block1 = new Integer[][]{
                {1},
                {1},
                {1},
                {1}
        };
        Integer[][] block2 = new Integer[][]{
                {1, 1, 1, 1}
        };


    }
}
