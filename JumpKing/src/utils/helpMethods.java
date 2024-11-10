package utils;

import Main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class helpMethods {
    public static boolean canMove(float x, float y, float width, float height, int[][] lvl){
        if(!isSolid(x,y,lvl)){
            if(!isSolid(x+width, y+height, lvl)){
                if(!isSolid(x+width, y, lvl)){
                    if(!isSolid(x,y+height,lvl)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean isSolid(float x, float y, int[][] lvl){
        if(x < 0 || x >= Game.gameWidth){
            return true;
        }
        if(y < 0 || y >= Game.gameHeight){
            return true;
        }

        float xIndex = x/Game.tileSize;
        float yIndex = y/Game.tileSize;

        int val = lvl[(int)yIndex][(int)xIndex];

        if(val >= 48 || val < 0 || val != 11){
            return true;
        }
        return false;
    }

    public static float getEntityPosToWall(Rectangle2D.Float hitbox, float xSpeed){
        int currTile = (int)(hitbox.x/Game.tileSize);
        if(xSpeed > 0){
            int xTile = currTile * Game.tileSize;
            int xOffset = (int)(Game.tileSize - hitbox.width);
            return xTile + xOffset - 1;
        }else{
            return currTile * Game.tileSize;
        }
    }
    public static float getEntityYpos(Rectangle2D.Float hitbox, float airSpeed){
        int currTile = (int)(hitbox.y/Game.tileSize);
        if(airSpeed > 0 ){
            int yTile = currTile * Game.tileSize;
            int yOffset = (int)(Game.tileSize - hitbox.height);
            return yTile + yOffset - 1;
        }else{
            return currTile * Game.tileSize;
        }
    }
    public static boolean grounded(Rectangle2D.Float hitbox, int[][]lvl){
        if(!isSolid(hitbox.x, hitbox.y+ hitbox.height+1,lvl)){
            if(!isSolid(hitbox.x+ hitbox.width, hitbox.y+ hitbox.height+1,lvl)){
                return false;
            }
        }
        return true;
    }
}
