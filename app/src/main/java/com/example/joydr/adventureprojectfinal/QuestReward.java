package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestReward extends AppCompatActivity {
TextView requestTitle = null, expReward = null, goldReward = null;
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

        goldReward = findViewById(R.id.goldReward);

         nGold = String.valueOf(Singleton.getInstance().getGoldReward());
        goldReward.setText("Gold reward: " + nGold);
        questRewardToTownButton = findViewById(R.id.questRewardToTownButton);

        questRewardToTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int addingEXP = Integer.parseInt( Singleton.getInstance().getCharCurrentEXP());
               int updatedEXP = addingEXP + Singleton.getInstance().getExpReward();
               String setExp = String.valueOf(updatedEXP);
                Singleton.getInstance().setCharCurrentEXP(setExp);

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
}
