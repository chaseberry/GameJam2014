package Enemy;


import Engine.Entity;

public abstract class Enemey extends Entity {

    private int health;

    public Enemey(double x, double y, int health){
        super(x, y);
        this.health = health;
    }

    public Enemey(double x, double y){
        this(x, y, 5);
    }

    @Override
    public void update() {

    }


}
