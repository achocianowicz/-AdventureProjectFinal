package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Forest1FindTheChest extends AppCompatActivity {
    Button tree1Button = null, tree2Button = null, tree3Button = null, tree4Button = null, foundButton = null;

    int expReward = 400, goldReward = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forest1_find_the_chest);

        tree1Button = findViewById(R.id.tree1Button);
        tree2Button = findViewById(R.id.tree2Button);
        tree3Button = findViewById(R.id.tree3Button);
        tree4Button = findViewById(R.id.tree4Button);
        foundButton = findViewById(R.id.foundButton);

        foundButton.setVisibility(View.INVISIBLE);

        final int random = new Random().nextInt(4) +1;

        tree1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 1){
                    tree1Button.setBackgroundResource(R.drawable.chest);
                    tree2Button.setClickable(false);
                    tree3Button.setClickable(false);
                    tree4Button.setClickable(false);
                    foundButton.setVisibility(View.VISIBLE);
                }

                else{
                    tree1Button.setBackgroundResource(R.drawable.redx);
                    tree1Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }


            }
        });
        tree2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(random == 2){
                    tree2Button.setBackgroundResource(R.drawable.chest);
                    tree1Button.setClickable(false);
                    tree3Button.setClickable(false);
                    tree4Button.setClickable(false);
                    foundButton.setVisibility(View.VISIBLE);
                }

                else{
                    tree2Button.setBackgroundResource(R.drawable.redx);
                    tree2Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        tree3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 3){
                    tree3Button.setBackgroundResource(R.drawable.chest);
                    tree2Button.setClickable(false);
                    tree1Button.setClickable(false);
                    tree4Button.setClickable(false);
                    foundButton.setVisibility(View.VISIBLE);
                }

                else{
                    tree3Button.setBackgroundResource(R.drawable.redx);
                    tree3Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });
        tree4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 4){
                    tree4Button.setBackgroundResource(R.drawable.chest);
                    tree2Button.setClickable(false);
                    tree3Button.setClickable(false);
                    tree1Button.setClickable(false);
                    foundButton.setVisibility(View.VISIBLE);
                }

                else{
                    tree4Button.setBackgroundResource(R.drawable.redx);
                    tree4Button.setClickable(false);
                    expReward -= 100;
                    goldReward -= 100;
                }

            }
        });

        foundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setExpReward(expReward);
                Singleton.getInstance().setGoldReward(goldReward);
                Singleton.getInstance().setForestQuest2Done(true);
                Intent intent = new Intent(v.getContext(), QuestReward.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
    }
}
