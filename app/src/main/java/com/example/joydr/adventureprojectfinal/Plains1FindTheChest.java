package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Plains1FindTheChest extends AppCompatActivity {

    Button plains1Button = null, plains2Button = null, plains3Button = null, plains4Button = null, pFoundButton = null;

    int expReward = 400, goldReward = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plains1_find_the_chest);

        plains1Button = findViewById(R.id.plains1Button);
        plains2Button = findViewById(R.id.plains2Button);
        plains3Button = findViewById(R.id.plains3Button);
        plains4Button = findViewById(R.id.plains4Button);
        pFoundButton = findViewById(R.id.pFoundButton);

        pFoundButton.setVisibility(View.INVISIBLE);

        final int random = new Random().nextInt(4) +1;

        plains1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 1){
                    plains1Button.setBackgroundResource(R.drawable.chest);
                    plains2Button.setClickable(false);
                    plains3Button.setClickable(false);
                    plains4Button.setClickable(false);
                    pFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    plains1Button.setBackgroundResource(R.drawable.redx);
                    plains1Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }


            }
        });
        plains2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 2){
                    plains2Button.setBackgroundResource(R.drawable.chest);
                    plains1Button.setClickable(false);
                    plains3Button.setClickable(false);
                    plains4Button.setClickable(false);
                    pFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    plains2Button.setBackgroundResource(R.drawable.redx);
                    plains2Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        plains3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 3){
                    plains3Button.setBackgroundResource(R.drawable.chest);
                    plains2Button.setClickable(false);
                    plains1Button.setClickable(false);
                    plains4Button.setClickable(false);
                    pFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    plains3Button.setBackgroundResource(R.drawable.redx);
                    plains3Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        plains4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 4){
                    plains4Button.setBackgroundResource(R.drawable.chest);
                    plains2Button.setClickable(false);
                    plains3Button.setClickable(false);
                    plains1Button.setClickable(false);
                    pFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    plains4Button.setBackgroundResource(R.drawable.redx);
                    plains4Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });

        pFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setExpReward(expReward);
                Singleton.getInstance().setGoldReward(goldReward);
                Singleton.getInstance().setPlainsQuest2Done(true);
                Intent intent = new Intent(v.getContext(), QuestReward.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
    }
}
