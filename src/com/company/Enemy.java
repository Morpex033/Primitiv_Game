package com.company;

import java.util.Random;

public class Enemy {
    private String Name;
    private int Health;
    private int Attack;
    private int Defense;
    private int Actions;

    public Enemy(String name,int Health, int attack, int defense) {
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
                System.out.println("Враг атакует на " + attack + " единицы урона");
                return attack;
            case 2:
                System.out.println("Враг получает " + getDefense() + " единиц брони");
                return getDefense();
            default:
                break;
        }
        return 0;
    }

    public int getActions() {
        return Actions;
    }

    public int getHealth(){
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
