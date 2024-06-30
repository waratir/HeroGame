package finalLevel;

import java.util.Scanner;

public class Archer extends Hero {
    private final double MIN_DAMAGE = 2.0;
    private final double MAX_DAMAGE = 7.5;

    private int skillCooldownIterator;

    {
        skillCooldownIterator = 1;
    }

    public Archer(String name, double health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) throws SomebodyDeadException {
        if (skillCooldownIterator == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do u want to use Critical Strike skill? (yes / no)");

            boolean exit = false;
            while (true) {
                String answer = scanner.nextLine();
                switch (answer) {
                    case "yes" -> {
                        criticalStrikeAttack(enemy);
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


    private void criticalStrikeAttack(Enemy enemy) throws SomebodyDeadException {
        double baseDamage = calculateDamage(MIN_DAMAGE, MAX_DAMAGE);
        double skillDamage = baseDamage * 2;
        enemy.takeDamage(skillDamage);
        System.out.println("Archer " + super.getName() + " has critical strike damage and deals " + skillDamage + " damage");
        skillCooldownIterator = 2;
        if (!enemy.isAlive()) throw new SomebodyDeadException("Enemy was dead");
    }

    public void basicAttack(Enemy enemy) throws SomebodyDeadException {
        double damage = calculateDamage(MIN_DAMAGE, MAX_DAMAGE);
        enemy.takeDamage(damage);
        System.out.println("Archer " + super.getName() + " attacks enemy and deals " + damage + " damage");
        if (skillCooldownIterator > 0) {
            skillCooldownIterator -= 1;
        }
        if (!enemy.isAlive()) throw new SomebodyDeadException("Enemy was dead");
    }
}
