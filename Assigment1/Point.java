import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(Point P) {
        return Math.sqrt( Math.pow(getX()-P.getX(), 2) + Math.pow(getY()-P.getY(), 2));
    }
}
