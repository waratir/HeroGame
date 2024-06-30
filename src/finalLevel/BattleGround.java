package finalLevel;

import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) {
        Hero mage = new Mage("Johne", 66);
        Hero archer = new Archer("Killer", 80);
        Hero warrior = new Warrior("Berserk", 65);

        Enemy skeletonWarrior = new SkeletWarrior(200);
        Enemy zombie = new Zombie(48);
        Enemy skeletonWarrior3 = new SkeletWarrior(77);

        Hero choseHero = null;
        Enemy choseEnemy = null;

        System.out.println("Choose your Hero:");
        System.out.println("1 - Mage");
        System.out.println("2 - Archer");
        System.out.println("3 - Warrior");


        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (true) {
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> {
                    choseHero = mage;
                    exit = true;
                }
                case "2" -> {
                    choseHero = archer;
                    exit = true;
                }
                case "3" -> {
                    choseHero = warrior;
                    exit = true;
                }
                default -> System.out.println("Please enter correct answer ( 1, 2 or 3)");
            }
            if (exit) break;
        }

        System.out.println("Choose your Enemy:");
        System.out.println("1 - Skeleton Warrior");
        System.out.println("2 - Zombie");

        exit = false;
        while (true) {
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> {
                    choseEnemy = skeletonWarrior;
                    exit = true;
                }
                case "2" -> {
                    choseEnemy = zombie;
                    exit = true;
                }
                default -> System.out.println("Please enter correct answer ( 1, 2 or 3)");
            }
            if (exit) break;
        }

        try {
            while (true) {
                System.out.println("The " + choseHero + " makes the move");
                choseHero.attackEnemy(choseEnemy);
                System.out.println(choseEnemy.enemyName + " has " + String.format("%.1f", choseEnemy.getHealth()) + " health" + "\n ... \n ... \n");
                System.out.println("The " + choseEnemy.enemyName + " makes the move");
                choseEnemy.attackHero(choseHero);
                System.out.println(choseHero + " has " + String.format("%.1f", choseHero.getHealth()) + " health" + "\n ... \n ... \n");
            }
        } catch (SomebodyDeadException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
