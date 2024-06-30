package finalLevel;

public abstract class Hero implements Mortal{
    private String name;
    private double health;

    public Hero(String name, double health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(double damage){
        health -= damage;
    }
    public abstract void attackEnemy(Enemy enemy) throws SomebodyDeadException;

    @Override
    public String toString() {
        return getName();
    }
}
