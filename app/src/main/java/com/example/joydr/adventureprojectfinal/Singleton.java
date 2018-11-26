package com.example.joydr.adventureprojectfinal;

public class Singleton {

        // static variable single_instance of type Singleton
        private static Singleton single_instance = null;

        //Users accounts


        //current User account
        private String accountName = "username", password = "password", userLevel ="1", userEXP = "0", userGold = "100";

        // Current User's account chacarter info

        private String charName = null, charClass = null, charBaseHP = "100", charCurrentHP = "100",
                charSTR = "0", charDEX = "0",
                charLevel = "1", charOverallEXP = "0", charCurrentEXP = "0", charEXPToNextLevel = "100", STRPoint ="0", INTELLPoint ="0", DEXPoint ="0" ;
    private String charAttack ="0", charHealth ="0", charINTELL = "0", charMagic = "0", charSpeed= "0", charDodge = "0", charCurrentMagic = "0", charBaseMagic = "0";

    // char items
            private String charWeaponName = null, charWeaponAttack = null, charWeaponSpeed = null;
            private String hpCount = "0", mpCount = "0";
            Attack charAttack1 = new Attack ("stab", 25, 40);
            Attack charAttack2 = new Attack ("slice", 10, 90);
        // town
        private String dayCount = null;

        //Shop

        private String weapon1Name ="sword", weapon2Name ="axe", weapon3Name = "spear";
        private String weapon1Attack =" 10", weapon2Attack =" 20", weapon3Attack =" 5";
        private  String weapon1Speed = " 50", weapon2Speed = "80", weapon3Speed = " 20";
        private String weapon1Cost = "100", weapon2Cost = "100", weapon3Cost = "100";

        //Quest rewards
        private  String questTitle = null;
        private int expReward = -1, goldReward = -1;

        // Does Char go up level?

        private int expM = 2, expToNextLevel = 100;

        //Forest 1 bear 1 combat
        private String enemyName = "Bear";
        private double enemyHP = 50, enemyMP = 0;
        Attack bear1Attack1 = new Attack("Swipe", 10, 50);
        Attack bear1Attack2 = new Attack("Bite", 30, 90);
        private int forest1Bear1GoldReward = 100, forest1Bear1EXPReward = 100, bearLevel = 1;
        Bear bear1 = new Bear();


        // private constructor restricted to this class itself
        private Singleton() {
        }

        // static method to create instance of Singleton class
        public static Singleton getInstance()
        {
            if (single_instance == null)
                single_instance = new Singleton();

            return single_instance;
        }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserEXP() {
        return userEXP;
    }

    public void setUserEXP(String userEXP) {
        this.userEXP = userEXP;
    }

    public String getUserGold() {
        return userGold;
    }

