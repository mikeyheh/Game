package Inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utils.constant.Directions.*;

public class KeyboardInputs implements KeyListener {

    private GamePanel panel;

    public KeyboardInputs(GamePanel panel){
        this.panel= panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                panel.getGame().getPlayer().setJump(true);
                break;
            case KeyEvent.VK_A:
                panel.getGame().getPlayer().setLeft(true);
                break;
//            case KeyEvent.VK_S:
//                panel.getGame().getPlayer().setDown(true);
//                break;
            case KeyEvent.VK_D:
                panel.getGame().getPlayer().setRight(true);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                panel.getGame().getPlayer().setJump(false);
                break;
            case KeyEvent.VK_A:
                panel.getGame().getPlayer().setLeft(false);
                break;
//            case KeyEvent.VK_S:
//                panel.getGame().getPlayer().setDown(false);
//                break;
            case KeyEvent.VK_D:
                panel.getGame().getPlayer().setRight(false);
                break;

        }
    }
}
