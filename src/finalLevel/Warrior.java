package finalLevel;

import java.util.Scanner;

public class Warrior extends Hero {
    private final double MIN_DAMAGE = 5.5;
    private final double MAX_DAMAGE = 6.6;

    public Warrior(String name, double health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) throws SomebodyDeadException {
        if (chanceToAttackTwice()) {
            basicAttack(enemy);
            basicAttack(enemy);
        } else {
            basicAttack(enemy);
        }
    }


    private boolean chanceToAttackTwice() {
        //Chance 30% to attack twice
        int randomNumber = (int) (Math.random() * 10) + 1;
        return randomNumber == 1 || randomNumber == 2 || randomNumber == 3;
    }

    public void basicAttack(Enemy enemy) throws SomebodyDeadException {
        double damage = calculateDamage(MIN_DAMAGE, MAX_DAMAGE);
        enemy.takeDamage(damage);
        System.out.println("Warrior " + super.getName() + " attacks enemy and deals " + damage + " damage");
        if (!enemy.isAlive()) throw new SomebodyDeadException("Enemy was dead");
    }
}
