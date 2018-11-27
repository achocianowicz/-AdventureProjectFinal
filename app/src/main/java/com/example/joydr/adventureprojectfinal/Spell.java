package com.example.joydr.adventureprojectfinal;

public class Spell {

    private String name = null,  magicCost = null;
    int cost = -1;
    private double damage = -1, speed = -1;

    public Spell(){}

    public Spell(String name, int cost, String magicCost, double damage, double speed) {
        this.name = name;
        this.cost = cost;
        this.magicCost = magicCost;
        this.damage = damage;
        this.speed = speed;
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

    public String getMagicCost() {
        return magicCost;
    }

    public void setMagicCost(String magicCost) {
        this.magicCost = magicCost;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
