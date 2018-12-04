package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlainsQuest extends AppCompatActivity {

    Button plainsQuest1Button = null, plainsQuest2Button = null;
    private boolean forestQuest1Done = false,forestQuest2Done = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plains_quest);

        plainsQuest1Button = findViewById(R.id.plainsQuest1Button);
        plainsQuest2Button = findViewById(R.id.plainsQuest2Button);

        CompletedQuest();

        plainsQuest1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Forest1Bear1Combat.class);
                Singleton.getInstance().setQuestTitle("Plains 1 Loin 1");
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);


            }
        });

        plainsQuest2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setQuestTitle("Find Chest on the Plains 1");
                Intent intent = new Intent(v.getContext(), Plains1FindTheChest.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);


            }
        });

    }

    public void CompletedQuest(){
        forestQuest1Done = Singleton.getInstance().isPlainsQuest1Done();
        forestQuest2Done = Singleton.getInstance().isPlainsQuest2Done();
        if (forestQuest1Done == true) {
            plainsQuest1Button.setBackgroundResource(R.color.colorAccent);
            plainsQuest1Button.setText("Complete");
            plainsQuest1Button.setClickable(false);
        }
        if (forestQuest2Done == true) {
            plainsQuest2Button.setBackgroundResource(R.color.colorAccent);
            plainsQuest2Button.setText("Complete");
            plainsQuest2Button.setClickable(false);
        }
    }

    @Override
    protected void  onResume() {
        super.onResume();
        CompletedQuest();
    }
}
