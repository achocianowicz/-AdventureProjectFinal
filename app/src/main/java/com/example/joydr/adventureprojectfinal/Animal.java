package com.example.joydr.adventureprojectfinal;

public class Animal {

    private String enemyName = "animal";
    private double enemyHP = 50, enemyMP = 0;

    Attack animalAttack1 = new Attack("Swipe", 10, 50);
    Attack animalAttack2 = new Attack("Bite", 30, 90);
    Attack[] attacks = new Attack[]{animalAttack1,animalAttack2};
    private int forest1Bear1GoldReward = 100, forest1Bear1EXPReward = 100, bearLevel = 1;

    public Animal(){}

    public Animal(String enemyName, double enemyHP, double enemyMP, Attack bear1Attack1, Attack bear1Attack2, Attack[] attacks, int forest1Bear1GoldReward, int forest1Bear1EXPReward, int bearLevel) {
        this.enemyName = enemyName;
        this.enemyHP = enemyHP;
        this.enemyMP = enemyMP;
        this.animalAttack1 = bear1Attack1;
        this.animalAttack2 = bear1Attack2;
        this.attacks = attacks;
        this.forest1Bear1GoldReward = forest1Bear1GoldReward;
        this.forest1Bear1EXPReward = forest1Bear1EXPReward;
        this.bearLevel = bearLevel;
    }

}
