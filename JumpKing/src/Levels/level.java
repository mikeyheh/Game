package Levels;

public class level {
    private int[][] lvl;
    public level(int[][] lvl){
        this.lvl = lvl;
    }

    public int getSpriteIndex(int x, int y){
        return lvl[y][x];
    }

    public int[][] getLevelData(){
        return lvl;
    }
}
