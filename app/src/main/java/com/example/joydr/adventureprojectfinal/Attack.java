package com.example.joydr.adventureprojectfinal;

public class Attack {

    private String name = null;
    private double Damage = -1, speed = -1;

    public Attack () {}

    public Attack(String name, double damage, double speed) {
        this.name = name;
        Damage = damage;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return Damage;
    }

    public void setDamage(double damage) {
        Damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
