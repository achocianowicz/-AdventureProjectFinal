package com.example.joydr.adventureprojectfinal;

public class Bear {

    private String enemyName = "Bear";
    private double enemyHP = 50, enemyMP = 0;

    Attack bear1Attack1 = new Attack("Swipe", 10, 50);
    Attack bear1Attack2 = new Attack("Bite", 30, 90);
    Attack[] attacks = new Attack[]{bear1Attack1,bear1Attack2};
    private int forest1Bear1GoldReward = 100, forest1Bear1EXPReward = 100, bearLevel = 1;

    public Bear(){}

    public Bear(String enemyName, double enemyHP, double enemyMP, Attack bear1Attack1, Attack bear1Attack2, Attack[] attacks, int forest1Bear1GoldReward, int forest1Bear1EXPReward, int bearLevel) {
        this.enemyName = enemyName;
        this.enemyHP = enemyHP;
        this.enemyMP = enemyMP;
        this.bear1Attack1 = bear1Attack1;
        this.bear1Attack2 = bear1Attack2;
        this.attacks = attacks;
        this.forest1Bear1GoldReward = forest1Bear1GoldReward;
        this.forest1Bear1EXPReward = forest1Bear1EXPReward;
        this.bearLevel = bearLevel;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public double getEnemyHP() {
        return enemyHP;
    }

    public void setEnemyHP(double enemyHP) {
        this.enemyHP = enemyHP;
    }

    public double getEnemyMP() {
        return enemyMP;
    }

    public void setEnemyMP(double enemyMP) {
        this.enemyMP = enemyMP;
    }

    public Attack getBear1Attack1() {
        return bear1Attack1;
    }

    public void setBear1Attack1(Attack bear1Attack1) {
        this.bear1Attack1 = bear1Attack1;
    }

    public Attack getBear1Attack2() {
        return bear1Attack2;
    }

    public void setBear1Attack2(Attack bear1Attack2) {
        this.bear1Attack2 = bear1Attack2;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    public int getForest1Bear1GoldReward() {
        return forest1Bear1GoldReward;
    }

    public void setForest1Bear1GoldReward(int forest1Bear1GoldReward) {
        this.forest1Bear1GoldReward = forest1Bear1GoldReward;
    }

    public int getForest1Bear1EXPReward() {
        return forest1Bear1EXPReward;
    }

    public void setForest1Bear1EXPReward(int forest1Bear1EXPReward) {
        this.forest1Bear1EXPReward = forest1Bear1EXPReward;
    }

    public int getBearLevel() {
        return bearLevel;
    }

    public void setBearLevel(int bearLevel) {
        this.bearLevel = bearLevel;
    }
}
