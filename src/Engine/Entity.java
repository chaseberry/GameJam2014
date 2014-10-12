package Engine;

/**
 * Created by chase on 10/11/14.
 */
public abstract class Entity {

    protected double x;
    protected double y;

    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void update();

    public double getX() {
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