    public void setUserGold(String userGold) {
        this.userGold = userGold;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getCharBaseHP() {
        return charBaseHP;
    }

    public void setCharBaseHP(String charBaseHP) {
        this.charBaseHP = charBaseHP;
    }

    public String getCharCurrentHP() {
        return charCurrentHP;
    }

    public void setCharCurrentHP(String charCurrentHP) {
        this.charCurrentHP = charCurrentHP;
    }

    public String getCharSTR() {
        return charSTR;
    }

    public void setCharSTR(String charSTR) {
        this.charSTR = charSTR;
    }

    public String getCharINTELL() {
        return charINTELL;
    }

    public void setCharINTELL(String charINTELL) {
        this.charINTELL = charINTELL;
    }

    public String getCharDEX() {
        return charDEX;
    }

    public void setCharDEX(String charDEX) {
        this.charDEX = charDEX;
    }

    public String getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(String charLevel) {
        this.charLevel = charLevel;
    }

    public String getCharOverallEXP() {
        return charOverallEXP;
    }

    public void setCharOverallEXP(String charOverallEXP) {
        this.charOverallEXP = charOverallEXP;
    }

    public String getCharCurrentEXP() {
        return charCurrentEXP;
    }

    public void setCharCurrentEXP(String charCurrentEXP) {
        this.charCurrentEXP = charCurrentEXP;
    }

    public String getCharEXPToNextLevel() {
        return charEXPToNextLevel;
    }

    public void setCharEXPToNextLevel(String charEXPToNextLevel) {
        this.charEXPToNextLevel = charEXPToNextLevel;
    }

    public String getSTRPoint() {
        return STRPoint;
    }

    public void setSTRPoint(String STRPoint) {
        this.STRPoint = STRPoint;
    }

    public String getINTELLPoint() {
        return INTELLPoint;
    }

    public void setINTELLPoint(String INTELLPoint) {
        this.INTELLPoint = INTELLPoint;
    }

    public String getDEXPoint() {
        return DEXPoint;
    }

    public void setDEXPoint(String DEXPoint) {
        this.DEXPoint = DEXPoint;
    }

    public String getCharAttack() {
        return charAttack;
    }

    public void setCharAttack(String charAttack) {
        this.charAttack = charAttack;
    }

    public String getCharHealth() {
        return charHealth;
    }

    public void setCharHealth(String charHealth) {
        this.charHealth = charHealth;
    }

    public String getCharMagic() {
        return charMagic;
    }

    public void setCharMagic(String charMagic) {
        this.charMagic = charMagic;
    }

    public String getCharSpeed() {
        return charSpeed;
    }

    public void setCharSpeed(String charSpeed) {
        this.charSpeed = charSpeed;
    }

    public String getCharDodge() {
        return charDodge;
    }

    public void setCharDodge(String charDodge) {
        this.charDodge = charDodge;
    }

    public String getCharCurrentMagic() {
        return charCurrentMagic;
    }

    public void setCharCurrentMagic(String charCurrentMagic) {
        this.charCurrentMagic = charCurrentMagic;
    }

    public String getCharBaseMagic() {
        return charBaseMagic;
    }

    public void setCharBaseMagic(String charBaseMagic) {
        this.charBaseMagic = charBaseMagic;
    }

    public int getExpReward() {
        return expReward;
    }

    public void setExpReward(int expReward) {
        this.expReward = expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }

    public String getQuestTitle() {
        return questTitle;
    }

    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle;
    }

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }

    public String getCharWeaponName() {
        return charWeaponName;
    }

    public void setCharWeaponName(String charWeaponName) {
        this.charWeaponName = charWeaponName;
    }

    public String getCharWeaponAttack() {
        return charWeaponAttack;
    }

    public void setCharWeaponAttack(String charWeaponAttack) {
        this.charWeaponAttack = charWeaponAttack;
    }

    public String getCharWeaponSpeed() {
        return charWeaponSpeed;
    }

    public void setCharWeaponSpeed(String charWeaponSpeed) {
        this.charWeaponSpeed = charWeaponSpeed;
    }

    public String getWeapon1Name() {
        return weapon1Name;
    }

    public void setWeapon1Name(String weapon1Name) {
        this.weapon1Name = weapon1Name;
    }

    public String getWeapon2Name() {
        return weapon2Name;
    }

    public void setWeapon2Name(String weapon2Name) {
        this.weapon2Name = weapon2Name;
    }

    public String getWeapon3Name() {
        return weapon3Name;
    }

    public void setWeapon3Name(String weapon3Name) {
        this.weapon3Name = weapon3Name;
    }

    public String getWeapon1Attack() {
        return weapon1Attack;
    }

    public void setWeapon1Attack(String weapon1Attack) {
        this.weapon1Attack = weapon1Attack;
    }

    public String getWeapon2Attack() {
        return weapon2Attack;
    }

    public void setWeapon2Attack(String weapon2Attack) {
        this.weapon2Attack = weapon2Attack;
    }

    public String getWeapon3Attack() {
        return weapon3Attack;
    }

    public void setWeapon3Attack(String weapon3Attack) {
        this.weapon3Attack = weapon3Attack;
    }

    public String getWeapon1Speed() {
        return weapon1Speed;
    }

    public void setWeapon1Speed(String weapon1Speed) {
        this.weapon1Speed = weapon1Speed;
    }

    public String getWeapon2Speed() {
        return weapon2Speed;
    }

    public void setWeapon2Speed(String weapon2Speed) {
        this.weapon2Speed = weapon2Speed;
    }

    public String getWeapon3Speed() {
        return weapon3Speed;
    }

    public void setWeapon3Speed(String weapon3Speed) {
        this.weapon3Speed = weapon3Speed;
    }

    public String getWeapon1Cost() {
        return weapon1Cost;
    }

    public void setWeapon1Cost(String weapon1Cost) {
        this.weapon1Cost = weapon1Cost;
    }

    public String getWeapon2Cost() {
        return weapon2Cost;
    }

    public void setWeapon2Cost(String weapon2Cost) {
        this.weapon2Cost = weapon2Cost;
    }

    public String getWeapon3Cost() {
        return weapon3Cost;
    }

    public void setWeapon3Cost(String weapon3Cost) {
        this.weapon3Cost = weapon3Cost;
    }

    public String getHpCount() {
        return hpCount;
    }

    public void setHpCount(String hpCount) {
        this.hpCount = hpCount;
    }

    public String getMpCount() {
        return mpCount;
    }

    public void setMpCount(String mpCount) {
        this.mpCount = mpCount;
    }

    public int getExpM() {
        return expM;
    }

    public void setExpM(int expM) {
        this.expM = expM;
    }

    public int getExpToNextLevel() {
        return expToNextLevel;
    }

    public void setExpToNextLevel(int expToNextLevel) {
        this.expToNextLevel = expToNextLevel;
    }

    // bear


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

    public Attack getCharAttack1() {
        return charAttack1;
    }

    public void setCharAttack1(Attack charAttack1) {
        this.charAttack1 = charAttack1;
    }

    public Attack getCharAttack2() {
        return charAttack2;
    }

    public void setCharAttack2(Attack charAttack2) {
        this.charAttack2 = charAttack2;
    }
}
