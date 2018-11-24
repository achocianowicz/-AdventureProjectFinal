package com.example.joydr.adventureprojectfinal;

public class Singleton {

        // static variable single_instance of type Singleton
        private static Singleton single_instance = null;

        //Users accounts


        //current User account
        private String accountName = "username", password = "password", userLevel ="1", userEXP = "0", userGold = "100";

        // Current User's account chacarter info

        private String charName = null, charClass = null, charBaseHP = null, charCurrentHP, charSTR, charINTELL, charDEX,
                charLevel = "1", charEXP = null;

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

    public String getCharEXP() {
        return charEXP;
    }

    public void setCharEXP(String charEXP) {
        this.charEXP = charEXP;
    }

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }
}
