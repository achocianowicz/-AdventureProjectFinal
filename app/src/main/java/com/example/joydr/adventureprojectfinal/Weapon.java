package com.example.joydr.adventureprojectfinal;


import java.lang.reflect.Array;

public class Weapon {
    private String name = null;
    private int cost = -1, level = -1;
    Attack attack1 = new Attack();
    Attack attack2 = new Attack();
    Attack[] attacks =  new Attack[]{attack1,attack2};

    public Weapon(){}

    public Weapon(String name, int cost, int level, Attack attack1, Attack attack2, Attack[] attacks) {
        this.name = name;
        this.cost = cost;
        this.level = level;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Attack getAttack1() {
        return attack1;
    }

    public void setAttack1(Attack attack1) {
        this.attack1 = attack1;
    }

    public Attack getAttack2() {
        return attack2;
    }

    public void setAttack2(Attack attack2) {
        this.attack2 = attack2;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }
}
