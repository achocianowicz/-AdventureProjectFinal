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

        // town
        private String dayCount = null;


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

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }
}
