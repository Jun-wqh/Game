package team.tetris.block;

import java.util.HashMap;
import java.util.Map;

public abstract class Block {
    public Integer[][] blocks;
    public Integer width;
    public Integer height;
    public Integer status;
    public final Map<Integer, Integer[][]> blockMap = new HashMap<>();
    public final Map<Integer, Integer[]> blockStatusMap = new HashMap<>();

    public void turn() {
        status = (status + 1) % blockMap.size();
        this.blocks = blockMap.get(status);
        this.height = blockStatusMap.get(status)[0];
        this.width = blockStatusMap.get(status)[1];
    }

    public Block() {
    }
}
