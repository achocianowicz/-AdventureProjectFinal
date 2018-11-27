package com.example.joydr.adventureprojectfinal;

import android.arch.lifecycle.SingleGeneratedAdapterObserver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FailQuest extends AppCompatActivity {
    TextView requestTitle = null, expReward = null, goldReward = null, LevelUpTextBox = null;
    Button questRewardToTownButton = null;
    private String nEXP = null, nGold = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail_quest);





        requestTitle = findViewById(R.id.frequestTitle);
        requestTitle.setText(Singleton.getInstance().getQuestTitle());
        expReward = findViewById(R.id.fexpReward);
        nEXP = String.valueOf(Singleton.getInstance().getExpReward());
        expReward.setText("EXP reward: " + nEXP);
        // Adding the reward exp to char
        int addingEXP = Integer.parseInt( Singleton.getInstance().getCharCurrentEXP());
        int updatedEXP = addingEXP + Singleton.getInstance().getExpReward();
        String setExp = String.valueOf(updatedEXP);
        Singleton.getInstance().setCharCurrentEXP(setExp);
        // fix below
        Singleton.getInstance().setCharOverallEXP(setExp);

        goldReward = findViewById(R.id.fgoldReward);


        nGold = String.valueOf(Singleton.getInstance().getGoldReward());
        goldReward.setText("Gold reward: " + nGold);

        LevelUpTextBox =findViewById(R.id.LevelUpTextBox);



        questRewardToTownButton = findViewById(R.id.fquestRewardToTownButton);

        questRewardToTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int addingGold = Integer.parseInt(Singleton.getInstance().getUserGold());
                int updatingGold = addingGold + Singleton.getInstance().getGoldReward();
                String setGold = String.valueOf(updatingGold);
                Singleton.getInstance().setUserGold(setGold);
                Singleton.getInstance().setGoldReward(-1);
                Singleton.getInstance().setExpReward(-1);
                Singleton.getInstance().setQuestTitle("Error124");
                Intent intent = new Intent(v.getContext(), Town.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                Singleton.getInstance().setCharCurrentHP(Singleton.getInstance().getCharBaseHP());
                v.getContext().startActivity(intent);
                finish();
            }
        });
    }


    }

