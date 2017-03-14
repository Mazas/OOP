package sample;

/**
 * Created by ivana on 3/12/2017.
 */
public enum Direction {
    FORWARD  (-1),
    BACK(1),
    LEFT(-2),
    RIGHT(2);


    private final int direction;

    private Direction(int dir) {
        this.direction = dir;
    }
    public int getDirection(){
        return direction;
    }
    @Override
    public String toString(){
        switch (direction){
            case -1:
                return "FORWARD";
            case 1:
                return "BACK";
            case 2:
                return "RIGHT";
            case -2:
                return "LEFT";
            default:
                return "Not Initialised";
        }
    }
}