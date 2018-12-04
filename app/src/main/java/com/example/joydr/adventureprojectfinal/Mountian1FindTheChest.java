package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Mountian1FindTheChest extends AppCompatActivity {

    Button boulder1Button = null, boulder2Button = null, boulder3Button = null, boulder4Button = null, mFoundButton = null;

    int expReward = 400, goldReward = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountian1_find_the_chest);

        boulder1Button = findViewById(R.id.boulder1Button);
        boulder2Button = findViewById(R.id.boulder2Button);
        boulder3Button = findViewById(R.id.boulder3Button);
        boulder4Button = findViewById(R.id.boulder4Button);
        mFoundButton = findViewById(R.id.mFoundButton);

        mFoundButton.setVisibility(View.INVISIBLE);

        final int random = new Random().nextInt(4) +1;

        boulder1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 1){
                    boulder1Button.setBackgroundResource(R.drawable.chest);
                    boulder2Button.setClickable(false);
                    boulder3Button.setClickable(false);
                    boulder4Button.setClickable(false);
                    mFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    boulder1Button.setBackgroundResource(R.drawable.redx);
                    boulder1Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }


            }
        });
        boulder2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 2){
                    boulder2Button.setBackgroundResource(R.drawable.chest);
                    boulder1Button.setClickable(false);
                    boulder3Button.setClickable(false);
                    boulder4Button.setClickable(false);
                    mFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    boulder2Button.setBackgroundResource(R.drawable.redx);
                    boulder2Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        boulder3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 3){
                    boulder3Button.setBackgroundResource(R.drawable.chest);
                    boulder2Button.setClickable(false);
                    boulder1Button.setClickable(false);
                    boulder4Button.setClickable(false);
                    mFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    boulder3Button.setBackgroundResource(R.drawable.redx);
                    boulder3Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        boulder4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 4){
                    boulder4Button.setBackgroundResource(R.drawable.chest);
                    boulder2Button.setClickable(false);
                    boulder3Button.setClickable(false);
                    boulder1Button.setClickable(false);
                    mFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    boulder4Button.setBackgroundResource(R.drawable.redx);
                    boulder4Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });

        mFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setExpReward(expReward);
                Singleton.getInstance().setGoldReward(goldReward);
                Singleton.getInstance().setMountianQuest1Done(true);
                Intent intent = new Intent(v.getContext(), QuestReward.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
    }
}
