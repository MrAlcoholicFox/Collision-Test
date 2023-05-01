import ecs100.UI;

import java.util.ArrayList;

public class object {
    private double X;
    private double Y;
    private double size = 50;
    private double index;
    private double midPointX;
    private double midPointY;
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
        UI.eraseRect(X, Y, size, size);
        collision_check();
        UI.drawRect(X, Y, size, size);
    }

    private void collision_check(){
        for (object obj: Main.objects){
            if (Main.objects.indexOf(obj) != index){
                if ()
            }
        }
    }

    private void collision_application(object colObj){

    }
}
