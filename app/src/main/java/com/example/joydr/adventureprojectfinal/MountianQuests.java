package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MountianQuests extends AppCompatActivity {
    Button mountianQuest1Button = null, mountianQuest2Button = null;
    private boolean forestQuest1Done = false,forestQuest2Done = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountian_quests);

        mountianQuest1Button = findViewById(R.id.mountianQuest1Button);
        mountianQuest2Button = findViewById(R.id.mountianQuest2Button);

        CompletedQuest();

        mountianQuest1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Mountian1Goat1Combat.class);
                Singleton.getInstance().setQuestTitle("Mountian 1 Goat 1");
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);


            }
        });

        mountianQuest2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setQuestTitle("Find Chest in Mountian 1");
                Intent intent = new Intent(v.getContext(), Mountian1FindTheChest.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);


            }
        });

    }

    public void CompletedQuest(){
        forestQuest1Done = Singleton.getInstance().isMountianQuest1Done();
        forestQuest2Done = Singleton.getInstance().isMountianQuest2Done();
        if (forestQuest1Done == true) {
            mountianQuest1Button.setBackgroundResource(R.color.colorAccent);
            mountianQuest1Button.setText("Complete");
            mountianQuest1Button.setClickable(false);
        }
        if (forestQuest2Done == true) {
            mountianQuest2Button.setBackgroundResource(R.color.colorAccent);
            mountianQuest2Button.setText("Complete");
            mountianQuest2Button.setClickable(false);
        }
    }

    @Override
    protected void  onResume() {
        super.onResume();
        CompletedQuest();
    }
}
