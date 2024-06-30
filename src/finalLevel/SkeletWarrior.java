package finalLevel;

import java.util.Scanner;

public class SkeletWarrior extends Enemy {
    private final String ENEMY_NAME = "Skeleton Warrior";
    private final double MIN_DAMAGE = 1.3;
    private final double MAX_DAMAGE = 3.2;

    {
        super.enemyName = ENEMY_NAME;
    }

    public SkeletWarrior(double health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) throws SomebodyDeadException {
        basicAttack(hero);
    }

    @Override
    public void takeDamage(double damage) {
        if (blockDamage()) {
            super.takeDamage(damage / 2);
            System.out.println("Enemy blocked damage and got " + damage / 2);
        } else {
            super.takeDamage(damage);
        }

    }

    //Has 20% chance to block 50$ damage
    private boolean blockDamage() {
        int randomNumber = (int) (Math.random() * 11) + 1;
        return randomNumber == 1 || randomNumber == 2;
    }

    private void basicAttack(Hero hero) throws SomebodyDeadException {
        double damage = calculateDamage(MIN_DAMAGE, MAX_DAMAGE);
        hero.takeDamage(damage);
        System.out.println("Skelet Warrior attacks Hero and deals " + damage + " damage");
        if (!hero.isAlive()) throw new SomebodyDeadException("Hero was dead");
    }

}
