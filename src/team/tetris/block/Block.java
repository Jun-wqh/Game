package team.tetris.block;

public abstract class Block {
    public Integer[][] blocks;
    public Integer width;
    public Integer height;
    public Integer status;

    public Block() {
    }


    public abstract void turn();

}
