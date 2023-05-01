import ecs100.UI;

import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

public class object {
    private double X;
    private double Y;
    private double size = 50;
    private double index;
    private double midPointX;
    private double midPointY;
    private double step = 10;
    public object(double X, double Y){
        this.X = X;
        this.Y = Y;
        this.midPointX = X+(size/2);
        this.midPointY = Y+(size/2);
    }

    public void setIndex(double index){
        this.index = index;
    }

    public void runner(){
        collision_check();
        UI.drawOval(X, Y, size, size);
    }

    private void collision_check(){
        for (object obj: Main.objects){
            double distance = distance_checker(this.X, this.Y, obj.getX(), obj.getY());
            if (Main.objects.indexOf(obj) != index){
                if (distance <= size){
                    UI.setColor(Color.red);
                }
                else {
                    UI.setColor(Color.black);
                }
            }
        }
    }

    private double distance_checker(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
    }

    private void collision_application(object colObj, double distance){

    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void move_up(){
        UI.eraseOval(X, Y, size, size);
        this.Y -= step;
    }

    public void move_down(){
        UI.eraseOval(X, Y, size, size);
        this.Y += step;
    }

    public void move_left(){
        UI.eraseOval(X, Y, size, size);
        this.X -= step;
    }

    public void move_right(){
        UI.eraseOval(X, Y, size, size);
        this.X += step;
    }
}
