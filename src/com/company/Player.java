package com.company;

import java.util.Random;

public class Player {
    private String Name;
    private int Actions;
    private int Health;
    private int Attack;
    private int Defense;

    public Player(String name, int Health, int attack, int defense) {
        this.Name = name;
        this.Health = Health;
        this.Attack = attack;
        this.Defense = defense;
    }
    public int Actions(int Actions) {
        this.Actions = Actions;
        switch (this.Actions) {
            case 1:
                int attack = getAttack();
                System.out.println(this.Name + " атакует на " + attack + " единицы урона");
                return attack;
            case 2:
                System.out.println(this.Name + " получает " + getDefense() + " единиц брони");
                return getDefense();
            default:
                break;
        }
        return 0;
    }

    public int getActions() {
        return Actions;
    }

    public int getHealth() {
        return Health;
    }

    public int getAttack() {
        Random r = new Random();
        return r.nextInt(this.Attack);
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getDefense() {
        return Defense;
    }
}
