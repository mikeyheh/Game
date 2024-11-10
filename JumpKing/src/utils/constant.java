package utils;

public class constant {
    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
    public static class playerConstants{
        public static final int running = 0;
        public static final int noWeaponIdle = 1;
        public static final int falling = 2;
        public static final int jumping = 3;
        public static final int runningBack = 4;
        public static final int noWeaponIdleBack = 5;
        public static final int jumpingBack = 6;
        public static final int fallingBack = 7;



        public static int getAnimAmount(int playerAction){
            switch(playerAction){
                case running:
                case runningBack:
                    return 6;
                case noWeaponIdle:
                case jumping:
                case noWeaponIdleBack:
                case jumpingBack:
                    return 4;
                case falling:
                case fallingBack:
                    return 2;
                default:
                    return 1;
            }
        }
    }
}
