package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SwampQuests extends AppCompatActivity {

    Button forestQuest1Button = null, forestQuest2Button = null;
    private boolean forestQuest1Done = false,forestQuest2Done = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swamp_quests);

        forestQuest1Button = findViewById(R.id.swampQuest1Button);
        forestQuest2Button = findViewById(R.id.swampQuest2Button);

        CompletedQuest();

        forestQuest1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Swamp1Skeleton1Combat.class);
                Singleton.getInstance().setQuestTitle("Swamp 1 Skeleton 1");
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);


            }
        });

        forestQuest2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setQuestTitle("Find Chest in Swamp 1");
                Intent intent = new Intent(v.getContext(), Swamp1FindTheChest.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);


            }
        });

    }

    public void CompletedQuest(){
        forestQuest1Done = Singleton.getInstance().isSwampQuest1Done();
        forestQuest2Done = Singleton.getInstance().isSwampQuest2Done();
        if (forestQuest1Done == true) {
            forestQuest1Button.setBackgroundResource(R.color.colorAccent);
            forestQuest1Button.setText("Complete");
            forestQuest1Button.setClickable(false);
        }
        if (forestQuest2Done == true) {
            forestQuest2Button.setBackgroundResource(R.color.colorAccent);
            forestQuest2Button.setText("Complete");
            forestQuest2Button.setClickable(false);
        }
    }

    @Override
    protected void  onResume() {
        super.onResume();
        CompletedQuest();
    }
}
