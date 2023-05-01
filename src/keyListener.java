public class keyListener {
    private object controlledObj;
    public keyListener(object cont){
        this.controlledObj = cont;
    }

    public void keyPress(String v){
        switch (v){
            case "Up" -> controlledObj.move_up();
            case "Down" -> controlledObj.move_down();
            case "Left" -> controlledObj.move_left();
            case "Right" -> controlledObj.move_right();
        }
    }
}
