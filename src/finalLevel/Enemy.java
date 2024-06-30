package finalLevel;

abstract class Enemy implements Mortal{
    private double health;
    protected String enemyName;

    public Enemy(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void takeDamage(double damage){
        health -= damage;
    }

    public abstract void attackHero(Hero enemy) throws SomebodyDeadException;

    @Override
    public boolean isAlive() {
        return health > 0;
    }


}
