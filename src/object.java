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
    public boolean controlled = false;
    private double factor = 0.1;
    private ArrayList<object> objects;

    public object(double X, double Y, boolean controlled, ArrayList<object> objects){
        this.X = X;
        this.Y = Y;
        this.midPointX = X+(size/2);
        this.midPointY = Y+(size/2);
        this.controlled = controlled;
        this.objects = objects;
    }

    public void setIndex(double index){
        this.index = index;
    }

    public void runner(){
        collision_check();
        UI.drawOval(X, Y, size, size);
    }

    private void collision_check(){
        for (object obj: objects){
            if (obj != this && this.controlled){
                double distance = distance_checker(this.getX(), this.getY(), obj.getX(), obj.getY());
                if (distance <= size){
                    double unitX = (this.getX() - obj.getX())/distance;
                    double unitY = (this.getY() - obj.getY())/distance;
                    obj.setX(obj.getX()-unitX*(size - distance));
                    obj.setY(obj.getY()-unitY*(size - distance));
                }
            }
        }
    }

    /*private void collision_check(){
        for (object obj: Main.objects){
            if (Main.objects.indexOf(Main.controlledObject) == Main.objects.indexOf(this) && Main.objects.indexOf(this) != Main.objects.indexOf(obj)){
                double distance = distance_checker(this.X, this.Y, obj.getX(), obj.getY());
                if (distance <= size){
                    UI.eraseOval(obj.getX(), obj.getY(), size, size);
                    obj.setX(obj.getX()-distance);
                    obj.setY(obj.getY()-distance);
                }
                else {
                    UI.eraseOval(X, Y, size, size);
                    UI.setColor(Color.black);
                }
            }
        }
    }*/

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
        UI.eraseRect(X, Y, size, size);
        this.Y -= step;
    }

    public void move_down(){
        UI.eraseRect(X, Y, size, size);
        this.Y += step;
    }

    public void move_left(){
        UI.eraseRect(X, Y, size, size);
        this.X -= step;
    }

    public void move_right(){
        UI.eraseRect(X, Y, size, size);
        this.X += step;
    }

    public void setY(double y) {
        UI.eraseOval(this.X, this.Y, size, size);
        Y = y;
        UI.drawOval(this.X, this.Y, size, size);
    }

    public void setX(double x) {
        UI.eraseOval(this.X, this.Y, size, size);
        X = x;
        UI.drawOval(this.X, this.Y, size, size);
    }
}
