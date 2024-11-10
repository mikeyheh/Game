package utils;

import Main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class loadSave {
    public static final String playerAtlas ="final_anims.png";
    public static final String levelAtlas ="outside_sprites.png";
    public static final String mapAtlas ="level_one_data.png";
    public static BufferedImage getSpriteAtlas(String file){
        BufferedImage img = null;
        InputStream is = loadSave.class.getResourceAsStream("/" + file);
        try {
              img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return img;
    }
    public static int[][] getLevelData(){
        int[][] lvl = new int[Game.tileHeight][Game.tileWidth];
        BufferedImage img = getSpriteAtlas(mapAtlas);

        for(int j = 0; j < img.getHeight(); j++){
            for(int i = 0; i <img.getWidth();i++){
                Color color = new Color(img.getRGB(i,j));
                int val = color.getRed();
                if(val >= 48){
                    val = 0;
                }
                lvl[j][i] = val;
            }
        }
        return lvl;
    }
}
