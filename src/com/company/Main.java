package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player player = new Player("Дениска",100,20 ,10);
        Enemy enemy = new Enemy("Враг",100, 20,10);

        System.out.println("Игра началась!");
        while (enemy.getHealth() > 0 && player.getHealth() > 0){
            int playerDamage;
            int enemyDamage;
            System.out.println("Выберите действие: ");
            System.out.println("1. Атаковать");
            System.out.println("2. Защититься");
            while (true) {
                playerDamage = player.Actions(scanner.nextInt());
                if(player.getActions() != 1 && player.getActions() != 2) {
                    System.out.println("Вы ввели неверное значение, попробуйте еще раз");
                    playerDamage = player.Actions(scanner.nextInt());
                }else {
                    break;
                }
            }
            enemyDamage = enemy.Actions(random.nextInt(2)+1);
            if(player.getActions() == 2 && enemy.getActions() == 2) {
                System.out.println("Вы защитились и враг защитился");
            }else {
                switch (player.getActions()) {
                    case 1:
                        if (enemy.getActions() == 1) {
                            enemy.setHealth(enemy.getHealth() - playerDamage);

                            player.setHealth(player.getHealth() - enemyDamage);

                        } else if (enemy.getActions() == 2) {
                            enemy.setHealth(enemy.getHealth() - (playerDamage < enemy.getDefense() ? 0 : playerDamage - enemy.getDefense()));
                        }
                        break;
                    case 2:
                        if (enemy.getActions() == 1) {
                            player.setHealth(player.getHealth() - (enemyDamage < player.getDefense() ? 0 : enemyDamage - player.getDefense()));
                        }
                }
            }
            System.out.println("Ваше здоровье: " + player.getHealth());
            System.out.println("Здоровье врага: " + enemy.getHealth());
            if (player.getHealth() <= 0 && enemy.getHealth() <= 0) {
                System.out.println("Ничья");
                break;
            }
            if(player.getHealth() <= 0) {
                System.out.println("Вы проиграли");
                break;
            }else if(enemy.getHealth() <= 0) {
                System.out.println("Вы выиграли");
                break;
            }
        }

    }
}