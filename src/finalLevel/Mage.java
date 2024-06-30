package finalLevel;

import java.util.Scanner;

public class Mage extends Hero {
    private final double MIN_DAMAGE = 4.2;
    private final double MAX_DAMAGE = 6.5;

    private int skillCooldownIterator;
    private int debuffTimes;

    {
        debuffTimes = 0;
        skillCooldownIterator = 0;
    }

    public Mage(String name, double health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) throws SomebodyDeadException {
        if (debuffTimes > 0) {
            enemy.takeDamage(3.0);
            System.out.println("Enemy get  " + 3.0 + " damage from debuff");
            debuffTimes -= 1;
            if (!enemy.isAlive()) throw new SomebodyDeadException("Enemy was dead");
        }
        if (skillCooldownIterator == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do u want to use FireBall skill? (yes / no)");

            boolean exit = false;
            while (true) {
                String answer = scanner.nextLine();
                switch (answer) {
                    case "yes" -> {
                        fireBall(enemy);
                        exit = true;
                    }
                    case "no" -> {
                        basicAttack(enemy);
                        exit = true;
                    }
                    default -> System.out.println("Please enter correct answer");
                }
                if (exit) break;
            }
        } else {
            basicAttack(enemy);
        }

    }

    private void fireBall(Enemy enemy) throws SomebodyDeadException {
        skillCooldownIterator = 2;
        double baseDamage = calculateDamage(MIN_DAMAGE, MAX_DAMAGE);
        double skillDamage = baseDamage + baseDamage * 0.1;
        enemy.takeDamage(skillDamage);
        System.out.println("Mage " + super.getName() + " attacks enemy by FIREBALL skill and deals " + skillDamage + " damage");
        debuffTimes = 2;
        if (!enemy.isAlive()) throw new SomebodyDeadException("Enemy was dead");
    }

    public void basicAttack(Enemy enemy) throws SomebodyDeadException {
        double damage = calculateDamage(MIN_DAMAGE, MAX_DAMAGE);
        enemy.takeDamage(damage);
        System.out.println("Mage " + super.getName() + " attacks enemy and deals " + damage + " damage");
        if (skillCooldownIterator > 0) {
            skillCooldownIterator -= 1;
        }
        if (!enemy.isAlive()) throw new SomebodyDeadException("Enemy was dead");
    }

}
