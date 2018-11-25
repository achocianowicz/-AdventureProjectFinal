package com.example.joydr.adventureprojectfinal;

import java.util.Random;

public class CheckLevel {

    private double expM = 2, expToNextLevel = 100;


    public void levelUp ( String currentEXP){
        double cEXP = Double.parseDouble(currentEXP);
        if(cEXP >= (expToNextLevel)){
          double cLvl = Double.parseDouble( Singleton.getInstance().getCharLevel());
          double nLvl = cLvl + 1;
          String setNewLevel = String.valueOf(nLvl);
            Singleton.getInstance().setCharLevel(setNewLevel);

            expToNextLevel *= expM;
            String newExpToNextLevel = String.valueOf(expToNextLevel);
            Singleton.getInstance().setCharEXPToNextLevel(newExpToNextLevel);
            Singleton.getInstance().setCharCurrentEXP("0");

            int random = new Random().nextInt(3) +1;
            String point = "1";
            switch (random){

                case 1:
                    Singleton.getInstance().setSTRPoint(point);
                    break;
                case 2:
                    Singleton.getInstance().setINTELLPoint(point);
                    break;
                case 3:
                    Singleton.getInstance().setDEXPoint(point);
                    break;

            }



        }


    }
}
