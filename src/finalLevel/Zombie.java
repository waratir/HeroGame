package finalLevel;

public class Zombie extends Enemy {
    private final String ENEMY_NAME = "Zombie";
    private final double MIN_DAMAGE = 4.3;
    private final double MAX_DAMAGE = 6.5;
    private boolean hasUltimate;
    private final double ZOMBIE_HEALTH;

    {
        super.enemyName = ENEMY_NAME;
        hasUltimate = true;
    }

    public Zombie(double health) {
        super(health);
        ZOMBIE_HEALTH = health;
    }

    @Override
    public void attackHero(Hero hero) throws SomebodyDeadException {
        basicAttack(hero);
    }

    @Override
    public void takeDamage(double damage) {
        super.takeDamage(damage);
        if (!super.isAlive() && hasUltimate) {
            super.setHealth(ZOMBIE_HEALTH);
            System.out.println("Zombie has been reborn \n ...");
        }
    }

    private void basicAttack(Hero hero) throws SomebodyDeadException {
        double damage = calculateDamage(MIN_DAMAGE, MAX_DAMAGE);
        hero.takeDamage(damage);
        System.out.println("Zombie attacks Hero and deals " + damage + " damage");
        if (!hero.isAlive()) throw new SomebodyDeadException("Hero was dead");
    }
}
