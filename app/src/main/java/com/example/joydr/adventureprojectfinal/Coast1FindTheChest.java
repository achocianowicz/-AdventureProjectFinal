package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Coast1FindTheChest extends AppCompatActivity {

    Button coast1Button = null, coast2Button = null, coast3Button = null, coast4Button = null, cFoundButton = null;

    int expReward = 400, goldReward = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coast1_find_the_chest);

        coast1Button = findViewById(R.id.coast1Button);
        coast2Button = findViewById(R.id.coast2Button);
        coast3Button = findViewById(R.id.coast3Button);
        coast4Button = findViewById(R.id.coast4Button);
        cFoundButton = findViewById(R.id.cFoundButton);

        cFoundButton.setVisibility(View.INVISIBLE);

        final int random = new Random().nextInt(4) +1;

        coast1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 1){
                    coast1Button.setBackgroundResource(R.drawable.chest);
                    coast2Button.setClickable(false);
                    coast3Button.setClickable(false);
                    coast4Button.setClickable(false);
                    cFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    coast1Button.setBackgroundResource(R.drawable.redx);
                    coast1Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }


            }
        });
        coast2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 2){
                    coast2Button.setBackgroundResource(R.drawable.chest);
                    coast1Button.setClickable(false);
                    coast3Button.setClickable(false);
                    coast4Button.setClickable(false);
                    cFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    coast2Button.setBackgroundResource(R.drawable.redx);
                    coast2Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        coast3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 3){
                    coast3Button.setBackgroundResource(R.drawable.chest);
                    coast2Button.setClickable(false);
                    coast1Button.setClickable(false);
                    coast4Button.setClickable(false);
                    cFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    coast3Button.setBackgroundResource(R.drawable.redx);
                    coast3Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        coast4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 4){
                    coast4Button.setBackgroundResource(R.drawable.chest);
                    coast2Button.setClickable(false);
                    coast3Button.setClickable(false);
                    coast1Button.setClickable(false);
                    cFoundButton.setVisibility(View.VISIBLE);
                }

                else{
                    coast4Button.setBackgroundResource(R.drawable.redx);
                    coast4Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });

        cFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setExpReward(expReward);
                Singleton.getInstance().setGoldReward(goldReward);
                Singleton.getInstance().setCoastQuest2Done(true);
                Intent intent = new Intent(v.getContext(), QuestReward.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
    }
}
