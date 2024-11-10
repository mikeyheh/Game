package Levels;

import Main.Game;
import utils.loadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class levelManager {
    private Game game;
    private BufferedImage[] level;
    private level levelOne;

    public levelManager(Game game){
        this.game = game;
        importOutsideSprite();
        levelOne = new level(loadSave.getLevelData());
    }

    private void importOutsideSprite() {
        BufferedImage img = loadSave.getSpriteAtlas(loadSave.levelAtlas);
        level = new BufferedImage[48];
        for(int j = 0; j < 4; j++){
            for (int i = 0; i < 12; i++){
                int index = j*12 + i;
                level[index] = img.getSubimage(i*32, j*32, 32, 32);
            }
        }
    }

    public void draw(Graphics g){
        for(int j = 0; j < Game.tileHeight; j++){
            for(int i = 0; i < Game.tileWidth; i++){
                int index = levelOne.getSpriteIndex(i,j);
                g.drawImage(level[index],Game.tileSize*i,Game.tileSize*j, Game.tileSize, Game.tileSize,null);
            }
        }

    }
    public void update(){

    }

    public level getCurrentLevel(){
        return levelOne;
    }
}
