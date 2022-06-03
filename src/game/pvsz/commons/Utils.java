package game.pvsz.commons;

public class Utils {
    public static int getXIndex(int x) {
        if(x >= 50 && x <= 147) return  0;
        else if(x >= 148 && x <= 239) return  1;
        else if(x >= 240 && x <= 344) return  2;
        else if(x >= 345 && x <= 444) return  3;
        else if(x >= 445 && x <= 544) return  4;
        else if(x >= 545 && x <= 651) return  5;
        else if(x >= 652 && x <= 745) return  6;
        else if(x >= 746 && x <= 842) return  7;
        return 8;
    }

    public static int getYIndex(int y) {
        if(y >= 110 && y <= 218) return  0;
        else if(y >= 219 && y <= 340) return  1;
        else if(y >= 341 && y <= 457) return  2;
        else if(y >= 458 && y <= 576) return  3;
        return 4;
    }

    public static int getXFromIdx(int idx) {
        if(idx == 0) return 50;
        else if(idx == 1) return 148;
        else if(idx == 2) return 240;
        else if(idx == 3) return 345;
        else if(idx == 4) return 445;
        else if(idx == 5) return 545;
        else if(idx == 6) return 652;
        else if(idx == 7) return 746;
        return 843;
    }

    public  static int getYFromIdx(int idx) {
        if(idx == 0) return  110;
        else if(idx == 1) return 219;
        else if(idx == 2) return 341;
        else if(idx == 3) return 458;
        return 577;
    }
}
