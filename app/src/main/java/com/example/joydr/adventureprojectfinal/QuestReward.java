package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class QuestReward extends AppCompatActivity {
TextView requestTitle = null, expReward = null, goldReward = null, LevelUpTextBox = null;
Button questRewardToTownButton = null;
private String nEXP = null, nGold = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_reward);

        requestTitle = findViewById(R.id.requestTitle);
        requestTitle.setText(Singleton.getInstance().getQuestTitle());
        expReward = findViewById(R.id.expReward);
         nEXP = String.valueOf(Singleton.getInstance().getExpReward());
        expReward.setText("EXP reward: " + nEXP);
        // Adding the reward exp to char
        int addingEXP = Integer.parseInt( Singleton.getInstance().getCharCurrentEXP());
        int updatedEXP = addingEXP + Singleton.getInstance().getExpReward();
        String setExp = String.valueOf(updatedEXP);
        Singleton.getInstance().setCharCurrentEXP(setExp);
        // fix below
        Singleton.getInstance().setCharOverallEXP(setExp);

        goldReward = findViewById(R.id.goldReward);


         nGold = String.valueOf(Singleton.getInstance().getGoldReward());
        goldReward.setText("Gold reward: " + nGold);

        LevelUpTextBox =findViewById(R.id.LevelUpTextBox);

        checkLevel();

        questRewardToTownButton = findViewById(R.id.questRewardToTownButton);

        questRewardToTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               int addingGold = Integer.parseInt(Singleton.getInstance().getUserGold());
               int updatingGold = addingGold + Singleton.getInstance().getGoldReward();
               String setGold = String.valueOf(updatingGold);
               Singleton.getInstance().setUserGold(setGold);
                Intent intent = new Intent(v.getContext(), Town.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
    }

    public void checkLevel() {

        int expM = Singleton.getInstance().getExpM(), expToNextLevel = Singleton.getInstance().getExpToNextLevel();

        int updatedEXP = Integer.parseInt(Singleton.getInstance().getCharCurrentEXP());




            if(updatedEXP >= (expToNextLevel)){
                int cLvl = Integer.parseInt( Singleton.getInstance().getCharLevel());
                int oldLevel = cLvl;
                int nLvl = cLvl + 1;
                String setNewLevel = String.valueOf(nLvl);
                Singleton.getInstance().setCharLevel(setNewLevel);
                // new current exp
                int newCurrentEXP = updatedEXP - expToNextLevel;
                String setNewCurrentEXP = String.valueOf(newCurrentEXP);
                Singleton.getInstance().setCharCurrentEXP(setNewCurrentEXP);

                expToNextLevel *= expM;
                Singleton.getInstance().setExpToNextLevel(expToNextLevel);
                String setNextEXP = String.valueOf(expToNextLevel);
                Singleton.getInstance().setCharEXPToNextLevel(setNextEXP);





                int random = new Random().nextInt(3) +1;
                String point = "1";
                switch (random){

                    case 1:
                        int cSTRPoint = Integer.parseInt(Singleton.getInstance().getSTRPoint());
                        cSTRPoint++;
                        String setSTRPoint = String.valueOf(cSTRPoint);
                        Singleton.getInstance().setSTRPoint(setSTRPoint);
                        LevelUpTextBox.setText(" Leveled from Level " + oldLevel + " to Level " + nLvl + " , Got a STR Point!");
                        anotherLevel();
                        break;
                    case 2:
                        int cINTELLPoint = Integer.parseInt(Singleton.getInstance().getINTELLPoint());
                        cINTELLPoint++;
                        String setINTELLPoint = String.valueOf(cINTELLPoint);
                        Singleton.getInstance().setINTELLPoint(setINTELLPoint);
                        LevelUpTextBox.setText(" Leveled from Level " + oldLevel + " to Level " + nLvl + " , Got a INTELL Point!");
                        anotherLevel();
                        break;
                    case 3:
                        int cDEXPoint = Integer.parseInt(Singleton.getInstance().getDEXPoint());
                        cDEXPoint++;
                        String setDEXPoint = String.valueOf(cDEXPoint);
                        Singleton.getInstance().setDEXPoint(setDEXPoint);
                        LevelUpTextBox.setText(" Leveled from Level " + oldLevel + " to Level " + nLvl + " , Got a DEX Point!");
                        anotherLevel();
                        break;

                }



            }

            else{

                //same level
                int cLvl = Integer.parseInt( Singleton.getInstance().getCharLevel());
                int oldLevel = cLvl;
                int nLvl = cLvl + 1;


                LevelUpTextBox.setText(" Still Level " + oldLevel + ".  To Level to " + nLvl + " ,  you need "+ (expToNextLevel- updatedEXP )+" EXP! ");
            }

    }

    public void anotherLevel(){
        int expToNextLevel = Singleton.getInstance().getExpToNextLevel(), charCurrentEXP = Integer.parseInt(Singleton.getInstance().getCharCurrentEXP()); ;
        if( charCurrentEXP >= (expToNextLevel)){
            checkLevel();

        }
        else{

            // no more leveling

        }
    }
}
