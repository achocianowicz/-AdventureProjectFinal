package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Swamp1FindTheChest extends AppCompatActivity {

    Button gravestone1Button = null, gravestone2Button = null, gravestone3Button = null, gravestone4Button = null, sFoundButton = null;

    int expReward = 400, goldReward = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swamp1_find_the_chest);

        gravestone1Button = findViewById(R.id.gravestone1Button);
        gravestone2Button = findViewById(R.id.gravestone2Button);
        gravestone3Button = findViewById(R.id.gravestone3Button);
        gravestone4Button = findViewById(R.id.gravestone4Button);
        sFoundButton = findViewById(R.id.sFoundButton);

        sFoundButton.setVisibility(View.INVISIBLE);

        final int random = new Random().nextInt(4) +1;

        gravestone1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 1){
                    gravestone1Button.setBackgroundResource(R.drawable.chest);
                    gravestone2Button.setClickable(false);
                    gravestone3Button.setClickable(false);
                    gravestone4Button.setClickable(false);
                    sFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    gravestone1Button.setBackgroundResource(R.drawable.redx);
                    gravestone1Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }


            }
        });
        gravestone2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 2){
                    gravestone2Button.setBackgroundResource(R.drawable.chest);
                    gravestone1Button.setClickable(false);
                    gravestone3Button.setClickable(false);
                    gravestone4Button.setClickable(false);
                    sFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    gravestone2Button.setBackgroundResource(R.drawable.redx);
                    gravestone2Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        gravestone3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 3){
                    gravestone3Button.setBackgroundResource(R.drawable.chest);
                    gravestone2Button.setClickable(false);
                    gravestone1Button.setClickable(false);
                    gravestone4Button.setClickable(false);
                    sFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    gravestone3Button.setBackgroundResource(R.drawable.redx);
                    gravestone3Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        gravestone4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 4){
                    gravestone4Button.setBackgroundResource(R.drawable.chest);
                    gravestone2Button.setClickable(false);
                    gravestone3Button.setClickable(false);
                    gravestone1Button.setClickable(false);
                    sFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    gravestone4Button.setBackgroundResource(R.drawable.redx);
                    gravestone4Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });

        sFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setExpReward(expReward);
                Singleton.getInstance().setGoldReward(goldReward);
                Singleton.getInstance().setSwampQuest2Done(true);
                Intent intent = new Intent(v.getContext(), QuestReward.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
    }
}
