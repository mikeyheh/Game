package Main;


import entities.Player;
import Levels.levelManager;

import java.awt.*;

public class Game implements Runnable{
    private Window gameWindow;
    private GamePanel panel;
    private Thread gameThread;
    private final int FpsSet = 60;
    private final int UpsSet = 200;
    private Player player;
    private levelManager levelManager;

    public final static int tileDefaultSize = 32;
    public final static float scale = 2f;
    public final static int tileWidth = 26;
    public final static int tileHeight = 14;
    public final static int tileSize = (int) (tileDefaultSize * scale);
    public final static int gameWidth = tileSize * tileWidth;
    public final static int gameHeight = tileSize * tileHeight;

    public Game(){
        initClasses();

        panel = new GamePanel(this);
        gameWindow = new Window(panel);
        panel.requestFocus();

        gameLoop();
    }

    private void initClasses() {
        levelManager = new levelManager(this);
        player = new Player(200,200,(int) (50*scale), (int) (37*scale));
        player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
    }

    private void gameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        player.update();
        levelManager.update();
    }
    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);
    }

    public void run(){
        double timePerFrame = 1000000000.0 / FpsSet;
        double timePerUpdate = 1000000000.0 / UpsSet;

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        long prevTime = System.nanoTime();
        while(true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime - prevTime) / timePerUpdate;
            deltaF += (currentTime - prevTime) / timePerFrame;
            prevTime = currentTime;

            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            if(deltaF >= 1){
                panel.repaint();
                frames++;
                deltaF--;
            }


            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("Fps: "+ frames + "| UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    public void windowFocusLost(){
        player.resetDir();
    }

    public Player getPlayer() {
        return player;
    }
}
