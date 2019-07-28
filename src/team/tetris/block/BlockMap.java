package team.tetris.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockMap {
    static Random random = new Random();
    static List<Block> blockList = new ArrayList<>();

    static {
        blockList.add(new ZIshape());
        blockList.add(new Zshape());
        blockList.add(new LIshape());
        blockList.add(new Lshape());
        blockList.add(new Tshape());
        blockList.add(new Square());
        blockList.add(new Sliver());
    }

    public static Block getBlock() {
        int i = random.nextInt(7);
        return blockList.get(i);
    }

}
